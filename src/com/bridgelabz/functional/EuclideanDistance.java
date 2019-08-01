/*
 * @purpose	: Calculate Distance from Origin
 * @author	:sangita awaghad
 * @since	:30-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class EuclideanDistance {
	public static void main(String[] args) {
		Utility utility=new Utility();
		
		float x = Float.parseFloat(args[0]);
		float y = Float.parseFloat(args[1]);

		utility.calculateDistance(x, y);
	}

	
}
