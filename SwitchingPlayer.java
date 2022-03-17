package UltiBoard;

public class SwitchingPlayer {
	
	// This method takes player 0 and 1 and switches the player
	public static int switchPlayer(int player) {
		// if the player is a 0 then it switches to the other player 
		if (player == 0) {
			return 1;
		} else {
			return 0;
		}

	}
}
