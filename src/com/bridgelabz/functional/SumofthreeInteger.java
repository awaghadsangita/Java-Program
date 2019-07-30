/*
 * @purpose	:A program with cubic running time. Read in N integers and counts the
 * 			number of triples that sum to exactly 0
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import java.util.Scanner;

public class SumofthreeInteger {
	public static void main(String args[])
	{
		int n;
		Scanner scanner=new Scanner(System.in);
		System.out.println("How many Elemeny you want in array");
		n=scanner.nextInt();
		
		int[] mArr=new int[n];
		for(int i=0;i<n;i++)
		{
			mArr[i]=scanner.nextInt();
		}
		findTriplet(mArr);
	}
	static void findTriplet(int[]arr)
	{
		int first,second,third=0;
		for(first=0;first<arr.length-2;first++)
		{
			for(second=first+1;first<arr.length-1;first++)
			{
				for(third=second+1;second<arr.length;second++)
				{
					if(arr[first]+arr[second]+arr[third]==0)
					{
						System.out.println(arr[first]+" + "+arr[second]+" + "+arr[third]+" = 0");
					}
				}
			}
		}
	}
}
