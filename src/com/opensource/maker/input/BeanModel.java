package com.opensource.maker.input;

/***
 *  对象模型
 * ***/
public class BeanModel {
	
	  private String   beanName;         // bean名称 
	  private String   itemName;          // 列名称
	  private String   itemType;           // 列类型 
	  
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	   

}
