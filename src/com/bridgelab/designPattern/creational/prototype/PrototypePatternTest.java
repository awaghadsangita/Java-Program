package com.bridgelab.designPattern.creational.prototype;

import java.util.List;

public class PrototypePatternTest {

	public static void main(String args[]) throws CloneNotSupportedException
	{
		Employees empObj=new Employees();
		empObj.loadDate();
		
		Employees empNewObj=(Employees)empObj.clone();
		Employees empNewObj1=(Employees)empObj.clone();
		
		List<String> list=empNewObj.getList();
		list.add("Kishor");
		
		List<String> list2=empNewObj1.getList();
		list2.add("Sham");
		
		System.out.println("List "+empObj.getList());
		System.out.println("List1 "+empNewObj.getList());
		System.out.println("List2 "+empNewObj1.getList());
	}
}
