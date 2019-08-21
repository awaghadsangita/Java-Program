package com.bridgelab.designPattern.creational.factory;

public class TestFactory {
	public static void main(String args[])
	{
		Computer pc=ComputerFactory.getComputer("PC", "2 GB", "500 GB", "2.4 GHz");
		Computer server=ComputerFactory.getComputer("SERVER", "16GB", "2TB", "2.9 GHz");
		
		System.out.println("Factory PC Confi :"+pc);
		System.out.println("Factory Server Config :"+server);
	}
}
