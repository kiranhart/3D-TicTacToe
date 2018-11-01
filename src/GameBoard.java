
public class GameBoard {

	public static String playerFree = " ";
	public static String playerX = "X";
	public static String playerO = "O";

	private String[] gameBoard = new String[36];

	public GameBoard() {
		// Initialize the game board to empty state
		for( int i = 0; i < gameBoard.length; i++)
			gameBoard[i] = playerFree; 

	}

	private int mapFromLvlRowCol(int lvl, int row, int col) {
		int map = (lvl - 1) * 9;  // 1:0 to 8, 2: 9 to 17, 3: 18 to 36
		map = map + (row - 1) * 3;  
		map = map + (col - 1);
		return map;
	}
	
	private int levelFromMap(int map) {
		int level = java.lang.Math.round(map / 9);
		return level + 1;
	}
	
	private int rowFromMap(int map) {
		int subMap = map % 9;
		int row = java.lang.Math.round(subMap / 3);
		return row + 1;
	}
	
	private int colFromMap(int map) {
		int subMap = map % 9;
		subMap = subMap % 3;
		int col = java.lang.Math.round(subMap / 3);
		return col + 1;
	}

	public String checkMove(int lvl, int row, int col) {
		int map = mapFromLvlRowCol(lvl, row, col);
		return gameBoard[map];
	}
	
	public boolean makeMove( String playerXO,int lvl, int row, int col) {
		if (checkMove(lvl, row, col)  != playerFree) {
			return false;
		}
		int map = mapFromLvlRowCol(lvl, row, col);
		gameBoard[map] = playerXO;
		return true;
	}

}
