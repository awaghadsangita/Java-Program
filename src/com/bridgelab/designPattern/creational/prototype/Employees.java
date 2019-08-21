package com.bridgelab.designPattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
	private List<String> empList;
	public Employees()
	{
		empList=new ArrayList<String>();
	}
	public Employees(List<String> list)
	{
		this.empList=list;
	}
	public void loadDate()
	{
		empList.add("Sangita");
		empList.add("Vaishu");
		empList.add("Priya");
		empList.add("Neeta");
		empList.add("Kavita");
	}
	public List<String> getList()
	{
		return empList;
	}
	@Override
	public Object clone()throws CloneNotSupportedException{
		List<String> tempList=new ArrayList<String>();
		for(String s:empList)
		{
			tempList.add(s);
		}
		return new Employees(tempList);
		
	}
	
}
