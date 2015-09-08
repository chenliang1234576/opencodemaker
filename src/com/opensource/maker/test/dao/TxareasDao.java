package com.opensource.maker.test.dao;

import java.sql.SQLException;
import java.util.List; 

import com.opensource.maker.common.BaseDao;
import com.opensource.maker.test.model.Txareas;

public class TxareasDao {

	String sql = "";
	BaseDao dao = BaseDao.getInstance();
	
	/***
	 * 根据各个字段进行查询
	 * ***/ 
	public List<Txareas> queryTxareasByCond(Txareas mod)
	{
		List<Txareas> result = null;
		sql = "select * from txareas where code = "+ mod.getCode()
				  + " or name =  " + mod.getName() 
				  + " or level = " + mod.getLevel()
				  + " or pcode = " + mod.getPcode() 
				  + " or en_city = " + mod.getEnCity();
		   try {
			dao.query(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		return result;
	}
	
	/***
	 * 添加
	 * ***/
	public int saveTxareas(Txareas mod)
	{
		
		return 0;
	}
	
	/***
	 * 修改
	 * ***/
	public int updateTxareas(Txareas mod)
	{
		
		return 0;
	}
	
	/***
	 * 删除
	 * ***/
	public int deleteTxareas(Txareas mod)
	{
		
		return 0;
	}
	

}