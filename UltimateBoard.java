/*
 * Name: Varun Todupunoori
 * Class: CS 2336.0W1
 * Date: 4/29/2021
 * Professor Borazjany
 * NetID: VXT162730
 */

/*
 * Analysis:
 * This project asks us to code a ultimate tic tac toe board which consist of 9 individual tic tac toe games in each square of 1 larger
 * tic tac toe board. We also have to program the board where the player can only place a mark on the board determined by the position
 * of the opponents last placed mark. This program should be done in object oriented way. There should also be user input corrections if the user
 * enters a value for the input which is not taken. You also should have the code to where if the board is won by player X or player O a console prompt will appear 
 * for which player won which specific board. At the end of the game there should be a running prompt of which player won which individual board and who won the ultimate big board.
 * This program also needs to run player vs player, player vs ai, and ai vs ai to test the different problems that might occur. If a player wins a certain board
 * the rest of the numbers on that board should be changed to astriks. In the user input if a wrong input is chosen, then a input correction should appear and loop till the right input is chosen.
 * There should also be a clear board that is easy to read and understand to play the game. A tie method should also be implemented if the board is unwinnable.
 */

/*
 * Design:
 * 1. First asks the user to pick the game mode using the player option method
 * 	* depending on their choice 1: player VS AI, choice 2: player vs player, choice 3: AI vs AI 
 * 2. Prints out the board using the print method and prompts the user to select the board that they want to start on using the user select board method
 * 3. Depending on the choice made in the option method:
 * 	* if the choice is 1 or choice is 2 then the player will be asked to select a box on the board to start with
 * 	* if the option is 3 then the board is still selected by the user but the box is now auto selected by the AI using the AISelectesBox method
 * 	* for each option the code will check the square of a specific board that is chosen to see if it is available using the is avaliable method
 * 	* if the square is not available the code will then check if the specified board is full or not. 
 * 	* if the board is full then the for Human vs Human it will return an error and ask to select a proper board
 * 	* But if it is an AI it will automatically select another board 
 * 	* In any of the options if the specific board becomes full then it will check for the board winner or board tie using the board winner method
 * 5. The code then switches the player after the choice is made using the switchplayer method
 * 6. After the player is switched the game will take the previous entered square and use it as the new board and prompts the player to select a box in that specific board
 * 7. If there is a winner in a specific board then that board and which player won it is outputted as the code runs
 * 8. At the end prints the winner of the individual board
 * 9. and prints the results of the tic tac toe game 
 */

package UltiBoard;

import java.util.Scanner;

public class UltimateBoard extends Board {

	public static void main(String[] args) {

		// This piece of commented code here is instianting the different classes.
		// It is not needed because UltimateBoard extends to every other class
		/*
		 * AIplayer AI = new AIplayer(); HumanPlayer Human = new HumanPlayer(); Board
		 * board1 = new Board();
		 */

		// This char array is initializing the player1: X and player 2:O.
		// This is also initializing and setting board and square to 0
		// char[] playerValue = { 'X', 'O' };
		int board = 0;
		int square = 0;
		boolean theWinner = true;

		/*
		 * This is calling the options the human player can choose for if they want to
		 * play aganist: 1. Option 1: Hutman vs AI, Option 2: Human vs Human, and option
		 * 3: AI vs AI
		 */
		
		// asks the user to pick a choice of game mode
		int choice = HumanPlayer.playerOptions();
		
		// prints the board 
		print();
		
		// The user selects the game board to start on
		board = HumanPlayer.humanSelectsBoard();
		
		// If the win condition is true go to the following if statement 
		while (theWinner) {
			// and if the player id is 0(X) then go into the next if statement for choice
			if (player == 0) {
				// if the choice is equal to 1 or equal to 2 then select the board for the human and it calls the user to select the box from Human player
				if (choice == 1 || choice == 2) {
					System.out.println("Selected Board: "+ board);
					square = HumanPlayer.humanSelectsBox();
					// takes the is available method and passes board and square into the method and then checks to see if the squares in the board is available or not
					if (!isAvailable(board, square)) {
						// This if statement takes the isFull method and passes in the square into it and sees if the board is full
						if (isFull(square)) {
							// if the method smallBoardWinner is the default value (9)
							if(smallBoardWinner[square] == 9) {
								// then it is a tie
								smallBoardWinner[square] = 2;
							}
							// This method call asks the user to select a board 
							board = HumanPlayer.humanSelectsBoard();
						} else {
							// takes in square and prints the current board state and returns square 
							// also sets current board state
							board = autoSelectedBoard(square);
						}
						
						// while the square on the board is not available 
						while (!isAvailable(board, square)) {
							//correct the user and tell them to select another square
							HumanPlayer.inputCorrectionHuman();
							square = HumanPlayer.humanSelectsBox();
						}
						
						// sets the current board space to player 0
						boards[board][square] = playerValue[0];
					} else {
						// sets the current board space to the current player
						boards[board][square] = playerValue[player];
					}
				} else {
					
					// tells the user the current board
					System.out.println("Selected Board: "+ board);
					
					// The AI selects a square on the board
					square = AIplayer.aiSelectsBox();
					//
					//
					//
					// This statement checks if the square on the board is available or not
					if (!isAvailable(board, square)) {
						// This statement checks each square to see if the board is full
						if (isFull(square)) {
							// if the method smallBoardWinner is the default value (9)
							if(smallBoardWinner[square] == 9) {
								// then it is a tie
								smallBoardWinner[square] = 2;
							}
							// This method calls to ask the AI to select board if the board is full
							board = AIplayer.aiSelectsABoard();
						} else {
							// takes in square and prints the current board state and returns square 
							// also sets current board state
							board = autoSelectedBoard(square);
						}
						
						// while the square on the board is not available 
						while (!isAvailable(board, square)) {
							// This will out put an error
							AIplayer.inputCorrectionComputer();
							
							// The AI selects a square on the board
							square = AIplayer.aiSelectsBox();
						}
						
						// sets the current board space to player 0
						boards[board][square] = playerValue[0];
					} else {
						// sets the current board space to the current player
						boards[board][square] = playerValue[player];
					}

				}
				// prints the board
				print();
				
				// This checks through every state of the small board condition and sees if it is a winning condition
				if (winSmallBoard(player, board) && (smallBoardWinner[board] == 9)) {
					
					// makes the small board winner array equal to the player
					smallBoardWinner[board] = player;
					// puts astriks on the small board if the player won that board
					astrik(board);
					// prints out the winner of of the board or if it is a tie
					Board.winnerPrint();
				}
				// This checks through all states of the big board condition and sees if it is a winning condition 
				theWinner = isWinner(player);
				
				// This for loop is used to check for a tie
				int counter = 0;
				for (int z = 0; z < 8; z++) {
					if (smallBoardWinner[z] != 9) {
						counter++;
					}
					if (counter == 8) {
						theWinner = false;
						tie = true;
					}
				}
				
				// if the winner is true then switch the player
				if (theWinner)
					player = SwitchingPlayer.switchPlayer(player);
			
			// This else is used to check the second half of the score 
			} else {
				
				// if the choice is 2 "human vs human "
				if (choice == 2) {
					//  prompt to select board
					System.out.println("Selected Board: "+ board);
					// asks the user to select the square in the board
					square = HumanPlayer.humanSelectsBox();
					// This statement checks if the square on the board is available or not
					if (!isAvailable(board, square)) {
						//// This statement checks each square to see if the board is full
						if (isFull(square)) {
							// if the method smallBoardWinner is the default value (9)
							if(smallBoardWinner[square] == 9) {
								// then it is a tie
								smallBoardWinner[square] = 2;
							}
							// tells the user to select a different board and sets that board to the current instance
							board = HumanPlayer.humanSelectsBoard();
						} else {
							// automatically selects the board that was chosen by the other player
							board = autoSelectedBoard(square);
						}
						
						// while the square on the board is not available 
						while (!isAvailable(board, square)) {
							
							//correct the user and tell them to select another square
							HumanPlayer.inputCorrectionHuman();
							square = HumanPlayer.humanSelectsBox();
						}
						// sets the current board space to player 1
						boards[board][square] = playerValue[1];
					} else {
						// sets the current board space to the current player
						boards[board][square] = playerValue[player];
					}
				} else {
					// print statement to print the board that was selected
					System.out.println("Selected Board: "+ board);
					// Ai player will automatically select box
					square = AIplayer.aiSelectsBox();

					// This statement checks if the square on the board is available or not
					if (!isAvailable(board, square)) {
						// This statement checks each square to see if the board is full
						if (isFull(square)) {
							// This method calls to ask the AI to select a box if the random box picked was taken
							square = AIplayer.aiSelectsBox();
							
							// if the method smallBoardWinner is the default value (9)
							if(smallBoardWinner[square] == 9) {
								// then it is a tie
								smallBoardWinner[square] = 2;
							}
							// asks AI to select a new board if the board is filled and it will select a random board
							board = AIplayer.aiSelectsABoard();
						} else {
							
							// takes in square and prints the current board state and returns square 
							// also sets current board state
							// automatically selects the board that was chosen by the other player
							board = autoSelectedBoard(square);
						}
						
						// While the square is not avaliable
						while (!isAvailable(board, square)) {
							// outs an error
							AIplayer.inputCorrectionComputer();
							
							// and asks the ai to select a new box 
							square = AIplayer.aiSelectsBox();
						}
						
						// sets the current board space to player 1
						boards[board][square] = playerValue[1];
					} else {
						// sets the current board space to the current player
						boards[board][square] = playerValue[player];
					}
				}
				// prints the current board state
				print();
				
				// This checks through every state of the small board condition and sees if it is a winning condition
				if (winSmallBoard(player, board) && (smallBoardWinner[board] == 9)) {
					
					// makes the small board winner array equal to the player
					smallBoardWinner[board] = player;
					// puts astriks on the small board if the player won that board
					astrik(board);
					
					// prints the winner of the board or prints if it is a tie
					Board.winnerPrint();
				}
				
				// This checks through all states of the big board condition and sees if it is a winning condition 
				theWinner = isWinner(player);
				
				// used to check tie
				int counter = 0;
				for (int z = 0; z < 8; z++) {
					if (smallBoardWinner[z] != 9) {
						counter++;
					}
					if (counter == 8) {
						theWinner = false;
						tie = true;
					}
				}
				
				// if the winner is true switch the player
				if (theWinner)
					player = SwitchingPlayer.switchPlayer(player);
			}
			
			// sets the board value equal to the square value
			board = square;
		}
		
		// prints the winner of the individual board
		Board.winnerPrint();
		// prints the outcome of the ultimate tic tac toe game 
		Board.tie(player);

	}
}
