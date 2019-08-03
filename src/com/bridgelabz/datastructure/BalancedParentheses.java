/*
 * @purpose	:checking equation has opening parentheses and same closing parentheses
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:03-08-2019
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class BalancedParentheses {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		
		Stack stack=new Stack();
		System.out.println("Enter Arithmetic Expression");
		String expression=utility.getString();
		
		char[] expressionArray=expression.toCharArray();
		boolean hasSameClosing=true;
		for(int i=0;i<expressionArray.length;i++)
		{
			char chr=expressionArray[i];
			if(chr=='('||chr=='['||chr=='{')
			{
				stack.push(chr);
			}
			else if(chr==')'||chr==']'||chr=='}')
			{
				char returnChar=stack.pop();
				if(chr==')' && returnChar!='('||chr==']' && returnChar!='['||chr=='}' && returnChar!='{')
				{
					hasSameClosing=false;
				}
			}
		}
		if(stack.isEmpty() && hasSameClosing)
			System.out.println(expression+" has Balanced Parenthesis");
		else
		{
			System.out.println(expression+" has NOT Balanced Parenthesis");
		}
	}
}
