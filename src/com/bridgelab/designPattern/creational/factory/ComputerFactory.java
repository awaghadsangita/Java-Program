package com.bridgelab.designPattern.creational.factory;

public class ComputerFactory {
	public static Computer getComputer(String type,String ram,String hdd,String cpu)
	{
		if("PC".equalsIgnoreCase(type))
		{
			return new PC(ram,cpu,hdd);
		}
		else if("SERVER".equalsIgnoreCase(type))
		{
			return new Server(ram,cpu,hdd);
		}
		return null;
	}
}
