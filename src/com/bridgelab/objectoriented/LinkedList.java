package com.bridgelab.objectoriented;

public class LinkedList<T> {
	Node<T> HEAD;
	
	public boolean isEmpty()
	{
		return HEAD==null;
	}
	public void insert(Node<T> newnode)
	{
		if(isEmpty())
		{
			HEAD=newnode;
		}
		else
		{
			Node<T> temp=HEAD;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=HEAD;
		}
	}
	/*
	 * return index if object found otherwise return -1 
	 */
	public int isFound(Node<T> searchObj)
	{
		int index=-1;
		int count=0;
		Node<T> temp=HEAD;
		while(temp!=null)
		{
			if(temp.obj.equals(searchObj))
			{
				index=count;
				break;
			}
			count++;
			temp=temp.next;
		}
		return index;
	}
	/*
	 * return node at given index
	 */
	public void remove(int index)
	{
		if(index==1 && HEAD.next==null)
		{
			HEAD=null;
		}
		else if(index==1)
		{
			HEAD=HEAD.next;
		}
		else 
		{
			int count=1;
			Node<T> temp=HEAD;
			while(count<index-1)
			{
				temp=temp.next;
			}
			Node<T> current=temp.next;
			temp.next=current.next;
		}
	}
	
	
}
