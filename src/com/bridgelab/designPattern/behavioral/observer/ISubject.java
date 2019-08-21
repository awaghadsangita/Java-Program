package com.bridgelab.designPattern.behavioral.observer;

public interface ISubject {
	public void register(IObserver obj);
	public void unregister(IObserver obj);
	
	public void notifyUpdate();
	public Object getUpdate(IObserver obj);
}
