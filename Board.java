package UltiBoard;


public class Board {
	
	
	//These are 1d arrays to create the small boards 1-8
	// Boards is used to store these boards in a 2d array	
	static char[] board0 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board2 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board3 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board4 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board5 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board6 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board7 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[] board8 = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static char[][] boards = { board0, board1, board2, board3, board4, board5, board6, board7, board8 };

	// These can be considered like universal variables. These variables belong to this class but not the object
	static int[] smallBoardWinner = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };
	static boolean tie = false;
	static int player = 0;
	static char[] playerValue = { 'X', 'O' };

	// This block of code is commented out because i wanted the board to go from 1 - 9 instead of going from 0 - 8 but i came across 
	// some problems converting char to int back to char. Then i was planning to add one to the boxes and then subtract one to the 
	// inputs, while this did work it made the output very confusing for the user so i decided to not do this part
	
	/*
	 * public static char conversion(char boardValue) {
	 * 
	 * if(boardValue == 'X' || boardValue == 'O' || boardValue == '*') { return
	 * boardValue; } else {
	 * 
	 * int value = Integer.parseInt(String.valueOf(boardValue)); value = value + 1;
	 * char b = Character.forDigit(value , 10); return b; }
	 * 
	 * }
	 */

	// This method is used to print the actual board
	// I used for loops to print out the | lines and each for loop represents a row of the board
	public static void print() {

		System.out.println("-------------------------------------------");
		System.out.println("         ULTIMATE TIC TAC TOE!!!!");
		System.out.println("-------------------------------------------");

		System.out.println("------0------  ------1------  ------2------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 1) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 2) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {

				if (j == 3) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 4) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 5) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {

				if (j == 6) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 7) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 8) {
					System.out.print(" | " + boards[i][j] + " |");
				}
			}
			System.out.print("  ");
		}
		System.out.println("");
		System.out.println("-------------  -------------  -------------");
		System.out.println("------3------  ------4------  ------5------");

		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 1) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 2) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {

				if (j == 3) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 4) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 5) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 3; i < 6; i++) {
			for (int j = 6; j < 9; j++) {

				if (j == 6) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 7) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 8) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");
		System.out.println("-------------  -------------  -------------");
		System.out.println("------6------  ------7------  ------8------");

		///////////////////////////////////
		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {

				if (j == 0) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 1) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 2) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {

				if (j == 3) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 4) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 5) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 0; i < 3; i++) {
			System.out.print("|---+---+---|");
			System.out.print("  ");
		}
		System.out.println("");

		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {

				if (j == 6) {
					System.out.print("| " + boards[i][j]);
				}
				if (j == 7) {
					System.out.print(" | " + boards[i][j]);
				}
				if (j == 8) {
					System.out.print(" | " + boards[i][j] + " |");
				}

			}
			System.out.print("  ");
		}
		System.out.println("");
		System.out.println("-------------  -------------  -------------");
		System.out.println("-------------------------------------------");
	}
	
	
	// This method will print out astriks on the small board boxes when a player wins on one of the boards
	public static void astrik(int board) {
		// if the current board is in box 0 is not X and current board in box 0 is not O then replace those spaces with astriks
		if ((boards[board][0] != 'X') && (boards[board][0] != 'O')) {
			boards[board][0] = '*';
		}
		if ((boards[board][1] != 'X') && (boards[board][1] != 'O')) {
			boards[board][1] = '*';
		}
		if ((boards[board][2] != 'X') && (boards[board][2] != 'O')) {
			boards[board][2] = '*';
		}
		if ((boards[board][3] != 'X') && (boards[board][3] != 'O')) {
			boards[board][3] = '*';
		}
		if ((boards[board][4] != 'X') && (boards[board][4] != 'O')) {
			boards[board][4] = '*';
		}
		if ((boards[board][5] != 'X') && (boards[board][5] != 'O')) {
			boards[board][5] = '*';
		}
		if ((boards[board][6] != 'X') && (boards[board][6] != 'O')) {
			boards[board][6] = '*';
		}
		if ((boards[board][7] != 'X') && (boards[board][7] != 'O')) {
			boards[board][7] = '*';
		}
		if ((boards[board][8] != 'X') && (boards[board][8] != 'O')) {
			boards[board][8] = '*';
		}

	}
	
	
	// This checks through every state of the small board condition and sees if it is a winning condition
	public static boolean winSmallBoard(int player, int board) {
		// Player variable represents player state
		char playerVal;
		if (player == 1) {
			playerVal = 'O';
		} else {
			playerVal = 'X';
		}
		
		// This checks through every state of the small board condition and sees if it is a winning condition
		if ((boards[board][0] == boards[board][1]) && (boards[board][1] == boards[board][2])
				&& (boards[board][0] == playerVal)
				|| (boards[board][3] == boards[board][4]) && (boards[board][4] == boards[board][5])
						&& (boards[board][3] == playerVal)
				|| (boards[board][6] == boards[board][7]) && (boards[board][7] == boards[board][8])
						&& (boards[board][6] == playerVal)
				|| (boards[board][0] == boards[board][3]) && (boards[board][3] == boards[board][6])
						&& (boards[board][0] == playerVal)
				|| (boards[board][1] == boards[board][4]) && (boards[board][4] == boards[board][7])
						&& (boards[board][1] == playerVal)
				|| (boards[board][2] == boards[board][5]) && (boards[board][5] == boards[board][8])
						&& (boards[board][2] == playerVal)
				|| (boards[board][0] == boards[board][4]) && (boards[board][4] == boards[board][8])
						&& (boards[board][0] == playerVal)
				|| (boards[board][2] == boards[board][4]) && (boards[board][4] == boards[board][6])
						&& (boards[board][2] == playerVal)) {
			// This if statement returns true because a winning condition is selected
			return true;

		} else {
			// This if statement returns true because a winning condition is not selected
			return false;
		}

	}
	
	// This funciton is used to check bigboard
	public static boolean isWinner(int player) {
		// This checks through all states of the big board condition and sees if it is a winning condition 
		if (winSmallBoard(player, 0) && winSmallBoard(player, 1) && winSmallBoard(player, 2)
				|| winSmallBoard(player, 3) && winSmallBoard(player, 4) && winSmallBoard(player, 5)
				|| winSmallBoard(player, 6) && winSmallBoard(player, 7) && winSmallBoard(player, 8)
				|| winSmallBoard(player, 0) && winSmallBoard(player, 3) && winSmallBoard(player, 6)
				|| winSmallBoard(player, 1) && winSmallBoard(player, 4) && winSmallBoard(player, 7)
				|| winSmallBoard(player, 2) && winSmallBoard(player, 5) && winSmallBoard(player, 8)
				|| winSmallBoard(player, 0) && winSmallBoard(player, 4) && winSmallBoard(player, 8)
				|| winSmallBoard(player, 2) && winSmallBoard(player, 4) && winSmallBoard(player, 6)) {
			// This if statement returns false because a losing condition is selected
			return false;
		} else {
			// This if statement returns true because a winning condition is selected for the big board
			return true;
		}
	}
	
	// This method uses board and square to check if the specific square in the board is avaliable 
	public static boolean isAvailable(int board, int square) {
		// this checks through the individual board and square using a 2d tensor
		if ((boards[board][square] >= '0' && boards[board][square] <= '8') || boards[board][square] == '*') {
			// This if statement returns true if the if the board state is greater than 0 and less than 8 or if a player is not in a winning state
			return true;
		} else {
			// This if statement returns false if the board state is less than 0
			return false;
		}
	}
	
	// This method is used to check the state of the board
	public static boolean isFull(int board) {
		// This checks through each board using the isAvaliable method to check if the board is full or not
		if (isAvailable(board, 0) || isAvailable(board, 1) || isAvailable(board, 2) || isAvailable(board, 3)
				|| isAvailable(board, 4) || isAvailable(board, 5) || isAvailable(board, 6) || isAvailable(board, 7)
				|| isAvailable(board, 8)) {
			//This statement returns false if the small board is not full
			return false;
		} else {
			// This else statement returns true if the small board is full
			return true;
		}
	}
	
	//  This method tells the user the board that you are currently on
	public static int autoSelectedBoard(int board) {
		System.out.println("Selected Board : " + board++);
		board--;
		return board;
	}
	
	// This method prints out the winning player based on the represented value
	public static void winnerPrint() {
		// This loop looks at who is the winner of the small board and returns the winner or returns a tie.
		for (int i = 0; i < smallBoardWinner.length; i++) {
			

				if (smallBoardWinner[i] == 0) {
					System.out.println(
							"-----------------------------------------------------------------------------------");
					System.out.println("The board #" + i + " Winner is X");
					System.out.println(
							"-----------------------------------------------------------------------------------");
				}
				if (smallBoardWinner[i] == 1) {
					System.out.println(
							"-----------------------------------------------------------------------------------");
					System.out.println("The board #" + i + " Winner is O");
					System.out.println(
							"-----------------------------------------------------------------------------------");
				}
				if (smallBoardWinner[i] == 2) {
					System.out.println(
							"-----------------------------------------------------------------------------------");
					System.out.println("its a tie for board " + i);
					System.out.println(
							"-----------------------------------------------------------------------------------");
				}
			
		}

	}
	
	// This method takes the state of a player and determines if it is a tie if player 2 wins or player 1 wins 
	public static void tie(int player) {
		
		// If tie is true then it is a tie but if the player is 0 then x wins and if the player is 1 then O wins
		if (tie == true) {
			System.out.println("This is a tie");
		} else {

			if (player == 0) {
				System.out
						.println("-----------------------------------------------------------------------------------");
				System.out.println("player2 O! wins");
				System.out
						.println("-----------------------------------------------------------------------------------");
			} else {
				System.out
						.println("-----------------------------------------------------------------------------------");
				System.out.println("player1 X! wins");
				System.out
						.println("-----------------------------------------------------------------------------------");
			}
		}
	}

}
