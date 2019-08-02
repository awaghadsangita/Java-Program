/*
 * @purpose	:Simulates a gambler who start with $stake and place fair $1 bets until
 * 			he/she goes broke (i.e. has no money) or reach $goal. Keeps track of the number of
 * 			times he/she wins and the number of bets he/she makes. Run the experiment N
 * 			times, averages the results, and prints them out.
 * @Author	:sangita awaghad
 * @since	:30-07-2019	
 */
package com.bridgelabz.functional;

import java.util.Scanner;
import com.bridgelabz.utility.Utility;

public class Gambler {
	public static void main(String[] args) {
		Utility utility = new Utility();
		int mStake, mGoal, mNumberOfTime;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter $stake Value :");
		mStake = scanner.nextInt();

		System.out.println("Enter $Goal Value :");
		mGoal = scanner.nextInt();

		System.out.println("How many of times you want to play:");

		mNumberOfTime = scanner.nextInt();

		int mWincount = 0, mBets = 0;
		int mCash = mStake;

		for (int i = 0; i < mNumberOfTime; i++) {
			mBets++;
			if (utility.giveRandomNumber() > 0.5) {
				mWincount++;
				mCash++;
			} else {
				mCash--;
			}

			if (mCash == mGoal) {
				System.out.println("You Win the Game and Achive Goal");
				break;
			}
			if (mCash == 0) {
				System.out.println("You Loose the Game");
				break;
			}
		}

		if (mStake < mCash) {
			System.out.println("You Win the Game BUT not Achive Goal");
		} else {
			System.out.println("You Loose the Game");
		}

		// printing win percenatge and loose percentage
		System.out.println("Percentage of match win :" + utility.calculatePercentage(mWincount, mBets));
		System.out.println("Percentage of match win :" + (100f - utility.calculatePercentage(mWincount,mBets)));

	}

}