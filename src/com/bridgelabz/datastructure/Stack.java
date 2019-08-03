/*
 * @purpose	:stack implementation using array
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:03-08-2019
 */
package com.bridgelabz.datastructure;

public class Stack {
	public static final int MAX=1000;
	static int TOP;
	static char stk[]=new char[MAX];
	
	Stack()
	{
		TOP=-1;
	}
	/*
	 * return true if stack is empty else return false
	 */
	public boolean isEmpty()
	{
		if(TOP==-1)
			return true;
		else
			return false;
	}
	/*
	 * add parenthesis to top of the stack
	 */
	public void push(char parenthesis)
	{
		stk[++TOP]=parenthesis;
		
	}
	/*
	 * return top of stack. if stack is empty return 1;
	 */
	public char pop()
	{
		char parenthesis;
		if(isEmpty())
		{
			parenthesis='1';
		}
		else
		{
			parenthesis=stk[TOP];
			TOP--;
			
		}
		return parenthesis;
	}
	/*
	 * return top of stack but not remove it from stack
	 */
	public char peek()
	{
		char parenthesis=stk[TOP];
		return parenthesis;
	}
}
