/*
 * @purpose	:Implement Tic-Tac-Toe Game
 * @author	:sangita awaghad
 * @since	:31-07-2019
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class CrossGame {
	static char board[][] = new char[][] { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
	static int position;
	static int count01 = 0, count02 = 0, count03 = 0, count04 = 0, count05 = 0, count06 = 0, count07 = 0, count08 = 0,
			count = 0;
	static int countx1 = 0, countx2 = 0, countx3 = 0, countx4 = 0, countx5 = 0, countx6 = 0, countx7 = 0, countx8 = 0;
	static boolean[] win = new boolean[] { false, false };
	// count01-(1,2,3), count04-(1,4,7)
	// count02-(2,5,6), count05-(2,5,8)
	// count03-(7,8,9), count06-(7,8,9)
	// count07-(1,5,9), count08-(3,5,7)

	public static void main(String args[]) {
		Utility utility = new Utility();

		System.out.println("The Tic-Toc-Toe Game ");
		final CrossGame crossgame = new CrossGame();

		try {
			do {
				if (count == 9) {
					break;
				}
				crossgame.displayBoard();
				crossgame.getValueFromUser();
				count++;

				if (count == 9) {
					break;
				}
				crossgame.displayBoard();
				crossgame.getValueFromComputer();
				count++;

				if (count01 == 3 || count02 == 3 || count03 == 3 || count04 == 3 || count05 == 3 || count06 == 3
						|| count07 == 3 || count08 == 3) {
					win[1] = true;
					break;
				}
				if (countx1 == 3 || countx2 == 3 || countx3 == 3 || countx4 == 3 || countx5 == 3 || countx6 == 3
						|| countx7 == 3 || countx8 == 3) {
					win[0] = true;
					break;
				}
			} while (!win[0] || !win[1]);
			crossgame.displayBoard();
			if (win[0]) {
				System.out.println("User Win the Match");
			} else if (win[1]) {
				System.out.println("Computer Win the Match");
			} else {
				System.out.println("Match Draw");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Display Board
	public void displayBoard() {
		System.out.println();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print("|" + board[row][col]);
			}
			System.out.println("|");
		}
		System.out.println();
	}

	// Get Position From User
	public void getValueFromUser() {
		Utility utility = new Utility();
		System.out.println("Enter the Position");
		position = utility.getInteger();
		System.out.println(position);
		switch (position) {
		case 1:
			if (board[0][0] == 'x' || board[0][0] == '0') {
				getValueFromUser();
			} else {
				board[0][0] = 'x';
				countx1++;
				countx4++;
				countx7++;
			}
			break;
		case 2:
			if (board[0][1] == 'x' || board[0][1] == '0')
				getValueFromUser();
			else {
				board[0][1] = 'x';
				countx1++;
				countx5++;
			}
			break;
		case 3:
			if (board[0][2] == 'x' || board[0][2] == '0')
				getValueFromUser();
			else {
				board[0][2] = 'x';
				countx1++;
				countx6++;
				countx8++;
			}
			break;
		case 4:
			if (board[1][0] == 'x' || board[1][0] == '0')
				getValueFromUser();
			else {
				board[1][0] = 'x';
				countx2++;
				countx4++;
			}
			break;
		case 5:
			if (board[1][1] == 'x' || board[1][1] == '0')
				getValueFromUser();
			else {
				board[1][1] = 'x';
				countx2++;
				countx5++;
				countx7++;
				countx8++;
			}
			break;
		case 6:
			if (board[1][2] == 'x' || board[1][2] == '0')
				getValueFromUser();
			else {
				board[1][2] = 'x';
				countx2++;
				countx6++;
			}
			break;
		case 7:
			if (board[2][0] == 'x' || board[2][0] == '0')
				getValueFromUser();
			else {
				board[2][0] = 'x';
				countx3++;
				countx4++;
				countx8++;
			}
			break;
		case 8:
			if (board[2][1] == 'x' || board[2][1] == '0')
				getValueFromUser();
			else {
				board[2][1] = 'x';
				countx3++;
				countx5++;
			}
			break;
		case 9:
			if (board[2][2] == 'x' || board[2][2] == '0')
				getValueFromUser();
			else {
				board[2][2] = 'x';
				countx3++;
				countx6++;
				countx7++;
			}
			break;
		default:
			System.out.println("Please Enter position in between 1-9:");
		}
	}

	// Get Position From computer
	public void getValueFromComputer() {
		Utility utility = new Utility();

		System.out.println("Computer Turns:");
		int rand = utility.giveRandomNumber(10);

		int position = rand;
		System.out.println(position);
		switch (position) {
		case 1:
			if (board[0][0] == 'x' || board[0][0] == '0')
				getValueFromComputer();
			else {
				board[0][0] = '0';
				count01++;
				count04++;
				count07++;
			}
			break;
		case 2:
			if (board[0][1] == 'x' || board[0][1] == '0')
				getValueFromComputer();
			else {
				board[0][1] = '0';
				count01++;
				count05++;
			}
			break;
		case 3:
			if (board[0][2] == 'x' || board[0][2] == '0')
				getValueFromComputer();
			else {
				board[0][2] = '0';
				count01++;
				count06++;
				count08++;
			}
			break;
		case 4:
			if (board[1][0] == 'x' || board[1][0] == '0')
				getValueFromComputer();
			else {
				board[1][0] = '0';
				count02++;
				count04++;
			}
			break;
		case 5:
			if (board[1][1] == 'x' || board[1][1] == '0')
				getValueFromComputer();
			else {
				board[1][1] = '0';
				count02++;
				count05++;
				count07++;
				count08++;
			}
			break;
		case 6:
			if (board[1][2] == 'x' || board[1][2] == '0')
				getValueFromComputer();
			else {
				board[1][2] = '0';
				count02++;
				count06++;
			}
			break;
		case 7:
			if (board[2][0] == 'x' || board[2][0] == '0')
				getValueFromComputer();
			else {
				board[2][0] = '0';
				count03++;
				count04++;
				count08++;
			}
			break;
		case 8:
			if (board[2][1] == 'x' || board[2][1] == '0')
				getValueFromComputer();
			else {
				board[2][1] = '0';
				count03++;
				count05++;
			}
			break;
		case 9:
			if (board[2][2] == 'x' || board[2][2] == '0')
				getValueFromComputer();
			else {
				board[2][2] = '0';
				count03++;
				count06++;
				count07++;
			}
			break;
		default:
			System.out.println("Please Enter position in between 1-9:");
			getValueFromComputer();
		}

	}

}
