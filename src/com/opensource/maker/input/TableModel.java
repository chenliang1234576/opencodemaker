package com.opensource.maker.input;

/***
 * 表结构模块
 * ***/
public class TableModel {
	
	  private String   columnName;  // 列名称
	  private String   columnType; // 列类型
	  private int       dataSize ; // 数据大小 
	  private int       digits; // 小数位
	  private int       nullable; // 是否可以为空 
	  
	  
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public int getDataSize() {
		return dataSize;
	}
	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	public int getDigits() {
		return digits;
	}
	public void setDigits(int digits) {
		this.digits = digits;
	}
	public int getNullable() {
		return nullable;
	}
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

	  

}
