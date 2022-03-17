package UltiBoard;

public class AIplayer extends HumanPlayer {
	
	/* 
	 * This function is here so that the ai bot will select a board in the AI vs AI. It uses the math.random to get input a random number
	 * while the the board is full pick another board randomly
	 */
	public static int aiSelectsABoard() {
		
		int boardNum = 0;
		
		boardNum = (int) (Math.random() * 9);
		while (isFull(boardNum)) {
			
			boardNum = (int) (Math.random() * 9);
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Selected Board : " + boardNum);
		return boardNum;
	}
	
	// This will let ai select a random box
	public static int aiSelectsBox() {
		int size = 9;
		int squareNum;
		squareNum = (int) (Math.random() * size);
		System.out.println("Selected Box : " + squareNum);
		System.out.println("-----------------------------------------------------------------------------------");
		return squareNum;

	}
	
	// This is just used to print our an error if the selected box in the small board is already filled and then it picks another square
	public static int inputCorrectionComputer() {
		int size = 9;
		int squareNum;
		squareNum = (int) (Math.random() * size);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("This is an error please select another Box!");
		return squareNum;

	}
}
