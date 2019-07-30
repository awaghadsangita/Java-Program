/*
 * @Purpose	:take Command Line Argument from user check it in range 1 to 32 and print table of power of two
 * @author	:sangita awaghad
 * @since	:30-07-2019 
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class PowerOf2Table {
	public static void main(String[] args)
	{
		Utility utility=new Utility();
		int mTable=1;
		int mPower=Integer.parseInt(args[0]);
		
		if(utility.isInRange(mPower))
		{
				for(int i =0;i<=mPower;i++)
				{
					System.out.println("2^"+i+" ="+mTable);
					mTable *=2;
					
				}
				
		}
		else
		{
			System.out.println("Power Must be between 0 and 32");
		}
	}
}
