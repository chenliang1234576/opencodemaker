package com.opensource.maker.output;

import java.util.Map;
import java.util.Map.Entry;

import com.opensource.maker.common.FileUtil;

/***
 * ����ģ���滻����
 * @date      2015.9.8
 * @author  ����
 * ***/
public class TemplateReplaceTool   {
 
	/***
	 * 	  String outFile = "";        // Ŀ���ļ�·��
	      String tempFile = "";      // ģ���ļ�·��
        Map<String,String> keyMap ;  // k��v��Ӧ��ϵ
	 * ***/
	public void  replaceByKeymap(String outFile, String tempFile,
			Map<String, String> keyMap) { 
		  // �����滻,�����ݴ�map�������滻�÷��ؽ��
	      String  result = FileUtil.replaceFormFile(tempFile, keyMap);   
		  FileUtil.createFile(outFile, result); 
	} 
   
	 
	
}
