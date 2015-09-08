package com.opensource.maker.input;

/***
 * ����ת�ɶ�Ӧ���ļ���
 * 
 * @date      2015.8.28
 * @author  ����
 * ***/
public class NameParser {

	/***
	 * tablename ת���� modelname
	 * 
	 * txareas_hello -->TxareasHello
	 * ***/
	public static String toModelName(String tableName)
	{
		String  mName = "";
        StringBuffer sb = new StringBuffer();
        boolean isUpperCase = false;
        char[] clist = tableName.toCharArray();
		for(int i=0;i < clist.length;i++)
		{
			char c = clist[i];
		    if(i == 0 || isUpperCase)
		    {
		    	sb.append(Character.toUpperCase(c));
		        isUpperCase = false;
		    }else if(c == '_'){
		    	isUpperCase = true;
		    }else{
		    	sb.append(c);
		    }
		}
		// ����ĸ��д
		mName = sb.toString();
		return mName;
	}
	
	/***
	 * colunmName ת���� itemname
	 * 
	 * txareas_hello -->txareasHello
	 * ***/
	public static String toItemName(String colunmName)
	{
		String  mName = "";
        StringBuffer sb = new StringBuffer();
        boolean isUpperCase = false;
        char[] clist = colunmName.toCharArray();
		for(int i=0;i < clist.length;i++)
		{
		   char c = clist[i];
		   if(i == 0  )
		   { // ��һ����ĸ����Сд
			    	sb.append(Character.toLowerCase(c)); 
			}else if(isUpperCase) { // �м����»��ܣ�������һ����ĸ�����д
		    	sb.append(Character.toUpperCase(c));
		        isUpperCase = false;
		    }else if(c == '_'){
		    	isUpperCase = true;
		    }else{
		    	sb.append(c);
		    }
		}
		// ����ĸ��д
		mName = sb.toString();
		return mName;
	} 
	/***
	 * ����ת��
	 * ������ ת���� ��������
	 * ***/
	public static String column2Paramter(String columnType)
	{
		String pType = "";
		String ss = columnType.toLowerCase();
		if(ss.contains("char") || ss.contains("text"))
		{// �ַ���
			pType = "String";
		}else if(ss.equals("int"))
		{
			pType = "int";
		}else if(ss.equals("long"))
		{
			pType = "long";
		}else if(ss.equals("float"))
		{
			pType = "float";
		}else if(ss.equals("double"))
		{
			pType = "double";
		} else if(ss.contains("date") || ss.contains("time"))
		{
			pType = "Date";
		} 
		return pType;
	}
	
	/****
	 * ���ɶ�Ӧ��get��set����
	 * 
	 * item Ԫ����
	 * type ����
	 * ****/
	public static String  createGetSet(String type,String item)
	{
		StringBuffer sb = new StringBuffer();
		String itemP = toModelName(item);
		sb.append("		public " + type + " get" + itemP + "(){\n");
		sb.append("				return "  + item + "; \n		}\n");  
		sb.append("		public void set" + itemP + "(" + type + " "+ item + "){\n");
		sb.append("				this." + item  + "="  + item + "; \n		}\n\n");  
		return sb.toString(); 
	}
	
}
