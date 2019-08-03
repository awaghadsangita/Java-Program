/*
 * @purpose	:convert decimal number to binary number
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:02-08-2019 
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class DecimalToBinary {

	public static void main(String[] args) {
		Utility utility=new Utility();
		
		System.out.println("Enter Number to convert Binary number ");
		int mNumber =utility.getInteger();
		
		System.out.println("Binary number of "+mNumber+" is :"+Utility.toBinary(mNumber));
	}

}
