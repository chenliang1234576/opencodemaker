package com.opensource.maker.output;

import java.util.Map;

/***
 * 文件生成工具
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public interface MakeFile {

	// 根据文件规则，把源文件替换掉新文件中
	public boolean replacePage(String srcPath,String targetPath,Map<String,String> map);	
	// 根据模型生成数据库操作
	public boolean createDaoByModel(String obj,String name);
	// 根据模型生成数据库操作
	public boolean createModel(String obj,String name);
	
	// 根据模型生成业务
	public boolean createServiceByModel(Object obj,String tPath);
	// 根据模型生成控制
	public boolean createControllerByModel(Object obj,String tPath);
	 
	/***
	 *  直接copy文件 
	 *  spath  源文件
	 *  tpath   目标文件
	 * ***/
	public boolean copyFiles(String spath,String tpath); 
	
	/***
	 *  直接copy文件 
	 *  spath  源文件夹，包括文件
	 *  tpath   目标文件夹，包括文件
	 * ***/
	public boolean copyFolder(String spath,String tpath); 
	
	
}