package com.opensource.maker.input;

import java.io.File;

import com.opensource.maker.common.PathUtil;

/***
 * 需要转换的文件目录和文件名 
 * ***/
public class InputFileList {
	// 共同目录，不改变目录和文件内容，直接copy
	public static String COMM_IN = PathUtil.getTemplatePath() +  "comm" + File.separator;
	public static String COMM_OUT = PathUtil.getTargetPath() +  "comm" + File.separator;
	
}
