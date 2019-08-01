/*
 * @purpose	:A program with cubic running time. Read in N integers and counts the
 * 			number of triples that sum to exactly 0
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class SumofthreeInteger {
	public static void main(String args[]) {
		int n;
		Utility utility=new Utility();
		System.out.println("How many Elemeny you want in array");
		n = utility.getInteger();

		int[] mArr = new int[n];
		System.out.println("Enter "+n+" Integer");
		for (int i = 0; i < n; i++) {
			mArr[i] = utility.getInteger();
		}
		findTriplet(mArr);
	}

	static void findTriplet(int[] arr) {
		int first;
		int second;
		int third ;
		for (first = 0; first < arr.length - 2; first++) {
			for (second = first + 1; first < arr.length - 1; first++) {
				for (third = second + 1; second < arr.length; second++) {
					if (arr[first] + arr[second] + arr[third] == 0) {
						System.out.println(arr[first] + " + " + arr[second] + " + " + arr[third] + " = 0");
					}
				}
			}
		}
	}
}
