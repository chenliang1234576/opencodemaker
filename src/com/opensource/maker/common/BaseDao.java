package com.opensource.maker.common;

import java.sql.Connection;  
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.opensource.maker.common.db.DataSourceUtil;
import com.opensource.maker.input.TableModel;
 

/***
 * 数据操作基础类
 * 包括输入，输出文件的绝对路径
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public class BaseDao {
 
	Connection conn = null;
    Statement stmt = null;
    static BaseDao dao ; 
    
    public static BaseDao getInstance()
    {
    	if(dao == null)
    	{
    		dao = new BaseDao();
    	}
    	return dao;
    }
	
	public Connection getConnection()
	{
		try {
			if(conn == null || conn.isClosed())
			{  
				conn = initConn(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	}
	
	public void closeConnSment()
	{
		 try {
		 		if(conn != null)
				{
					conn.close();
				} 
		 		if(stmt != null)
				{
		 			stmt.close();
				} 
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	 public Connection initConn()
	 {   
			try {
			    DataSource dataSource = DataSourceUtil.getDataSource(DataSourceUtil.DRUID_MYSQL_SOURCE); 
				conn =  dataSource.getConnection(); 
				return conn;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	 }
	 
	 public int execute( String sql) throws SQLException
	 {
	     stmt = conn.createStatement();
         return		 stmt.executeUpdate(sql); 
	 }
	 
	 public ResultSet query(String sql) throws SQLException
	 {
	     stmt = conn.createStatement();
         return	  stmt.executeQuery(sql);
	 }
	 
	 public void queryTableDesc(String dbName) throws SQLException
	 {
	 	  String columnName;
		  String columnType;
		  DatabaseMetaData    m_DBMetaData = conn.getMetaData();
		  ResultSet colRet = m_DBMetaData.getColumns(null,"%", dbName,"%");
		  while(colRet.next()) {
		   columnName = colRet.getString("COLUMN_NAME");
		   columnType = colRet.getString("TYPE_NAME");
		   int datasize = colRet.getInt("COLUMN_SIZE");
		   int digits = colRet.getInt("DECIMAL_DIGITS");
		   int nullable = colRet.getInt("NULLABLE");  
		   System.out.println(columnName+" "+columnType+" "+datasize+" "+digits+" "+
		     nullable);
		  }
	 }
	 
	 
	 public  List<TableModel> descTable(String tableName) throws SQLException
	 {
		 List<TableModel>  tmodels = new ArrayList<TableModel>();
	
	 	  String columnName;
		  String columnType;
		  DatabaseMetaData    m_DBMetaData = conn.getMetaData();
		  ResultSet colRet = m_DBMetaData.getColumns(null,"%", tableName,"%");
		  while(colRet.next()) {
				   columnName = colRet.getString("COLUMN_NAME");
				   columnType = colRet.getString("TYPE_NAME");
				   int datasize = colRet.getInt("COLUMN_SIZE");
				   int digits = colRet.getInt("DECIMAL_DIGITS");
				   int nullable = colRet.getInt("NULLABLE");   
//				   System.out.println(columnName+" "+columnType+" "
//				                              +datasize+" "+digits+" "+ nullable);
		   	       TableModel tm = new TableModel();
		           tm.setColumnName(columnName);
		           tm.setColumnType(columnType);
		           tm.setDataSize(datasize);
		           tm.setDigits(digits);
		           tm.setNullable(nullable); 
		           tmodels.add(tm);
		  } 
		  return tmodels;
	 }
	
}
