package com.bridgelab.designPattern;

public class MyTopicSubscriber implements IObserver {
	private String name;
	private ISubject topic;
	
	public MyTopicSubscriber(String name) {
		this.name=name;
	}
	@Override
	public void update() {
		Object msg= topic.getUpdate(this);
		if(msg==null)
		{
			System.out.println(name+":: No New Messge");
		}
		else
		{
			System.out.println(name+":: consuming message"+msg);
		}
		
	}

	@Override
	public void setSubject(ISubject obj) {
		this.topic=obj;
		
	}

}
