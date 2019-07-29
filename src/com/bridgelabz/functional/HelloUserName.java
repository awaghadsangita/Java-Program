/**
 * @purpose :check username is greater than 3 in length and print Hello Username
 * @Author	:sangita awaghad
 * @since	:29-07-2019
 */
package com.bridgelabz.functional;
import com.bridgelabz.utility.Utility;
import java.util.Scanner;



public class HelloUserName {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		Scanner scanner=new Scanner(System.in);
		String mUsername;
		do {
			System.out.println("Enter User Name Greater than 3 in length");
			mUsername=scanner.next();
		}while(!utility.isStringLengthGraterThree(mUsername));
		System.out.println(" Hello "+mUsername);
		
	}
}
