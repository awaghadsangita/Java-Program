/*
 * @purpose	:Take input from keyboard and perform bubble sort
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class IntegerBubbleSort {

	public static void main(String args[]) {
		Utility utility = new Utility();
		System.out.println("How many element you want in List");
		int size = utility.getInteger();

		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter a[" + (i + 1) + "] Integer Element:");
			array[i] = utility.getInteger();
		}

		System.out.println("Array List Before Sorting");
		for(int element :array) {
			System.out.print(element+ " ");
		}

		array = Utility.bubbleSort(array);

		System.out.println("\n\nArray List After Sorting");
		for (int element:array) {
			System.out.print(element + " ");
		}

	}
}
