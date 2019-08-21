package com.bridgelab.designPattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements ISubject {
	private List<IObserver> observer;
	private String message;
	private boolean changed;
	private final Object MUTEX=new Object();
	
	public MyTopic()
	{
		this.observer=new ArrayList<>();
	}
	
	
	@Override
	public void register(IObserver obj) {
		if(obj==null)throw new NullPointerException("Null Observer");
		synchronized (MUTEX)
		{
			if(!observer.contains(obj))
			{
				observer.add(obj);
			}
		}
	}

	@Override
	public void unregister(IObserver obj) {
		synchronized (MUTEX)
		{
			observer.remove(obj);
		}
		
	}

	@Override
	public void notifyObserver() {
		List<IObserver> observerLocal=null;
		synchronized (MUTEX) {
			if(!changed)
			return;
			
			observerLocal=new ArrayList<>(this.observer);
			this.changed=false;
		}
		for(IObserver obj:observerLocal)
		{
			obj.update();
		}
	}

	@Override
	public Object getUpdate(IObserver obj) {
	
		return this.message;
	}
	public void postMessage(String msg)
	{
		System.out.println("Message Posted To Topic :"+msg);
		this.message=msg;
		this.changed=true;
		notifyObserver();
	}
	
}
