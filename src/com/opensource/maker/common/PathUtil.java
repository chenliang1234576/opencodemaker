package com.opensource.maker.common;

import java.io.File;
  

/***
 * 文件路径工具类
 * 包括输入，输出文件的绝对路径
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public class PathUtil {
  
	/**
	 * 获取项目路径
	 * **/
	public static String getProjectPath()
	{
		String path = null;
		File directory = new File("");//设定为当前文件夹
		try{
			path = directory.getCanonicalPath(); 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 获取模板源文件路径
	 * **/
	public static String getTemplatePath()
	{
		return  getProjectPath() + File.separator +  "code_template" + File.separator ;
	}
	
	/**
	 * 获取目标源文件路径
	 * **/
	public static String getTargetPath()
	{
		return  getProjectPath() + File.separator +  "code_target" + File.separator ;
	}
	
}
