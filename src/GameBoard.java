public class GameBoard {

	public static String playerFree = " ";
	public static String playerX = "X";
	public static String playerO = "O";
	
    //This represents the possibilities of 0 to 8, 9 to 17, and 18 to 26 on the dimensions of the GameBoard
	public String[] gameBoard = new String[26];

	public GameBoard() 
	{	//Initialize the game board to an empty state
		for( int i = 0; i < gameBoard.length; i++)
			gameBoard[i] = playerFree; 
	}

	//Returns Free, X, or O depending how the board space is occupied
	public boolean checkMove(int moveLocation) 
	{
		//Checks if there are any valid or invalid board positions
		if (gameBoard[moveLocation] == playerFree) {
			return true;
		}
		return false;
	}
	
	    //Returns true/false depending if move is valid
		public boolean makeMove(String playerXO,int moveLocation) 
		{
			//Checks to see if the user input is valid when they select a letter
			if (playerXO != playerX && playerXO != playerO) //If not equal to correct String  
			{
		       return false; //Return as invalid
		    }
		   
			//Checks if Board position is occupied/taken
			if (!checkMove(moveLocation)) {
				return false; //Returns false (invalid) if taken
			}
			
			gameBoard[moveLocation] = playerXO;
			return true; //Returns as true (valid) if not
	 }
	
	public void RefreshBoard() 
	{
		//Loop the already filled game board to an empty state
		for( int i = 0; i < gameBoard.length; i++)
			gameBoard[i] = " "; //Fill all positions as a blank String
			
    }
}