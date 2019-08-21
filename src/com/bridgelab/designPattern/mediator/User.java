package com.bridgelab.designPattern.mediator;

public abstract class User {
	protected IChatMediator mediator;
	protected String name;
	
	public User(IChatMediator mediator,String name)
	{
		this.mediator=mediator;
		this.name=name;
	}
	public abstract void sendMessage(String msg);
	public abstract void receivedMessage(String msg);
	

}
