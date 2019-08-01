/*
 * @purpose	:Flip a coin and calculate percentage of head and tail
 * @author	:sangita awaghad
 * @since	:29-07-2019
 */
package com.bridgelabz.functional;
import com.bridgelabz.utility.Utility;
public class FlipCoins {
	//start point of Program
	public static void main(String args[]) {
		Utility utility = new Utility();
	
		int mNumberOfTime, mTrails = 0, mHeadCount = 0, mTailCount = 0;

		System.out.println("How Many time You want to flip coin");
		mNumberOfTime = utility.getInteger();

		while (mNumberOfTime > mTrails) {
			if (utility.giveRandomNumber() > 0.5) {
				System.out.println("You Flip Tail");
				mHeadCount++;
			} else {
				System.out.println("You Flip Head");
				mTailCount++;
			}
			mTrails++;
		}
		System.out.println("\nNumber of times Head Flip: " + mHeadCount);
		System.out.println("Number of times Tail Flip: " + mTailCount);

		System.out.println("\nHead Percentage: " + utility.calculatePercentage(mNumberOfTime, mHeadCount));
		System.out.println("Tail Percentage: " + (100f - utility.calculatePercentage(mNumberOfTime, mHeadCount)));
	}
}
