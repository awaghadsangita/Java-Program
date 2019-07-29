/**
 * @purpose	:contain all methods required to perform task
 * @author	:sangita awaghad
 * @version	:1.8
 * @since	:29-07-2019 
 */
package com.bridgelabz.utility;

public class Utility {
/*
 * @param year taking year as an argument.
 * return 1 if year is leap year and 0 if year is not leap year
 * 
 */
	
	public int checkerLeapYear(int year)
	{
		if(year%4==0)
		{
				if( year % 100 == 0)
	            {
	                // year is divisible by 400, hence the year is a leap year
	                if ( year % 400 == 0)
	                    return 1;
	                else
	                    return 0;
	            }
	            else
	                return 1;
			}
			else
			{
				return 0;
			}
		
		
	}
	/*
	 * @param taking year as an argument.
	 * return true if year is four digit and false if year is not four digit
	 * 
	 */
	public boolean isFourDigit(int year)
	{
		if(year<=1000 && year<=9999) return true;
					
		return false;
	}
	public boolean isStringLengthGraterThree(String str)
	{
		if(str.length()>3)
			return true;
		
		return false;
	}
}
