package com.bridgelab.objectoriented;

import java.util.Random;

public class DeckOfCards {
	static String[] SUIT = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"  };

	public static void main(String args[]) {
		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
		int i = 0;
		int j = 0;
		shuffle(a, 52);
		String player[][] = new String[4][9];
		LinkedListQue listOfCards = new LinkedListQue();
		for (int p = 0; p < 4; p++) {

			for (int c = 0; c < 9; c++) {
				CardNode newNode = new CardNode();
				if (a[i] >= 0 && a[i] < 13) {
					
					newNode.suit = SUIT[j];
					newNode.rank = RANK[a[i] % 13];
					listOfCards.add(newNode);

				} else if (a[i] >= 13 && a[i] < 26) {
					
					newNode.suit = SUIT[j + 1];
					newNode.rank = RANK[a[i] % 13];
					listOfCards.add(newNode);
				} else if (a[i] >= 26 && a[i] < 39) {
					
					newNode.suit = SUIT[j + 2];
					newNode.rank = RANK[a[i] % 13];
					listOfCards.add(newNode);
				} else if (a[i] >= 39 && a[i] < 52) {
					
					newNode.suit = SUIT[j + 3];
					newNode.rank = RANK[a[i] % 13];
					listOfCards.add(newNode);
				}
				i++;

			}
		}
		System.out.println("*********Cards in Link List*****");
		listOfCards.show();
		System.out.println("\n==========Cards sorted by Players========");
		listOfCards.sort();

		print(a);

	}

	public static void print(int[] a) {
		String player[][] = new String[4][9];
		int i = 0;
		int j = 0;
		for (int p = 0; p < 4; p++) {

			for (int c = 0; c < 9; c++) {

				if (a[i] >= 0 && a[i] < 13) {
					player[p][c] = SUIT[j] + " " + RANK[a[i] % 13];

				} else if (a[i] >= 13 && a[i] < 26) {
					player[p][c] = SUIT[j + 1] + " " + RANK[a[i] % 13];

				} else if (a[i] >= 26 && a[i] < 39) {
					player[p][c] = SUIT[j + 2] + " " + RANK[a[i] % 13];

				} else if (a[i] >= 39 && a[i] < 52) {
					player[p][c] = SUIT[j + 3] + " " + RANK[a[i] % 13];

				}
				i++;

			}
		}
		System.out.println("\n*******cards in 2D array********");
		for (int p = 0; p < 4; p++) {
			System.out.println("========\nPlayer :" + p + 1);
			for (int c = 0; c < 9; c++) {
				System.out.println(player[p][c]);

			}
		}
	}

	public static void shuffle(int card[], int n) {

		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			// Random for remaining positions.
			int r = i + rand.nextInt(52 - i);

			// swapping the elements
			int temp = card[r];
			card[r] = card[i];
			card[i] = temp;

		}
	}

}
