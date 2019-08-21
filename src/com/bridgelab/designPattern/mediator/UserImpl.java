package com.bridgelab.designPattern.mediator;

public class UserImpl extends User{
	
	public UserImpl(IChatMediator mediator,String name)
	{
		super(mediator,name);
	}

	@Override
	public void sendMessage(String msg) {
		System.out.println(this.name+" sending Message "+msg);
		mediator.sendMessage(msg, this);
		
	}

	@Override
	public void receivedMessage(String msg) {
		System.out.println(this.name+" receiving Message "+msg);
		
	}

	
}
