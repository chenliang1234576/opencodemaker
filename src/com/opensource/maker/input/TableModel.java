package com.opensource.maker.input;

/***
 * ��ṹģ��
 * ***/
public class TableModel {
	
	  private String   columnName;  // ������
	  private String   columnType; // ������
	  private int       dataSize ; // ���ݴ�С 
	  private int       digits; // С��λ
	  private int       nullable; // �Ƿ����Ϊ�� 
	  
	  
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
