/***************************************************************************************************************
 * @purpose	:contains all method required to perform various operation
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:07-08-2019
 ***************************************************************************************************************/
package com.bridgelab.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
	static Scanner scanner=new Scanner(System.in);
	/*
	 * return String value from keyboard
	 */
	public static String getString()
	{
		return scanner.next();
	}
	/*
	 * return int value from keyboard
	 */
	public static int getInteger()
	{
		return scanner.nextInt();
	}
	/*
	 * return double value from keyboard
	 */
	public static double getDouble()
	{
		return scanner.nextDouble();
	}
	/*
	 * return long value from keyboard
	 */
	public static long getLong()
	{
		return scanner.nextLong();
	}
	/*
	 * return string with space and special characters
	 */
	public static String getNextLine()
	{
		return scanner.nextLine();
	}
	/*
	 *replace given string with actual values 
	 */
	public static String replaceStringWithActualValues(String firstname,String fullname,String mobilenumber)
	{
		String givenString="Hello <<name>>, \n" + 
				"We have your fullname as <<full name>> in our system. your contact number is 91-xxxxxxxxxx.\n" + 
				"Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		givenString=givenString.replace("<<name>>", firstname);
		givenString=givenString.replace("<<full name>>", fullname);
		givenString=givenString.replace("xxxxxxxxxx", mobilenumber);
		
		LocalDateTime ldate=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		givenString=givenString.replace("01/01/2016",formatter.format(ldate));
		
		return givenString;
	}
	/*
	 * 
	 */
	public static boolean isOnlyAlphabets(String name)
	{
		return Pattern.compile("^[a-zA-Z]{3,20}$").matcher(name).matches();
	}
	/*
	 * 
	 */
	public static boolean isValidZip(String zip)
	{
		return Pattern.compile("^[0-9]{6}$").matcher(zip).matches();
	}
	/*
	 * 
	 */
	public static boolean isValidPincode(String pincode)
	{
		return Pattern.compile("^[0-9]{6}$").matcher(pincode).matches();
	}
	/*
	 * 
	 */
	public static boolean isValidMobileNumber(String mobilenumber)
	{
		return Pattern.compile("^[7-9]{1}[0-9]{9}$").matcher(mobilenumber).matches();
	}
	/*
	 * 
	 */
	public static boolean isValidAddress(String mobilenumber)
	{
		return Pattern.compile("^[a-zA-Z\\s,-]{2,100}$").matcher(mobilenumber).matches();
	}
	/*
	 *return true if given email is in valid format otherwise false 
	 */
	public static boolean isValidEmail(String email)
	{
		 
		// return Pattern.compile("^(.+)@(.){1,}$").matcher(email).matches();
		return true;
	}
	/*
	 *return true if given password minimum 8 characters long contain 1 lowercase and 1 number atleast 
	 */
	public static boolean isValidPassword(String pwd)
	{
		return Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$").matcher(pwd).matches();
	}
}








