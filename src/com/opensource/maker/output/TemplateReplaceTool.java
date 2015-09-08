package com.opensource.maker.output;

import java.util.Map;
import java.util.Map.Entry;

import com.opensource.maker.common.FileUtil;

/***
 * 数据模板替换工具
 * @date      2015.9.8
 * @author  陈良
 * ***/
public class TemplateReplaceTool   {
 
	/***
	 * 	  String outFile = "";        // 目标文件路径
	      String tempFile = "";      // 模板文件路径
        Map<String,String> keyMap ;  // k，v对应关系
	 * ***/
	public void  replaceByKeymap(String outFile, String tempFile,
			Map<String, String> keyMap) { 
		  // 数据替换,把数据从map对象中替换好返回结果
	      String  result = FileUtil.replaceFormFile(tempFile, keyMap);   
		  FileUtil.createFile(outFile, result); 
	} 
   
	 
	
}
