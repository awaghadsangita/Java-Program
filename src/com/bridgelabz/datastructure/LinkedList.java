package com.bridgelabz.datastructure;
/*
 * @purpose	: function for creating node,find data in particular node,
 * finding position of item in linked list,displaying linked list
 */
public class LinkedList {
	static Node HEAD=new Node();// head pointer
	
	
	public static void add(int item) //adding element after last node
	{
		Node newNode=new Node();
		newNode.number=item;
		
		if(HEAD==null)
		{
			HEAD=newNode;
		}
		else
		{
			Node temp=HEAD;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
		}
//		System.out.print(newNode.number);
	}
	public static void addDataInSortedList(int item) //adding element after last node
	{
		Node newNode=new Node();
		newNode.number=item;
		Node temp=HEAD;
		if(temp.number>newNode.number)
		{
			newNode.next=temp;
			HEAD=newNode;
		}
		else
		{
			
			while(temp.next.number<newNode.number)
			{
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
//		System.out.print(newNode.number);
	}
	
	public static void show()// traverse linked list 
	{
		Node current=HEAD;
		while(current!=null)
		{
			System.out.print(current.number+" " );
			current=current.next;
			
		}
	}
	public static boolean find(int item)//return true or false according to item is present
	{
		Node current=HEAD;
		boolean isFound=false;
		while(current!=null)
		{
			if(current.number==item)
			{
				isFound=true;
				break;
			}
			current=current.next;
		}
		return isFound;
	}
	public static int index(int search)//according give position of node
	{
		int count=0;
		Node temp=HEAD;
		while(temp!=null)
		{
			if(temp.number==search)
			{
				return count;
			}
			temp=temp.next;
			count++;
		}
		return -1;
	}
	public static void delete(int pos)//delete node at given position
	{
		Node previous=HEAD;
		int count=1;
		if(pos==0)
		{
			HEAD=HEAD.next;
		}
		else
		{
			while(count<pos && previous!=null)
			{
				previous=previous.next;
				count++;
				
			}
			Node current=previous.next;
			previous.next=current.next;
			
		}
	}
	public static void sort()//sort node in ascending order
	{
		for(Node i=LinkedList.HEAD;i.next!=null;i=i.next)
		{
			for(Node j=i.next;j!=null;j=j.next)
			{
				if(i.number>j.number)
				{
					Node temp=i;
					i=j;
					j=temp;
				}	
				
			}
		}
	}
}
