package com.bridgelab.designPattern.mediator;

public interface IChatMediator {
	public void sendMessage(String msg,User user);
	public void addUser(User user);
	
}
