/*
 * @purpose	:give elapse line between two click;
 * @author	:sangita awaghad
 * @since	:31-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Stopwatch {
	static long mStartTime = 0; // saves start time to stop watch
	static long mStopTime = 0; // saves stop time of stop watch

	public static void main(String[] args) {
		Utility utility = new Utility();
		final Stopwatch stopwatch = new Stopwatch();
		final int start;
		final int stop;
		System.out.println("Press 1 to Start Stop Watch and Press 0 to Stop Stop Watch :");
		start = utility.getInteger();

		if (start == 1) {
			stopwatch.startWatch();
		}

		stop = utility.getInteger();

		if (stop == 0) {
			stopwatch.stopWatch();
		}
		stopwatch.getElapseTime();
	}

	/*
	 * function to start stop watch
	 */
	public void startWatch() {
		mStartTime = System.currentTimeMillis();

	}

	/*
	 * function to stop watch
	 */
	public void stopWatch() {
		mStopTime = System.currentTimeMillis();
	}

	/*
	 * function to calculate elapse time
	 */
	public void getElapseTime() {
		long elapseTime = mStopTime - mStartTime;
		System.out.println("Elapsed Time is:" + elapseTime / 1000f + " seconds");
	}
}
