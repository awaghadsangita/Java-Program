/*
 * @purpose	:reads in three command-line arguments principal(P),year(Y), and rate(R) and 
 * 			calculates the monthly payments
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MonthlyPayment {
	// start point programs
	public static void main(String args[])
	{
		double p = Double.parseDouble(args[0]);//p denote Principal Amount
		double y = Double.parseDouble(args[1]);//y denote Year
		double r = Double.parseDouble(args[2]);//r denote Rate
		
		double payment=Utility.monthlyPayment(p, y, r);
		
		System.out.println("Monthly Payment is :"+payment);
	}
}
