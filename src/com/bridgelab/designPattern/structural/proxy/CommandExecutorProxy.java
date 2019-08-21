package com.bridgelab.designPattern.structural.proxy;

import java.io.IOException;

public class CommandExecutorProxy implements ICommandExecutor{
	private boolean isAdmin;
	private ICommandExecutor executor;
	
	public CommandExecutorProxy(String user,String pwd)
	{
		if("Sangita".equalsIgnoreCase(user)&& "sangita123".equals(pwd))
		{
			isAdmin=true;
		}
		executor=new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) throws IOException {
		if(isAdmin)
		{
			executor.runCommand(cmd);
		}
		else if(cmd.trim().startsWith("rm"))
		{
			System.out.println("you can not execute "+cmd);
		}
		else
		{
			executor.runCommand(cmd);
		}
	}
	
	
}
