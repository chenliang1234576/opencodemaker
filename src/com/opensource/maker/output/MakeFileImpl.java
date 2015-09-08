/**
 * 
 */
package com.opensource.maker.output;

import java.io.File;
import java.util.Map;

import com.opensource.maker.common.FileUtil;
import com.opensource.maker.common.PathUtil;

/**
 * @author cl
 *
 */
public class MakeFileImpl implements MakeFile {

	/* (non-Javadoc)
	 * @see com.opensource.maker.output.MakeFile#replacePage(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public boolean replacePage(String srcPath, String targetPath,
			Map<String, String> map) {
		// TODO Auto-generated method stub
	    String  result = FileUtil.replaceFormFile(srcPath, map);   
			  FileUtil.createFile(targetPath, result); 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.opensource.maker.output.MakeFile#createDaoByModel(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean createDaoByModel(String obj, String fileName) {
		// TODO Auto-generated method stub
	    String tPath =	PathUtil.getTargetPath() +  File.separator  + "dao" 
	    						+ File.separator  + fileName + ".java";
		FileUtil.createFile(obj, tPath);
		return false;
	}

	/* (non-Javadoc)
	 * @see com.opensource.maker.output.MakeFile#createServiceByModel(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean createServiceByModel(Object obj, String tPath) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.opensource.maker.output.MakeFile#createControllerByModel(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean createControllerByModel(Object obj, String tPath) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * 复制文件，包括文件夹
	 * @see com.opensource.maker.output.MakeFile#copyFiles(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean copyFiles(String spath, String tpath) {
		// TODO Auto-generated method stub
		FileUtil.copyFile(spath, tpath);
		return false;
	}

	@Override
	public boolean copyFolder(String spath, String tpath) {
		// TODO Auto-generated method stub
		FileUtil.copyFolder(spath, tpath);
		return false;
	}

	@Override
	public boolean createModel(String obj, String name) {
		// TODO Auto-generated method stub
		   String tPath =	PathUtil.getTargetPath()  + "model" 
					+ File.separator  + name + ".java";
		   System.out.println("-----" + tPath);
           FileUtil.createFile(tPath,obj);
		   return false;
	}

}
