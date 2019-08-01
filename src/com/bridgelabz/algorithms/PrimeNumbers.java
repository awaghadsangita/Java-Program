/*
 * @purpose	:Find prime number in 0 to 1000
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:30-07-2019
 */
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class PrimeNumbers {

	//start point of program
	public static void main(String args[])
	{
		Utility utility=new Utility();
		int[] prime=utility.findPrime(0,1000);
		int count=0;
		System.out.println("Prime Numbers are as follows\n ");
		for(int i=0;i<prime.length;i++)
		{
			if(prime[i]>0)
			{
				System.out.print(prime[i]+" ");
				count++;
			}
		}
		System.out.println("\nTotal Prime Numbers : "+count);
		
	}
}
