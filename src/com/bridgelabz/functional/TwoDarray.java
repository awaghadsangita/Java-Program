package com.bridgelabz.functional;

import java.io.PrintWriter;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TwoDarray {
	public static void main(String[] args) {
		try {
			Utility utility = new Utility();
			System.out.println("How many Rows you want in array");
			int row = utility.getInteger();
			System.out.println("How many Column you want in array");
			int col = utility.getInteger();
			int[][] intArr = new int[row][col];
			double[][] doubleArr = new double[row][col];
			boolean[][] booleanArr = new boolean[row][col];

			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					System.out.println("Enter integer (intArr[" + r + "][" + c + "]value:");
					intArr[r][c] = utility.getInteger();
				}
			}
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					System.out.println("Enter Double (doubleArr[" + r + "][" + c + "]value:");
					doubleArr[r][c] = utility.getDouble();
				}
			}
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					System.out.println("Enter Boolean (booleanArr[" + r + "][" + c + "]value:");
					booleanArr[r][c] = utility.getBoolean();
				}
			}
			PrintWriter pw = new PrintWriter(System.out, true);
			System.out.println("Your Interger 2D Array is:");
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
//				System.out.print("|"+intArr[r][c]);
					pw.print("|" + intArr[r][c]);
				}
				pw.println("|");
			}
			System.out.println("\nYour Double 2D Array is:");
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					System.out.print("|" + doubleArr[r][c]);
				}
				System.out.println("|");
			}
			System.out.println("\nYour Boolean 2D Array is:");
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					System.out.print("|" + booleanArr[r][c]);
				}
				System.out.println("|");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
