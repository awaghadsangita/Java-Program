package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeTwoDArray {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		int[][] prime=new int[10][50];
		int start=0;
		int stop=100;
		int count=0;
		for(int i=0;i<10;i++)
		{
			
			 int returnPrimeArray[]=utility.findPrime(start, stop);
			 for(int k=0;k<returnPrimeArray.length;k++)
			 {
				prime[i][k]=returnPrimeArray[k];
			}
			 
			start=start+100;
			stop=stop+100;
		}
		start=0;stop=100;
		System.out.println("\nPrime Number are as follows");
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				for(int k=0;prime[i][k]!=0;k++)
				{
						System.out.print(prime[i][k]+" ");
						count++;
				}
				System.out.print("\n");
			start=start+100;
			stop=stop+100;
		}
	
		System.out.println("\nTotal Prime Numbers "+count);
		
	}

}
