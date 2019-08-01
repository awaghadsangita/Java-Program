/*
 * @purpose	:Find Prime Number that are Anagram
 * @author	:sangita awaghad
 * @since	:1-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramPalindrom {
	public static void main(String[] args)
	{
		Utility utility=new Utility();
		int i,count=0;
		boolean isPrime=false;
		
		int primeArr[]=utility.findPrime(0, 1000);
		System.out.println("Prime Number in Range 0-1000");
		for(i=0;i<primeArr.length;i++)
		{
			if(primeArr[i]>0)
			{
				System.out.print(primeArr[i]+", ");
				count++;
			}
		}
		System.out.println("\nTotal Prime Numbers :"+count);
		
		count=0;
		int[] anagramArr=utility.isAnangram(primeArr);
		System.out.println("\nPrime Number in Range 0-1000 that are Anagram");
		for(i=0;anagramArr[i]!=0;i=i+2)
		{
			System.out.println(anagramArr[i]+" and "+anagramArr[i+1]+" are Anagram");
			count++;
		}
		System.out.println("\nTotal Anagram Numbers :"+count);
		
		int[] palindrom=utility.isPalindrome(anagramArr);
		System.out.println("\nPrime Number  that are anagram and palindrom in Range 0-1000 that are Anagram");
		for(i=0;palindrom[i]!=0;i++)
		{
			if(anagramArr[i]>0)
			{
				System.out.print(palindrom[i]+", ");
				count++;
			}
		}
		
	}
	
}
