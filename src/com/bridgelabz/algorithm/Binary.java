/*
 * @purpose	:convert number into binary and swap nibble and convert it in decimal
 * @@author	:sangita awaghad
 * @version	:1.0
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class Binary {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		System.out.println("Enter number :");
		int mNumber =utility.getInteger();
		
		String binaryString=Utility.toBinary(mNumber);
		System.out.println("Binary Number of "+mNumber+" is "+binaryString);
		
		
		char[] binaryChar=binaryString.toCharArray();
		
		int j=binaryChar.length-4;
			for(int i=0;i<4;i++)
			{
				char temp=binaryChar[i];
				binaryChar[i]=binaryChar[j];
				binaryChar[j]=temp;
				j++;
				
			} 
			
		String swapNibble=String.copyValueOf(binaryChar);
		
		System.out.println("Binary Number After Swapping Nibble : "+swapNibble);
		
		double decimal=Utility.toDecimal(binaryChar);
		System.out.println("Decimal Number After Swapping Nibble : "+decimal);
		
	}
}
