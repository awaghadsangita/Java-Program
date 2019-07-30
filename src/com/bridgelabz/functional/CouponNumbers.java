/*
 * @purpose	:Given N distinct Coupon Numbers, how many random numbers do you need to generate
 * 			distinct coupon number? This program simulates this random process.
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class CouponNumbers {
	public static void main(String[] args)
	{
		int mNumber;
		Scanner sc=new Scanner(System.in);
		Utility utility=new Utility();
		System.out.println("How Many Coupan You Want");
		mNumber=sc.nextInt();
		
		int[] mCoupan=new int[mNumber];
		int mCount=0;
		int i=0;
		
		for(i=0;i<mNumber;i++)
		{
			
			int mRandomNumber=utility.giveRandomNumber(mNumber+1);//give random number between 0 to mNumber
			int k=0;
			for(int j=0;j<i;j++)
			{
				if(mCoupan[j]==mRandomNumber)
				{
					break;
				}
				k++;
			}
			if(i==k)
			{
				mCoupan[i]=mRandomNumber;
				mCount++;
			}
			i=mCount;
		}
		System.out.println("Generated Coupans are as follows");
		
		for(i=0;i<mNumber;i++)
		{
			System.out.println((i+1)+" Coupan Number is : "+mCoupan[i] );//printing Random number Coupan
		}
		System.out.println("Total number of Coupans: "+mCount);
	}
}
