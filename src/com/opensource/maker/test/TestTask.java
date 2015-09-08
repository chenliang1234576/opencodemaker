package com.opensource.maker.test;

import java.util.ArrayList;
import java.util.List;

class TestTask
{
	/*****
	 * 传递引用，引起数据变化情况
	 * 
	 *       
        List<TestTask>  slist = new ArrayList<TestTask>();
        TestTask tt1 = new TestTask();
        tt1.setS1("chen1");
        tt1.setS2("222");
        
        TestTask tt2 = new TestTask();
        tt2.setS1("chen");
        tt2.setS2("2221");
        
        slist.add(tt1);
        slist.add(tt2);
        
        for(TestTask tt:slist)
        { 
        	System.out.println("-----------" + tt.toString());
        }
        
        for(TestTask tt:slist)
        {
        	 tt.setS1("wang");
        }
        
        for(TestTask tt:slist)
        { 
        	System.out.println("****" + tt.toString());
        }
	 * ****/
	
	private String s1;
	private String s2;
	 
	public String toString()
	{
		return s1 + "," + s2;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	} 
}