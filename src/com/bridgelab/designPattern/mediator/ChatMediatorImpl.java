package com.bridgelab.designPattern.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements IChatMediator {

	private List<User> user;
	public ChatMediatorImpl()
	{
		this.user=new ArrayList<User>();
	}
	@Override
	public void sendMessage(String msg, User user) {
		for(User u:this.user)
		{
			if(u!=user)
			{
				u.receivedMessage(msg);
			}
		}
		
	}

	@Override
	public void addUser(User user) {
		this.user.add(user);
		
	}

}
