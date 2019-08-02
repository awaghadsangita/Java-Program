/*
 * @purpose	:Read List of word from file and sort using insertion sort
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class InsertionSortforWord {

	//start point of programs
	public static void main(String[] args) {
		
		Utility utility=new Utility();
		
		System.out.println("How many word you want in list");
		int size = utility.getInteger();
		
		String[] stringArray = new String[size];
		//reading string from keyboard
		for (int i = 0; i < size; i++) {
			System.out.print("Enter a[" + (i + 1) + "] Element: ");
			stringArray[i] = utility.getString();
		}
		
		System.out.println("\n\nList Before Sorting ");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + stringArray[i]);

		}
		
		stringArray=Utility.insertionSort(stringArray);//calling insertion sort method 
		
		System.out.println("\n\nList After Sorting  ");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + stringArray[i]);

		}
	}

}
