package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagram2DArray {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		
		int start=0;
		int stop=100;
		int count=0;
		
		int[] returnPrimeArray=utility.findPrime(0, 1000);
		int[][] prime=new int[10][50];	
		System.out.println(returnPrimeArray.length);
		for(int i=0;i<10;i++)
		{
				for(int k=0;k<returnPrimeArray.length;k++)
				{
						if(returnPrimeArray[k]>=start && returnPrimeArray[k]<=stop)
						{
							prime[i][count++]=returnPrimeArray[k];
						}
				}
				start=start+100;
				stop=stop+100;
				count=0;
		}
		start=0;stop=100;
		
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				for(int k=0;k< prime[i].length && prime[i][k]!=0;k++)
				{
						System.out.print(prime[i][k]+" ");
						count++;
				}
				System.out.println();
			start=start+100;
			stop=stop+100;
			
		}
		System.out.println("\nTotal Prime Numbers "+count);
		
		LinkList<Integer> listStack=new LinkList<Integer>();
		LinkList<Integer> listQueue=new LinkList<Integer>();
		int anagramIndex=0;
		int notAnagramIndex=0;
		int returnAngramArray[]=utility.isAnangram(returnPrimeArray);
		int[][] anagramNotAnagram=new int[2][500];	 
		for(int i=0;i<returnPrimeArray.length;i++)
		{
				boolean notAnagram=false;
				for(int j=0;j<returnAngramArray.length;j++)
				{
						if(returnPrimeArray[i]==returnAngramArray[j])
						{
							notAnagram=true;
						}
				}
				if(notAnagram)
				{
					anagramNotAnagram[0][anagramIndex++]=returnPrimeArray[i];
					
					
				}
				else
				{
					anagramNotAnagram[1][notAnagramIndex++]=returnPrimeArray[i];
				}
		}
		System.out.println("\nAngram Numbers are as follows");
		start=0;stop=100;count=0;
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				for(int k=0;k<anagramNotAnagram[0].length && anagramNotAnagram[0][k]!=0;k++)
				{
					if(anagramNotAnagram[0][k]>=start && anagramNotAnagram[0][k]<=stop)
					{
						listStack.push(anagramNotAnagram[0][count]);
						listQueue.append(anagramNotAnagram[0][count]);
						System.out.print(anagramNotAnagram[0][count++]+" ");
					}
				}
				System.out.println();
			start=start+100;
			stop=stop+100;
		}
		System.out.println("\nTolal Anagrams:"+count);
		
		System.out.println("\nPrime Numbers that are not Anagram are as follows");
		start=0;stop=100;count=0;
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				for(int k=0;k<anagramNotAnagram[1].length && anagramNotAnagram[1][k]!=0;k++)
				{
					if(anagramNotAnagram[1][k]>=start && anagramNotAnagram[1][k]<=stop)
					{
						
						System.out.print(anagramNotAnagram[1][count++]+" ");
					}
				}
				System.out.println();
			start=start+100;
			stop=stop+100;
		}
		System.out.println("\nTolal Not Anagrams :"+count);
		
		System.out.println("\n\nAnagram Numbers in Stack are as follows");
		start=1000;stop=900;count=0;
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				while(!listStack.isEmpty())
				{
					int anagram=listStack.Pop();
					if(anagram<=start && anagram<=stop)
					{
						break;
					}
					System.out.print(anagram+" ");
					count++;
				}
				System.out.println();
			start=start-100;
			stop=stop-100;
		}
		System.out.println("\nTolal Anagrams Stack Nodes:"+count);
		
		System.out.println("\n\nAnagram Numbers in Queue are as follows");
		
		start=0;stop=100;count=0;
		for(int i=0;i<10;i++)
		{
				System.out.print("Range "+ start+"-"+stop+"  :");
				while(!listQueue.isEmpty())
				{
					int anagram=listQueue.Pop();
					if(anagram>=stop)
					{
						break;
					}
					System.out.print(anagram+" ");
					count++;
				}
				System.out.println();
			start=start+100;
			stop=stop+100;
		}
		System.out.println("\nTolal Anagrams Queue Nodes:"+count);
		
	}
	
}
