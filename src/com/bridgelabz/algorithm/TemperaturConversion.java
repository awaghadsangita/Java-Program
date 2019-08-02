/*
 * @purpose	:given the temperature in fahrenheit as input outputs the temperature in 
 * 			Celsius or viceversa using the formula
 * @author	:sangita awaghad
 * @since	:02-08-2019
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class TemperaturConversion {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		System.out.println("Enter Temperature in fahrenheit");
		float temp=utility.getFloat();
		
		float celcius=Utility.temperaturConversion(temp, 'c');
		System.out.println("Give Temperatur in fahrenheit is "+temp);
		System.out.println("Temperatur in Celecius is "+celcius);
		
		float fahrenheit=Utility.temperaturConversion(celcius, 'f');
		System.out.println("\nTemperatur in Celecius is "+celcius);
		System.out.println("Temperatur in fahrenheit is "+fahrenheit);
		
	}
}
