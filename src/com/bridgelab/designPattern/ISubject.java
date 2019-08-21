package com.bridgelab.designPattern;

public interface ISubject {
	public void register(IObserver obj);
	public void unregister(IObserver obj);
	public void notifyObserver();
	public Object getUpdate(IObserver obj);
}
