package com.bridgelab.designPattern.mediator;

public class ChatClient {
	public static void main(String args[])
	{
		IChatMediator mediator=new ChatMediatorImpl();
		User user1=new UserImpl(mediator,"sangita");
		User user2=new UserImpl(mediator,"Priya");
		User user3=new UserImpl(mediator,"Shubham");
		
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		
		user1.sendMessage("Hi");
		
	}
}
