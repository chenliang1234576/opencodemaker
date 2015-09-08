package com.opensource.maker.output;

import java.util.Map;

/***
 * �ļ����ɹ���
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public interface MakeFile {

	// �����ļ����򣬰�Դ�ļ��滻�����ļ���
	public boolean replacePage(String srcPath,String targetPath,Map<String,String> map);	
	// ����ģ���������ݿ����
	public boolean createDaoByModel(String obj,String name);
	// ����ģ���������ݿ����
	public boolean createModel(String obj,String name);
	
	// ����ģ������ҵ��
	public boolean createServiceByModel(Object obj,String tPath);
	// ����ģ�����ɿ���
	public boolean createControllerByModel(Object obj,String tPath);
	 
	/***
	 *  ֱ��copy�ļ� 
	 *  spath  Դ�ļ�
	 *  tpath   Ŀ���ļ�
	 * ***/
	public boolean copyFiles(String spath,String tpath); 
	
	/***
	 *  ֱ��copy�ļ� 
	 *  spath  Դ�ļ��У������ļ�
	 *  tpath   Ŀ���ļ��У������ļ�
	 * ***/
	public boolean copyFolder(String spath,String tpath); 
	
	
}