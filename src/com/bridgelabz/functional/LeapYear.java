/**
 * @purpose	:Check whether year is Leap Year or not
 * @author user:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

import java.util.Scanner;

public class LeapYear {
	public static void main(String args[]) {
		Utility utility = new Utility();
		Scanner scanner = new Scanner(System.in);
		int mYear;
		
		do {
			System.out.println("Enter the Year");
			mYear = scanner.nextInt();
		} while (utility.isFourDigit(mYear));

		boolean result = utility.checkerLeapYear(mYear);

		if (result)
			System.out.println("Year " + mYear + " is Leap Year");
		else
			System.out.println("Year " + mYear + " is not Leap Year");

	}
}
