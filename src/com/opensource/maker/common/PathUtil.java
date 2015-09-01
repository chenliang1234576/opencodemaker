package com.opensource.maker.common;

import java.io.File;
  

/***
 * �ļ�·��������
 * �������룬����ļ��ľ���·��
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public class PathUtil {
  
	/**
	 * ��ȡ��Ŀ·��
	 * **/
	public static String getProjectPath()
	{
		String path = null;
		File directory = new File("");//�趨Ϊ��ǰ�ļ���
		try{
			path = directory.getCanonicalPath(); 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * ��ȡģ��Դ�ļ�·��
	 * **/
	public static String getTemplatePath()
	{
		return  getProjectPath() + File.separator +  "code_template" + File.separator ;
	}
	
	/**
	 * ��ȡĿ��Դ�ļ�·��
	 * **/
	public static String getTargetPath()
	{
		return  getProjectPath() + File.separator +  "code_target" + File.separator ;
	}
	
}
