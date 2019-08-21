package com.bridgelab.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements ISubject {
	
	private List<IObserver> observer;
	private String message;
	private boolean changed;
	private final Object MUTEX=new Object();
	
	public MyTopic() {
		observer=new ArrayList<>();
	}
	@Override
	public void register(IObserver obj) {
		if(obj==null)
			throw new NullPointerException("null Observer");
		synchronized (MUTEX) {
		if(!observer.contains(obj))
			observer.add(obj);
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
	public void notifyUpdate() {
		List<IObserver> observerLocal=null;
		
		synchronized (MUTEX) {
			if(!changed)
				return;
			observerLocal=new ArrayList<>(observer);
			
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
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyUpdate();
	}
}
