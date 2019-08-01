/*
 * @purpose	:find roots of the Quadratic Equation 
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class QuadraticEquationRoots {
	public static void main(String args[]) {
		Utility utility = new Utility();
		QuadraticEquationRoots quadratic = new QuadraticEquationRoots();
		int a;
		int b;
		int c;
		do {
			System.out.print("Enter value of a,b and c (ax^2+bx+c) :");
			a = utility.getInteger();
			b = utility.getInteger();
			c = utility.getInteger();
		} while (utility.isGreaterThanZero(a));
		
		quadratic.findRoots(a, b, c);
	}

	public void findRoots(int a, int b, int c) {
		double root1;
		double root2;
		int delta;

		delta = b * b - 4 * a * c;
		double sqrt_val = Math.sqrt(Math.abs(delta));

		System.out.println(sqrt_val);
		
		if (delta > 0)// if delta is greater than zero then roots are real and different
		{
			System.out.println("Roots are Real and Different\n");
			root1 = (-b + Math.sqrt(delta)) / (2 * a);
			root2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("First Root of x:" + root1 + "\nSecond Root of x:" + root2);
		} else if (delta < 0) // if delta is less than zero then roots are complex
		{
			System.out.println("Roots are Complex\n");
			System.out.println("First Root of x:(" + -b + "+" + sqrt_val + "i)" + "/" + (2 * a) + "\nSecond Root of x("
					+ -b + "-" + sqrt_val + "i)" + "/" + (2 * a));
		}
	}
}
