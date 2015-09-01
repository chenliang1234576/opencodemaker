package com.opensource.maker.test;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;
import com.opensource.maker.common.BaseDao;
import com.opensource.maker.common.PathUtil;
import com.opensource.maker.common.db.DataSourceUtil;
import com.opensource.maker.input.NameParser;
import com.opensource.maker.input.TableToObject;

/***
 * �������
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public class Test {

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		 String pu = PathUtil.getTargetPath();
//		 System.out.println(pu);
//	}

	private static Logger logger = Logger.getLogger(Test.class);  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	
    	TableToObject tto =   TableToObject.getInstance();
        tto.parseTable("txareas");
       // System.out.println("txareas_hello -->" + NameParser.toModelName("txareas_hello"));
  
//    	Test test = new Test();
//   	  try {
//   		    BaseDao bdao = BaseDao.getInstance();
//   		    bdao.initConn();
//// 			Connection conn =  bdao.getConnection();
////			if(conn != null)
////			{
////				System.out.print("ok");
////			}
//			// ��ѯ����
//   		  //  test.queryAllCity(bdao);
//			
//   		    bdao.queryTableDesc("txuser");
//   		    /***
//   		     * userid VARCHAR 50 0 0
//username VARCHAR 50 0 1
//userpass VARCHAR 50 0 1
//supplierid VARCHAR 50 0 1
//province INT 10 0 1
//city INT 10 0 1
//county INT 10 0 1
//addtime TIMESTAMP 19 0 1
//countries VARCHAR 100 0 1
//time_zone VARCHAR 50 0 1
//   		     * ***/
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	  
    	  
    }  
 
    // ��ȡ���еĳ���
	 public   List<String> queryAllCity(BaseDao dao)
	 {
		    List<String> result = new ArrayList<String>(); 
		    String	sql3 = "SELECT * FROM txareas WHERE LENGTH(CODE) < 6  and level = 2";
		    		
//		    		   "select * from txareas where (`level` = 2 and name not in ('��','��','ʡֱϽ�ؼ���������','��Ͻ��','������ֱϽ�ؼ���������') ) " +
//		    	      "or (level = 1  and name not like '%ʡ')" ;
		    ResultSet rs3 = null;
			try {
				rs3 = dao.query(sql3);
				int querySize = 0;
				while(rs3.next())
			   {   querySize++;
					String cityName = rs3.getString("en_city");
				    logger.info(" city name: " + cityName );
					result.add(cityName );
			    }  
				logger.info(" query city size: " + querySize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally
			{
				try { // �ر���Դ 
					if(rs3 != null)
					{
						rs3.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  
		     return result;
	 }  
    
    /**** test log4j ***/
   /**
    * 
    *         // ��¼debug�������Ϣ  
        logger.debug("This is debug message from Dao.");  
        // ��¼info�������Ϣ  
        logger.info("This is info message from Dao.");  
        // ��¼error�������Ϣ  
        logger.error("This is error message from Dao.");  
    * 
    * 
    * **/
    
}
