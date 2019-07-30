/*
 * @purpose	:Flip a coin and calculate percentage of head and tail
 * @author	:sangita awaghad
 * @since	:29-07-2019
 */
package com.bridgelabz.functional;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class FlipCoin {

	public static void main(String args[])
	{
		Utility utility=new Utility();
		Scanner scanner=new Scanner(System.in);
		int mNumberOfTime,mTrails=0,mHeadCount=0,mTailCount=0;
		
		
		System.out.println("How Many time You want to flip coin");
		mNumberOfTime=scanner.nextInt();

		while(mNumberOfTime>mTrails)
		{
			if(utility.giveRandomNumber()>0.5)
			{
				System.out.println("You Flip Tail");
				mHeadCount++;
			}
			else
			{
				System.out.println("You Flip Head");
				mTailCount++;
			}
			mTrails++;
		}
		System.out.println("Number of times Head Flip: "+mHeadCount);
		System.out.println("Number of times Tail Flip: "+mTailCount);
		
		System.out.println("Head Percentage: "+utility.calculatePercentage(mNumberOfTime, mHeadCount));
		System.out.println("Tail Percentage: "+(100f-utility.calculatePercentage(mNumberOfTime, mHeadCount)));
	}
}
