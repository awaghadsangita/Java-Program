package com.bridgelab.designPattern.behavioral.observer;

public class MyTopicSubscriber implements IObserver{

	private String name;
	private ISubject topic;
	public MyTopicSubscriber(String name)
	{
		this.name=name;
	}
	@Override
	public void update() {
		String msg=(String)topic.getUpdate(this);
		if(msg==null)
			System.out.println("No New Message Posted");
		else
			System.out.println(name+" Consuming message "+msg);
		
		
	}

	@Override
	public void setSubject(ISubject sub) {
		this.topic=sub;
	}

}
