package com.opensource.maker.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;


/***
 * �ļ�����
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public class FileUtil {
	public static Logger logger = Logger.getLogger(FileUtil.class);
	public static Set<String> sets = new HashSet<String>();

	public static void main(String[] args) {
		refreshFileList("G:\\Music");
		//moveFolder("G:\\music\\�ܽ���", "E:\\Kugou");
	}

	/**
	 * ����MP3�ļ�
	 * 
	 * @param strPath
	 */
	public static void refreshFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				refreshFileList(files[i].getAbsolutePath());
			} else {
				String strFilePath = files[i].getAbsolutePath().toLowerCase();
				String strName = files[i].getName();
				if (strName.endsWith(".mp3")) {
					boolean bFlag = sets.add(strName);
					if (bFlag == Boolean.FALSE) {
						// ɾ���ظ��ļ�
						removeFile(strFilePath);
					}
				}
				// System.out.println("FILE_PATH:" + strFilePath + "|strName:" +
				// strName);
			}
		}
	}

	/**
	 * �����ļ���
	 * 
	 * @param strFilePath
	 *            �ļ���·��
	 */
	public boolean mkdirFolder(String strFilePath) {
		boolean bFlag = false;
		try {
			File file = new File(strFilePath.toString());
			if (!file.exists()) {
				bFlag = file.mkdir();
			}
		} catch (Exception e) {
			logger.error("�½�Ŀ¼��������" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return bFlag;
	}

	public static boolean createFile(String strFilePath, String strFileContent) {
		boolean bFlag = false;
		try {
			File file = new File(strFilePath.toString());
			if (!file.exists()) {
				bFlag = file.createNewFile();
			}
			if (bFlag == Boolean.TRUE) {
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(strFileContent.toString());
				pw.close();
			}
		} catch (Exception e) {
			logger.error("�½��ļ���������" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return bFlag;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param strFilePath
	 * @return
	 */
	public static boolean removeFile(String strFilePath) {
		boolean result = false;
		if (strFilePath == null || "".equals(strFilePath)) {
			return result;
		}
		File file = new File(strFilePath);
		if (file.isFile() && file.exists()) {
			result = file.delete();
			if (result == Boolean.TRUE) {
				logger.debug("[REMOE_FILE:" + strFilePath + "ɾ���ɹ�!]");
			} else {
				logger.debug("[REMOE_FILE:" + strFilePath + "ɾ��ʧ��]");
			}
		}
		return result;
	}

	/**
	 * ɾ���ļ���(�����ļ����е��ļ����ݣ��ļ���)
	 * 
	 * @param strFolderPath
	 * @return
	 */
	public static boolean removeFolder(String strFolderPath) {
		boolean bFlag = false;
		try {
			if (strFolderPath == null || "".equals(strFolderPath)) {
				return bFlag;
			}
			File file = new File(strFolderPath.toString());
			bFlag = file.delete();
			if (bFlag == Boolean.TRUE) {
				logger.debug("[REMOE_FOLDER:" + file.getPath() + "ɾ���ɹ�!]");
			} else {
				logger.debug("[REMOE_FOLDER:" + file.getPath() + "ɾ��ʧ��]");
			}
		} catch (Exception e) {
			logger.error("FLOADER_PATH:" + strFolderPath + "ɾ���ļ���ʧ��!");
			e.printStackTrace();
		}
		return bFlag;
	}

	/**
	 * �Ƴ������ļ�
	 * 
	 * @param strPath
	 */
	public static void removeAllFile(String strPath) {
		File file = new File(strPath);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] fileList = file.list();
		File tempFile = null;
		for (int i = 0; i < fileList.length; i++) {
			if (strPath.endsWith(File.separator)) {
				tempFile = new File(strPath + fileList[i]);
			} else {
				tempFile = new File(strPath + File.separator + fileList[i]);
			}
			if (tempFile.isFile()) {
				tempFile.delete();
			}
			if (tempFile.isDirectory()) {
				removeAllFile(strPath + "/" + fileList[i]);// ��ɾ���ļ���������ļ�
				removeFolder(strPath + "/" + fileList[i]);// ɾ���ļ���
			}
		}
	}

	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // �ֽ��� �ļ���С
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				logger.debug("[COPY_FILE:" + oldfile.getPath() + "�����ļ��ɹ�!]");
			}
		} catch (Exception e) {
			System.out.println("���Ƶ����ļ��������� ");
			e.printStackTrace();
		}
	}

	public static void copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); // ����ļ��в����� �������ļ���
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/ " + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
					logger.debug("[COPY_FILE:" + temp.getPath() + "�����ļ��ɹ�!]");
				}
				if (temp.isDirectory()) {// ��������ļ���
					copyFolder(oldPath + "/ " + file[i], newPath + "/ "
							+ file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("���������ļ������ݲ������� ");
			e.printStackTrace();
		}
	}

	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		//removeFile(oldPath);
	}

	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		//removeFolder(oldPath);
	}
	
	/***
	 * ��ȡ���� 
	 * ***/
	public static String loadFormFile(String filePath)
	{  
		String result = "";
		StringBuffer sbf = new StringBuffer();
		FileInputStream f;
		try {  
				f = new FileInputStream(filePath);
				BufferedReader dr=new BufferedReader(new InputStreamReader(f));
				String line =  "";
				while((line = dr.readLine())!= null){ 
							System.out.println("loadKeys-->" + line);   
						    sbf.append(line);
				}  
				result = sbf.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ�ļ����ݲ������� ");
			e.printStackTrace();
		}  
		return result;
	}
	
	// ��ȡ���
	public static String replaceFormFile(String filePath,Map<String, String> keyMap)
	{  
		String result = "";
		StringBuffer sbf = new StringBuffer();
		FileInputStream f;
		try {  
				f = new FileInputStream(filePath);
				BufferedReader dr=new BufferedReader(new InputStreamReader(f));
				String line =  "";
				String key="",value = "";
				while((line = dr.readLine())!= null){ 
							   System.out.println("loadKeys-->" + line);   
							   for (final Entry<String, String> entry : keyMap.entrySet()) 
						        { 
								     key = entry.getKey();
								     value = entry.getValue();
						             line = line.replace(key, value) ;
						        }  
						       sbf.append(line +"\n");
				}  
				result = sbf.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ�ļ����ݲ������� ");
			e.printStackTrace();
		}  
		return result;
	}
}
