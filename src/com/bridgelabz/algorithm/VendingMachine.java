/*
 * @purpose	:implement vending machine giveing change in minimum notes
 * @author	:sangita awaghad
 * @since	:02-08-2019 
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class VendingMachine {
	static int total = 0, i = 0;
	static int[] note = new int[] { 1000, 500, 100, 50, 10, 5, 2, 1 };

	public static void main(String args[]) {
		try {
			Utility utility = new Utility();
			System.out.print("Enter Rupees for change :");
			int rs = utility.getInteger();
			giveChange(rs);
		} catch (Exception e) {
			System.out.println("Enter Rupees in Integer");
		}
	}

	public static void giveChange(int rs) {

		if (rs / note[i] != 0) {
			total = total + rs / note[i];
			System.out.println(note[i] + "/-Rs Notes :" + rs / note[i]);
			rs = rs % note[i];
		}
		i++;

		if (rs == 0) {
			System.out.println("\nTotal Notes: " + total);
		} else {
			giveChange(rs);
		}

	}
}
