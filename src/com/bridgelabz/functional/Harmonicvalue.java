/*
 * @purpose	:Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */

package com.bridgelabz.functional;
import com.bridgelabz.utility.Utility;

public class Harmonicvalue {
	public static void main(String[] args) {
		Utility utility = new Utility();
		
		int mN;
		float mHarmonicnumber = 0;
		
		do {
			System.out.println("Enter the number greater than Zero");
			mN = utility.getInteger();
		} while (utility.isGreaterThanZero(mN));// terminate when mN is less than zero

		for (int i = 1; i <= mN; i++) {
			mHarmonicnumber += (float) 1 / i;

		}
		
		System.out.println("Harmonic value for Number is " + mHarmonicnumber);
	}
}
