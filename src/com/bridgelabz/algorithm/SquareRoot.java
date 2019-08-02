/*
 * @purpose	:find square root of given number
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class SquareRoot {
	//start point of program
	public static void main(String args[])
	{
		Utility utility=new Utility();
		double mNumber;
		do
		{
			System.out.print("Enter Nonnegative Number :");
			mNumber=utility.getDouble();
		}while(mNumber<0);
		
		
		System.out.println("SquareRoot of "+mNumber+" is :"+Utility.sqrt(mNumber));
				
	}
}
