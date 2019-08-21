package com.bridgelab.designPattern.behavioral.observer;

public interface IObserver {
	public void update();
	public void setSubject(ISubject sub);
}
