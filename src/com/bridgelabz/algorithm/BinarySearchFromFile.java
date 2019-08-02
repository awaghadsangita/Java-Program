/*
 * @purpose	:read list of word from file and search word in list using binary search
 * @author	:sangita awaghad
 * @since	:02-08-209 
 */
package com.bridgelabz.algorithm;

import java.io.File;
import com.bridgelabz.utility.Utility;

public class BinarySearchFromFile {
	// start point of program
	public static void main(String args[]) {
		try {
			
			Utility utility=new Utility();
			File f = new File("/home/user/Desktop/sangita1.txt");
			
			String[] strArr = Utility.readStringFile(f);
			
			for (int i = 0; i < strArr.length; i++) {
				System.out.print(" " + strArr[i]);
			}
			
			System.out.println("\nEnter the Name to Search");
			String name = utility.getString();
			
			strArr=Utility.bubbleSort(strArr);//sort array using bubblesort
			
			int result = Utility.binarySearch(strArr, name);
								
			if (result == -1)
				System.out.println(name + " is NOT present in List");
			else
				System.out.println(name + " is present in List");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
