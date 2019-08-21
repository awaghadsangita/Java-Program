package com.bridgelab.designPattern;

public class ObserverPatternTest {

	public static void main(String[] args) {
		MyTopic topic=new MyTopic();
		IObserver obj1=new MyTopicSubscriber("Obj1");
		IObserver obj2=new MyTopicSubscriber("Obj2");
		IObserver obj3=new MyTopicSubscriber("Obj3");
		
		topic.getUpdate(obj1);
		topic.getUpdate(obj2);
		topic.getUpdate(obj3);
		
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		obj1.update();
		topic.postMessage("Hi How are You");
		
		obj1.update();
		obj2.update();
		obj3.update();

	}

}
