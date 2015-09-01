package com.opensource.maker.main;

import com.opensource.maker.common.PathUtil;
import com.opensource.maker.input.InputFileList;
import com.opensource.maker.input.NameParser;
import com.opensource.maker.input.TableToObject;
import com.opensource.maker.output.MakeFile;
import com.opensource.maker.output.MakeFileImpl;


/***
 * 程序入口
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public class StartCoderMaker {

	 MakeFile mf = new MakeFileImpl();  // 文件创建工具
	public static void main(String[] args) {
	// TODO Auto-generated method stub 
		StartCoderMaker scm = new StartCoderMaker();
		scm.buildCommFiles();
		 
}
	
	/***
	 * 创建公共区域文件
	 * ***/
	public void buildCommFiles()
	{  
		mf.copyFiles(InputFileList.COMM_IN, InputFileList.COMM_OUT);
	}
	
	/***
	 * 创建Model层代码
	 * ***/
	public void buildModelFiles()
	{ 
		TableToObject tto =   TableToObject.getInstance();
		String tableName = "txareas"; 
		String clsName = NameParser.toModelName(tableName);
         String modelStr =   tto.parseTable(tableName); 
		 mf.createModel(modelStr, clsName);
	}
	
	
}
