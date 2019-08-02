/*
 * @purpose	:Calculate Elapse Time for various for binary search,insertion sort,bubble sort
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class ElapseTimeSearchingSorting {
	// start point of program
	public static void main(String args[]) {
		Utility utility = new Utility();
		long start[] = new long[6];
		long stop[] = new long[6];
		long elapseTime[] = new long[6];
		String[] method = new String[6];
		method[0] = "Integer Bubble Sort";
		method[1] = "String Bubble Sort";
		method[2] = "Integer Insertion Sort";
		method[3] = "String Insertion Sort";
		method[4] = "Integer Binary Search";
		method[5] = "String Binary Sort";

		int intArrSize;
		System.out.println("\n\n**Sort Array Element using Bubble Sort**");
		System.out.println("How many Element You Want in Array");
		intArrSize = utility.getInteger();

		int arrayIntger[] = new int[intArrSize];
		start[0] = System.currentTimeMillis();
		for (int i = 0; i < intArrSize; i++) {
			System.out.print("Enter a[" + i + "] :");
			arrayIntger[i] = utility.getInteger();
		}
		//bubble sort for integers
		System.out.println("Array before Bubble Sort");
		for (int i = 0; i < arrayIntger.length; i++) {
			System.out.print(arrayIntger[i] + " ");
		}
		int[] bubbleSortArray = Utility.bubbleSort(arrayIntger);
		System.out.println("\nArray after Bubble Sort");
		for (int i = 0; i < bubbleSortArray.length; i++) {
			System.out.print(bubbleSortArray[i] + " ");
		}

		stop[0] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[0] + " is :" + (stop[0] - start[0]));

		System.out.println("\n\n**Sort String array using Bubble Sort**");
		System.out.println("How many Element You Want in String Array");
		intArrSize = utility.getInteger();

		String arrayString[] = new String[intArrSize];
		start[1] = System.currentTimeMillis();
		for (int i = 0; i < intArrSize; i++) {
			System.out.print("Enter a[" + i + "]");
			arrayString[i] = utility.getString();
		}
		//bubble sort for string
		System.out.println("String Array before Bubble Sort");
		for (int i = 0; i < arrayString.length; i++) {
			System.out.print(arrayString[i] + " ");
		}
		String[] bubbleSortstringArray = Utility.bubbleSort(arrayString);
		System.out.println("\nString Array after Bubble Sort");
		for (int i = 0; i < bubbleSortstringArray.length; i++) {
			System.out.print(bubbleSortstringArray[i] + " ");
		}
		stop[1] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[1] + " is :" + (stop[1] - start[1]));

		//insertion sort for integers
		System.out.println("\n\n**Sorting Integer Array Using Insertion Sort**");
		System.out.println("How many Element You Want in inetger Array for Insertion Sort");
		intArrSize = utility.getInteger();
		int[] integerArray = new int[intArrSize];
		start[2] = System.currentTimeMillis();
		for (int i = 0; i < intArrSize; i++) {
			System.out.print("Enter a[" + i + "] :");
			integerArray[i] = utility.getInteger();
		}
		System.out.println("Interger Array before Insertion Sort");
		for (int i = 0; i < integerArray.length; i++) {
			System.out.print(integerArray[i] + " ");
		}
		int[] insertionArray = Utility.insertionSort(integerArray);
		System.out.println("\nInterger Array after Insertion Sort");
		for (int i = 0; i < insertionArray.length; i++) {
			System.out.print(insertionArray[i] + " ");
		}
		stop[2] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[2] + " is :" + (stop[2] - start[2]));

		//insertion sort for strings
		System.out.println("\n\n**Sort String Array using Insertion Sort**");
		System.out.println("How many Element You Want in String Array");
		intArrSize = utility.getInteger();
		String[] arrayStringinsertion = new String[intArrSize];
		start[3] = System.currentTimeMillis();
		for (int i = 0; i < intArrSize; i++) {
			System.out.print("Enter a[" + i + "] :");
			arrayStringinsertion[i] = utility.getString();
		}
		System.out.println("String Array before Insertion Sort");
		for (int i = 0; i < arrayStringinsertion.length; i++) {
			System.out.print(arrayStringinsertion[i] + " ");
		}
		String[] insertionSortedArr = Utility.insertionSort(arrayStringinsertion);
		for (int i = 0; i < insertionSortedArr.length; i++) {
			System.out.print(insertionSortedArr[i] + " ");
		}
		stop[3] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[3] + " is :" + (stop[3] - start[3]));

		//binary search for integers
		System.out.println("\n\n**Search Integer Element using Binary Search**");
		System.out.println("How many Element You Want in Array for Binary Search");
		int ArrSize = utility.getInteger();
		int[] arrBinary = new int[ArrSize];
		start[4] = System.currentTimeMillis();
		for (int i = 0; i < ArrSize; i++) {
			System.out.print("Enter a[" + i + "] :");
			arrBinary[i] = utility.getInteger();
		}
		System.out.println("Integer Array for Binary Search");
		for (int i = 0; i < arrBinary.length; i++) {
			System.out.print(arrBinary[i] + " ");
		}
		arrBinary = Utility.bubbleSort(arrBinary);// sort array
		System.out.println("Enter Element To Search");
		int x = utility.getInteger();

		int result = Utility.binarySearch(arrBinary, 0, ArrSize - 1, x);

		if (result == -1)
			System.out.println(x + " NOT Present in array ");
		else
			System.out.println(x + " Present in array ");
		stop[4] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[4] + " is :" + (stop[4] - start[4]));

		//binary search for string
		System.out.println("\n\n**Search String Element using Binary Search**");
		System.out.println("How many Element You Want in String Array");
		int strArrSize = utility.getInteger();
		String[] arrStr2 = new String[strArrSize];
		start[5] = System.currentTimeMillis();
		for (int i = 0; i < strArrSize; i++) {
			System.out.print("Enter a[" + i + "] :");
			arrStr2[i] = utility.getString();
		}
		System.out.println("String Array for Binary Search");
		for (int i = 0; i < arrStr2.length; i++) {
			System.out.print(arrStr2[i] + " ");
		}

		arrStr2 = Utility.bubbleSort(arrStr2);//sort array
		System.out.println("Enter Element To Search");
		String x1 = utility.getString();

		int result1 = Utility.binarySearch(arrStr2, x1);

		if (result1 == -1)
			System.out.println(x1 + " NOT Present in array ");
		else
			System.out.println(x1 + " Present in array ");
		stop[5] = System.currentTimeMillis();
		System.out.println("\nElapse Time for " + method[5] + " is :" + (stop[5] - start[5]));
		for (int i = 0; i < 6; i++) {
			elapseTime[i] = stop[i] - start[i];
//			01-Integer Bubble Sort
//			02-String Bubble Sort
//			03-Integer Insertion Sort
//			04-String Insertion Sort
//			05-Integer Binary Search
//			06-String Binary Sort
		}

		for (int k = 0; k < 6; k++) {
			System.out.println("Elapse Time for " + method[k] + " is :" + elapseTime[k]);
		}

		System.out.println("\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (elapseTime[j] > elapseTime[j + 1]) {
					long t = elapseTime[j];
					elapseTime[j] = elapseTime[j + 1];
					elapseTime[j + 1] = t;

					String m = method[j];
					method[j] = method[j + 1];
					method[j + 1] = m;
				}

			}

		}
		for (int i = 0; i < 6; i++) {
			System.out.println("Elapse Time for" + method[i] + " is :" + elapseTime[i]);
		}
	}
}
