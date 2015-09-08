package com.opensource.maker.input;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensource.maker.common.BaseDao;
import com.opensource.maker.common.FileUtil;

/***
 * 表数据转换成对象
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public class TableToObject{
	
	public static Logger log = Logger.getLogger(TableToObject.class);
 
    static BaseDao  dao = BaseDao.getInstance();
    private TableToObject()
    { 
    }
    
    static TableToObject tto ;  
    public static TableToObject getInstance()
    {
    	if(tto == null)
    	{ 
    		tto = new TableToObject();
    		dao.initConn();
    	}
    	return tto;
    }
    
    
    /***
     * 解析table中的数据
     * ***/
    public  String parseTable(String tableName)
    {
    	String result = "";
    	StringBuffer modelClass = new StringBuffer();
    	StringBuffer sb = new StringBuffer();
    	String className = NameParser.toModelName(tableName);
    	modelClass.append("package  model;" );
    	modelClass.append("\n\npublic class " + className +"{ \n\n " );
 //   	modelClass.append(+ className);
    	
    	String iType = "",iName = "";
    	String itemName = "";
    	try {
    		 List<TableModel>  tmodels =	dao.descTable(tableName);
    		 for(TableModel model:tmodels)
    		 {
    			 iType =  NameParser.column2Paramter(model.getColumnType());
    			 iName =  NameParser.toItemName(model.getColumnName());
    			 itemName = "		private " + iType +  " " + iName +";\n";
    			 modelClass.append(itemName);
    			 String getSet = NameParser.createGetSet(iType, iName);
    			 sb.append(getSet);
    		 } 
    		modelClass.append("\n");
    		modelClass.append(sb); 
    		modelClass.append("}");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	result = modelClass.toString();
    	
        log.debug(result);
    	return result;
    }
    
    
   
	
	
}
