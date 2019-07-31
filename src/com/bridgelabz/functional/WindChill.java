/*
 * @purpose	: calculate wind chill temperature
 * @author	: sangita awaghad
 * @since	: 31-07-2019
 */
package com.bridgelabz.functional;

public class WindChill {
	public static void main(String[] args)
	{
		System.out.println("Program To Calculate WindChill Temperature");
		
		double t=Double.parseDouble(args[0]);
		double v=Double.parseDouble(args[1]);
		
		if(Math.abs(t)>50 && v>120|| v<3)
		{
			System.out.println("formula is not valid if Temperature(t) is larger than 50 in absolute value or if Wind Speed(v) is larger than 120 or less than 3");
		}
		else
		{
			double windChillTemperature= 35.74 + 0.6215 * t+(0.4275 * t-35.75)*Math.pow(v,0.16);
			System.out.println("Wind Chill :"+windChillTemperature);
		}
	}
}
