package com.opensource.maker.main;

import com.opensource.maker.common.PathUtil;
import com.opensource.maker.input.InputFileList;
import com.opensource.maker.input.NameParser;
import com.opensource.maker.input.TableToObject;
import com.opensource.maker.output.MakeFile;
import com.opensource.maker.output.MakeFileImpl;


/***
 * �������
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public class StartCoderMaker {

	 MakeFile mf = new MakeFileImpl();  // �ļ���������
	public static void main(String[] args) {
	// TODO Auto-generated method stub 
		StartCoderMaker scm = new StartCoderMaker();
		scm.buildCommFiles();
		 
}
	
	/***
	 * �������������ļ�
	 * ***/
	public void buildCommFiles()
	{  
		mf.copyFiles(InputFileList.COMM_IN, InputFileList.COMM_OUT);
	}
	
	/***
	 * ����Model�����
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
