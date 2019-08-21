package com.bridgelab.designPattern.structural.proxy;

public class ProxyPatternTest {

	public static void main(String args[])
	{
		CommandExecutorProxy executor=new CommandExecutorProxy("sangita","Sangita123");
		try
		{
			executor.runCommand("ls -ltr");
			executor.runCommand("rm abc.txt");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
