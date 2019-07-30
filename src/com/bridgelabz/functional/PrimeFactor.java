/*
 * @purpose	: find the prime number and print it
 * @Author	: sangita awaghad
 * @since	: 30-07-2019
 */
package com.bridgelabz.functional;

import java.util.Scanner;

public class PrimeFactor {
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Number to find Prime Number:");
		int n=scanner.nextInt();
		
		findPrimeFactor(n);
	}
	public static void findPrimeFactor(int n)//print all prime numbers
	{
		int temp=n;
		
		for(int i=2;i*i<=temp;i++)
		{
			while(n%i==0)
			{
				System.out.print(i+" ");
				n=n/i;
			}	
			
		}
		if(n>2)
			System.out.print(n+"");
	}
}
