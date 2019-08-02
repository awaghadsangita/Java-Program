/*
 * @purpose	:find day of week
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class FindDayOfWeek {
	public static void main(String args[]) 
	{
		int month=Integer.parseInt(args[0]);
		int day=Integer.parseInt(args[1]);		
		int year=Integer.parseInt(args[2]);
		
		String arrDayOfWeek[]=new String[7];
		
		arrDayOfWeek[0]="Sunday";
		arrDayOfWeek[1]="Monday";
		arrDayOfWeek[2]="Tuesday";
		arrDayOfWeek[3]="Wednesday";
		arrDayOfWeek[4]="Thursday";
		arrDayOfWeek[5]="Firday";
		arrDayOfWeek[6]="Saturday";
		
		int dayofWeek=Utility.dayOfWeek(month, day, year);
		
		System.out.println("Give Date is: "+day+"-"+month+"-"+year);
		System.out.println("Day of Week is:"+arrDayOfWeek[dayofWeek]+ " "+dayofWeek);
		
	}
}
