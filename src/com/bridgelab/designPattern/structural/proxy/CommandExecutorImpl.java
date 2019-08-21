package com.bridgelab.designPattern.structural.proxy;

import java.io.IOException;

public class CommandExecutorImpl implements ICommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
		Runtime.getRuntime().exec(cmd);
		System.out.println(cmd+" is executed");
		
	}

}
