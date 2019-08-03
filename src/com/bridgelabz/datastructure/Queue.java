/*
 * @purpose	:implement queue using array
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:03-08-2019
 */
package com.bridgelabz.datastructure;

public class Queue {

	int REAR;
	int FRONT;
	static final int MAX=100;
	int que[]=new int[MAX];
	int count=0;
	
	/*
	 * initially front and rear set to -1
	 */
	public Queue()
	{
		this.FRONT=-1;
		this.REAR=-1;
	}
	/*
	 * return true if queue is empty else false
	 */
	public boolean isEmpty()
	{
		if(this.REAR==this.FRONT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
	 * return true if queue is full else false 
	 */
	public boolean isFull()
	{
		if(this.REAR==MAX-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
	 * add element from rear end increment rear 
	 */
	public void enqueue()
	{
		que[++this.REAR]=count++;
	}
	/*
	 * remove element from front end increment front also decrement queue size
	 */
	int dequeue()
	{
		count--;
		return que[++this.FRONT];
	}
	/*
	 * return number of people in queue
	 */
	int size()
	{
		return this.REAR-this.FRONT;
	}
	/*
	 * people in show queue
	 */
	public void showQue()
	{
		System.out.println("Queue Status");
		
		for(int i=++this.FRONT;i<=this.REAR;i++)
		System.out.print(que[i]+" ");
		
		System.out.println();
	}
}
