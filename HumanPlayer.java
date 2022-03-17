package UltiBoard;

import java.util.Scanner;

public class HumanPlayer extends Board {

	// This method is used by the user to select the board in human vs AI and human vs human
	public static int humanSelectsBoard() {
		
		
		int size = 8;
		int boardNum = 0;
		// Suppresses the input warning
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		// This do while loop checks that the wrong integer isnt entered and also that any other character isnt entered except for the board number. If anything is entered then it will loop the Please select a valid board
		do {
			System.out.println("Please select a valid board: ");
			while (!input.hasNextInt()) {
				System.out.println("Please select a valid board: ");
				input.next();
			}
			boardNum = input.nextInt();
		} while (boardNum < 0 || boardNum > size);
		return boardNum;
	}

	// this method is used to let the user select the specific box they want to put their X or O inside of
	public static int humanSelectsBox() {
		int size = 8;
		int squareNum = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		do {
			// Takes the input of the selected board and if it is an invalid int then the question will be asked again until the valid box is entered
			// the while loop says if the input is not an integer then please select a valid box on the board
			// This method will also show the squre that was selected and then returns that square
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Please select a valid box on the selected board:");
			while (!input.hasNextInt()) {
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println("Your value is not an integer value, Please select a different integer value:");
				input.next();
			}
			squareNum = input.nextInt();
		} while (squareNum < 0 || squareNum > size);
		System.out.println("Selected Square : " + squareNum);
		return squareNum;

	}
	
	// this is an extra method that will correct an invalid input. it is not needed but overall helps the code look cleaner
	public static int inputCorrectionHuman() {
		int size = 8;
		int squareNum = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Invalid input, please select another square:");
			squareNum = input.nextInt();
		} while (squareNum < 0 || squareNum > size);
		System.out.println("Selected Square : " + squareNum);
		return squareNum;

	}

	// This is a method that lets the user pick 3 options which are human vs ai human vs human and ai vs ai
	public static int playerOptions() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		// Do while is used for input correction for the sys statement. If the entered value is below 1 or greater than 3 then it will ask you to do it again, and if the choice is not an int it will ask you to choose again
		do {
			System.out.println("Select Mode: \n1: Human vs AI \n2: Human vs Human \n3: AI vs AI");
			while (!input.hasNextInt()) {

				System.out.println("Error try again: ");
				input.next();
			}
			choice = input.nextInt();
		} while (choice < 1 || choice > 3);
		
		// states what the user chose and returns the integer choice
		System.out.println("Your choice is: " + choice);

		return choice;
	}

}
