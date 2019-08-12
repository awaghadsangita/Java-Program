/***************************************************************************************************
 * @purpose	:replace given string values with actual values and demonstrate regular expression
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:12-09-2019	 
 ***************************************************************************************************/
package com.bridgelab.objectoriented;

import com.bridgelab.utility.Utility;

public class RegexDemostartion {

	public static void main(String args[]) {
		String firstName;
		String lastName;
		String fullName;
		String mobileNumber;
		boolean matcherResult;
		do {
			System.out.print("Enter First Name :");
			firstName = Utility.getString();

			matcherResult = Utility.isOnlyAlphabets(firstName);
			if (!matcherResult) {
				System.out.println("Enter first name in alphabets only containing 3 to 20 charcaters");
			}
		} while (matcherResult == false);

		do {
			System.out.print("Enter Last Name :");
			lastName = Utility.getString();

			matcherResult = Utility.isOnlyAlphabets(lastName);
			if (!matcherResult) {
				System.out.println("Enter Last name in alphabets only containing 3 to 20 charcaters");
			}
		} while (matcherResult == false);
		fullName = firstName + " " + lastName;

		do {
			System.out.print("Enter Mobile Number:");
			mobileNumber = Utility.getString();

			matcherResult = Utility.isValidMobileNumber(mobileNumber);
			if (!matcherResult) {
				System.out.println("Enter Mobile Number must be 10 digit numberic value");
			}
		} while (matcherResult == false);

		String actualString = Utility.replaceStringWithActualValues(firstName, fullName, mobileNumber);

		System.out.println("\n\n\n");
		System.out.println(actualString);
	}
}
