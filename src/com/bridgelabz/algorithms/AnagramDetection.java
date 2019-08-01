/*
 * @purpose	:find two string are anagram of each other
 * @author	:sangita awaghad
 * @since	:01-08-2019
 */
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class AnagramDetection {
	//start point of Program
	public static void main(String args[])
	{
		Utility utility=new Utility();
		String firstString;
		String secondString;
		System.out.print("Enter First String ");
		firstString= utility.getString();
		
		System.out.print("Enter Second String to check whether it is anagram of first string ");
		secondString= utility.getString();
		
		
		boolean isAnangram= utility.checkAnagram(firstString,secondString);
		if(isAnangram)
			System.out.println("\nString '"+firstString+"' And String '"+secondString+"' are Anangram of each other");
		else
			System.out.println("String '"+firstString+"' And String '"+secondString+"' are NOT Anangram of each other");
	}
}
