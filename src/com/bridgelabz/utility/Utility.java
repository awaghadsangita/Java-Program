/**
 * @purpose	:contain all methods required to perform task
 * @author	:sangita awaghad
 * @version	:1.8
 * @since	:29-07-2019 
 */
package com.bridgelabz.utility;

import java.util.Random;
import java.util.Scanner;

public class Utility {
	/*
	 * @param year taking year as an argument. return 1 if year is leap year and 0
	 * if year is not leap year
	 * 
	 *
	 */
	final Scanner scanner = new Scanner(System.in);

	public boolean checkerLeapYear(final int year) {
		boolean mIsLeap = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				// year is divisible by 400, hence the year is a leap year
				if (year % 400 == 0) {
					mIsLeap = true;
				} else {
					mIsLeap = false;
				}
			} else
				mIsLeap = true;
		} else {
			mIsLeap = false;
		}
		return mIsLeap;

	}

	/*
	 * @param taking year as an argument. return true if year is four digit and
	 * false if year is not four digit
	 * 
	 */
	public boolean isFourDigit(final int year) {
		return year <= 1000 && year <= 9999;
	}

	/*
	 * Return Random number between 0 and 1
	 */
	public float giveRandomNumber() {
		final Random rand = new Random();
		return rand.nextFloat();
	}

	/*
	 * Return Random number between 0 and N
	 */
	public int giveRandomNumber(final int mNumber) {
		final Random rand = new Random();
		return rand.nextInt(mNumber);
	}

	/*
	 * Calculate Perecentage
	 * 
	 * @param : numberoftimes out of totalcount return percentage
	 */
	public float calculatePercentage(final int totalcount, final int numberoftimes) {
		return numberoftimes * 100 / totalcount;
	}

	/*
	 * Check length of string is greater than three
	 */
	public boolean isStringLengthGraterThree(final String str) {
		return str.length() > 3;

	}

	/*
	 * @purpose :check argaument is in range between 1 to 32
	 * 
	 * @param : it take parameter number
	 */
	public boolean isInRange(final int number) {
		return number >= 1 && number <= 32;
	}

	/*
	 * @purpose :Check Number N is greater than zero
	 */
	public boolean isGreaterThanZero(final int mNumber) {
		return mNumber < 0;
	}

	/*
	 * return integer value from keyboard
	 */
	public int getInteger() {
		return scanner.nextInt();
	}

	/*
	 * return string value from keyboard
	 */
	public String getString() {
		return scanner.next();
	}

	/*
	 * return string value from keyboard
	 */
	public Double getDouble() {
		return scanner.nextDouble();
	}

	/*
	 * return string value from keyboard
	 */
	public Boolean getBoolean() {
		return scanner.nextBoolean();
	}

	/*
	 * Swap character in l and r position of string s
	 */
	public String swap(String s, int l, int i) {
		char[] charArray = s.toCharArray();
		char temp = charArray[l];
		charArray[l] = charArray[i];
		charArray[i] = temp;

		return String.valueOf(charArray);
	}

}
