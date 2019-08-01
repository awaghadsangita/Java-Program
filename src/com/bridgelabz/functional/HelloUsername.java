/**
 * @purpose :check username is greater than 3 in length and print Hello Username
 * @Author	:sangita awaghad
 * @since	:29-07-2019
 */
package com.bridgelabz.functional;
import com.bridgelabz.utility.Utility;

public class HelloUsername {
	public static void main(String args[]) {
		Utility utility = new Utility();
		String mUsername;
		String originalString="Hello username,how are you?";
		do {
			System.out.println("Enter User Name Greater than 3 in length");
			mUsername = utility.getString();
		} while (!utility.isStringLengthGraterThree(mUsername));
		
		System.out.println(originalString.replaceAll("username", mUsername));

	}
}
