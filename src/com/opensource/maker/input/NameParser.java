package com.opensource.maker.input;

/***
 * 表明转成对应的文件名
 * 
 * @date      2015.8.28
 * @author  陈良
 * ***/
public class NameParser {

	/***
	 * tablename 转换成 modelname
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
		// 首字母大写
		mName = sb.toString();
		return mName;
	}
	
	/***
	 * colunmName 转换成 itemname
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
		   { // 第一个字母必须小写
			    	sb.append(Character.toLowerCase(c)); 
			}else if(isUpperCase) { // 中间有下滑杠，必须下一个字母必须大写
		    	sb.append(Character.toUpperCase(c));
		        isUpperCase = false;
		    }else if(c == '_'){
		    	isUpperCase = true;
		    }else{
		    	sb.append(c);
		    }
		}
		// 首字母大写
		mName = sb.toString();
		return mName;
	} 
	/***
	 * 类型转换
	 * 表类型 转换成 参数类型
	 * ***/
	public static String column2Paramter(String columnType)
	{
		String pType = "";
		String ss = columnType.toLowerCase();
		if(ss.contains("char") || ss.contains("text"))
		{// 字符串
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
	 * 生成对应的get，set方法
	 * 
	 * item 元素名
	 * type 类型
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
