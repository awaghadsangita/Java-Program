/*
 * @purpose	: sort string array using merge sort
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MergeSort {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		System.out.println("How many String element you want in List");
		int size=utility.getInteger();
		
		String[] array=new String[size];
		
		for(int i=0;i<size;i++)
		{
			System.out.print("Enter a["+(i+1)+"] Element ");
			array[i]=utility.getString();
		}
		
		System.out.println("\nList before Sorting: ");
		for(String element:array)
		{
			System.out.print(element+" ");
		}
		Utility.sort(array,0,size-1);
		
		System.out.println("\n\nList after Sorting: ");
		for(String element:array)
		{
			System.out.print(element+" ");
		}
	}
}
