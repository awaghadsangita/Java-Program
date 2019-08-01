/**
 * @purpose	:contain all methods required to perform task
 * @author	:sangita awaghad
 * @version	:1.8
 * @since	:29-07-2019 
 */
package com.bridgelabz.utility;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Utility {
	/*
	 * @param year taking year as an argument. return 1 if year is leap year and 0
	 * if year is not leap year
	 * 
	 *
	 */
	final Scanner scanner = new Scanner(System.in);

	public boolean checkerLeapYear(final int year) {
		boolean mIsLeap = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				// year is divisible by 400, hence the year is a leap year
				if (year % 400 == 0) {
					mIsLeap = true;
				} else {
					mIsLeap = false;
				}
			} else
				mIsLeap = true;
		} else {
			mIsLeap = false;
		}
		return mIsLeap;

	}

	/*
	 * @param taking year as an argument. return true if year is four digit and
	 * false if year is not four digit
	 * 
	 */
	public boolean isFourDigit(final int year) {
		boolean isfourDigit; 
		if(year >= 1000 && year <= 9999)
		{
			isfourDigit=true;
		}
		else
		{
			isfourDigit=false;
		}
		 return isfourDigit;
	}

	/*
	 * Return Random number between 0 and 1
	 */
	public float giveRandomNumber() {
		final Random rand = new Random();
		return rand.nextFloat();
	}

	/*
	 * Return Random number between 0 and N
	 */
	public int giveRandomNumber(final int mNumber) {
		final Random rand = new Random();
		return rand.nextInt(mNumber);
	}

	/*
	 * Calculate Perecentage
	 * 
	 * @param : numberoftimes out of totalcount return percentage
	 */
	public float calculatePercentage(final int totalcount, final int numberoftimes) {
		return numberoftimes * 100 / totalcount;
	}

	/*
	 * Check length of string is greater than three
	 */
	public boolean isStringLengthGraterThree(final String str) {
		return str.length() > 3;

	}

	/*
	 * @purpose :check argaument is in range between 1 to 32
	 * 
	 * @param : it take parameter number
	 */
	public boolean isInRange(final int number) {
		return number >= 1 && number <= 32;
	}

	/*
	 * @purpose :Check Number N is greater than zero
	 */
	public boolean isGreaterThanZero(final int mNumber) {
		return mNumber < 0;
	}

	/*
	 * return integer value from keyboard
	 */
	public int getInteger() {
		return scanner.nextInt();
	}

	/*
	 * return string value from keyboard
	 */
	public String getString() {
		return scanner.next();
	}

	/*
	 * return string value from keyboard
	 */
	public double getDouble() {
		return scanner.nextDouble();
	}

	/*
	 * return string value from keyboard
	 */
	public boolean getBoolean() {
		return scanner.nextBoolean();
	}

	/*
	 * Swap character in l and r position of string s
	 */
	public String swap(String s, int l, int i) {
		char[] charArray = s.toCharArray();
		char temp = charArray[l];
		charArray[l] = charArray[i];
		charArray[i] = temp;

		return String.valueOf(charArray);
	}
	/*Program for Anagram Detection*
	 * @param fString denote first string
	 * @param sString denote second string
	*/
	
	public boolean checkAnagram(String fString, String sString) {
		int i = 0;
		int[] firstCount = new int[256];
		int[] secondCount = new int[256];

		char[] charArr1 = fString.toCharArray();
		char[] charArr2 = sString.toCharArray();
		if (fString.length() != sString.length())
			return false;
		else {
			for (i = 0; i < fString.length(); i++) {
				firstCount[charArr1[i]]++;
				secondCount[charArr2[i]]++;
			}

			for (i = 0; i < 256; i++) {
				if (firstCount[i] != secondCount[i]) {
					return false;
				}
			}
			return true;
		}
	}
	/*Program to find prime numbers between given range;
	 * @param start denote start point
	 * @param stop denote end point*/
	public int[] findPrime(int start,int stop)
	{
		int i;
		boolean isPrime=false;
		ArrayList<Integer> prime=new ArrayList<Integer>();
		for(i=start;i<=stop;i++)
		{
			if(i>=2)
			{
				isPrime=true;
				for(int j=2;j<=(i/2);j++)
				{
					if(i%j==0)
					{
						isPrime=false;
						break;
					}
				}
				if(isPrime)
				{
					prime.add(i);
				}
			}
		}
		int primeArray[]=new int[prime.size()];
		
		for (i =0; i < prime.size(); i++) 
	            primeArray[i] = prime.get(i);
		
		return primeArray; 
	}
	/*program to find Anagram in 0 to 1000 range
	 * @param primeArr takes Prime number array in 0-1000 range*/
	public int[] isAnangram(int[] primeArr)
	{
		
		int[] firstcount=new int[10];
		int[] secondcount=new int[10];
		int anagramCount=0;
		boolean isAnagram1=true;
		int digit;
		int anagramArr[]=new int[200];
		int count=0;

		System.out.println("\nAnanagram numbers are :");

		int i,j,k;
		for(i=0;i<primeArr.length-1;i++)
		{

			for(j=i+1;j<primeArr.length;j++)
			{
				if(primeArr[i]!=0&&primeArr[j]!=0)
				{
					int firstnum=primeArr[i];
					int secondnum=primeArr[j];
					int firstDigitCount=0,secondDigitCount=0;
					isAnagram1=true;
					for(k=0;k<10;k++)
					{
						firstcount[k]=0;
						secondcount[k]=0;
					}
					while(firstnum>0)
					{
						digit=firstnum%10;
						firstcount[digit]=firstcount[digit]+1;
						firstDigitCount++;
						firstnum/=10;
					}

					while(secondnum>0)
					{
						digit=secondnum%10;
						secondcount[digit]++;
						secondDigitCount++;
						secondnum/=10;
					}

					if(firstDigitCount==secondDigitCount)
					{
						for(int l=0;l<10;l++)
						{
							if(firstcount[l]!=secondcount[l])
							{
								isAnagram1=false;
								break;
							}	
						}
						if(isAnagram1)
						{
//							System.out.println(primeArr[i]+" and "+primeArr[j]+" Are Ananagram");
							anagramArr[count]=primeArr[i];
							anagramArr[++count]=primeArr[j];
							count++;
							anagramCount++;
						}
					}
				}
			}
		}
//		System.out.println("Total Ananagram numbers are :"+anagramCount);
		return anagramArr;

	}
	/*progrme to find Palindrome numbers that are anagram 
	 * @param anagramArr denote array of anagram numbers*/
    public static int[] isPalindrome(int[] anagramArr)
    {
    	int count=0;
    	int palindrom[]=new int[500];
    	System.out.println("\nPalindrome numbers are as follow: ");
    	for(int i=0;i<anagramArr.length;i++)
    	{
    		if(anagramArr[i]>0)
    		{
    			//logic start
    			int digit,rnum=0,num;
    			num=anagramArr[i];
    			while(num>0)
    			{
    				digit=num%10;
    				rnum=digit+rnum*10;
    				num/=10;
    			}
    			if(anagramArr[i]==rnum)
    			{
//    				System.out.println(rnum+" is Palindrome number");
    				palindrom[count]=rnum;
    				count++;
    			}
    			//logic end
    		}
    	}
    	//System.out.println("Total Numbers of Prime number that are anagrame and palindrom: "+count++);
    	return palindrom;
    }
}
