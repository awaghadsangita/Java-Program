package com.bridgelab.designPattern.structural.proxy;

import java.io.IOException;

public interface ICommandExecutor {
	public void runCommand(String cmd) throws IOException;
}
