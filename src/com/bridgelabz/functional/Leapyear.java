/**
 * @purpose	:Check whether year is Leap Year or not
 * @author user:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Leapyear {
	public static void main(String args[]) {
		Utility utility = new Utility();
		
		int mYear;
		
		do {
			System.out.println("Enter the for digit Year");
			mYear = utility.getInteger();
		} while (!utility.isFourDigit(mYear));

		boolean result = utility.checkerLeapYear(mYear);

		if (result)
			System.out.println("Year " + mYear + " is Leap Year");
		else
			System.out.println("Year " + mYear + " is not Leap Year");

	}
}
