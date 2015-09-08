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
 * 测试入口
 * 
 * @date      2015.8.28
 * @author  陈良
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
//			// 查询数据
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
 
    // 获取所有的城市
	 public   List<String> queryAllCity(BaseDao dao)
	 {
		    List<String> result = new ArrayList<String>(); 
		    String	sql3 = "SELECT * FROM txareas WHERE LENGTH(CODE) < 6  and level = 2";
		    		
//		    		   "select * from txareas where (`level` = 2 and name not in ('区','县','省直辖县级行政区划','市辖区','自治区直辖县级行政区划') ) " +
//		    	      "or (level = 1  and name not like '%省')" ;
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
				try { // 关闭资源 
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
    *         // 记录debug级别的信息  
        logger.debug("This is debug message from Dao.");  
        // 记录info级别的信息  
        logger.info("This is info message from Dao.");  
        // 记录error级别的信息  
        logger.error("This is error message from Dao.");  
    * 
    * 
    * **/
    
}
