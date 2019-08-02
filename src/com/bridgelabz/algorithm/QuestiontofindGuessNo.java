/*
 * @purpose	:Find Guess number in given limit(command Line argument) using Binary Search;
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class QuestiontofindGuessNo {
	//start point of programs
	public static void main(String args[])
	{
		Utility utility=new Utility();
		int limit=Integer.parseInt(args[0]);
		int l=0;
		int r=limit;	
		int mid;
		String answer;
		String replyNo="no";
		String replyYes="yes";
		replyYes="yes";
		do
		{
			mid=(l+r)/2;
			System.out.println("your guess number is(yes/no):"+mid);
			answer=utility.getString();
						
			if(answer.toLowerCase().compareTo(replyNo)==0)
			{
				System.out.println("Is your Guess Number Greater than(yes/no) "+mid);
				String isGraterThan=utility.getString();
				
				if(isGraterThan.toLowerCase().compareTo(replyYes)==0)//execute if block mid is greater than guess number
				{
					l=mid+1;
				}
				else
				{
					r=mid-1;
				}
			}
			
			
		}while(answer.toLowerCase().compareTo(replyYes)!=0); 
	}
}
