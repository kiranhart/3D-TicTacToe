public class Logic {

	private String checkWinner() {
		
		for (int a = 0; a < 48; a++) {
			switch (a) {

			// First Layer //
			case 0:
				line = gameBoard[0] + gameBoard[1] + gameBoard[2];
				break;
			case 1:
				line = gameBoard[3] + gameBoard[4] + gameBoard[5];
				break;
			case 2:
				line = gameBoard[6] + gameBoard[7] + gameBoard[8];
				break;
			case 3:
				line = gameBoard[0] + gameBoard[3] + gameBoard[6];
				break;
			case 4:
				line = gameBoard[1] + gameBoard[4] + gameBoard[7];
				break;
			case 5:
				line = gameBoard[2] + gameBoard[5] + gameBoard[8];
				// First Layer Diagonals //
				break;
			case 6:
				line = gameBoard[0] + gameBoard[4] + gameBoard[8];
				break;
			case 7:
				line = gameBoard[2] + gameBoard[4] + gameBoard[6];
				break;
			// Second Layer //
			case 8:
				line = gameBoard[9] + gameBoard[10] + gameBoard[11];
				break;
			case 9:
				line = gameBoard[12] + gameBoard[13] + gameBoard[14];
				break;
			case 10:
				line = gameBoard[15] + gameBoard[16] + gameBoard[17];
				break;
			case 11:
				line = gameBoard[9] + gameBoard[12] + gameBoard[15];
				break;
			case 12:
				line = gameBoard[10] + gameBoard[13] + gameBoard[16];
				break;
			case 13:
				line = gameBoard[11] + gameBoard[14] + gameBoard[17];
				break;
			// Second Layer Diagonals //
			case 14:
				line = gameBoard[9] + gameBoard[13] + gameBoard[17];
				break;
			case 15:
				line = gameBoard[11] + gameBoard[13] + gameBoard[15];
				break;
			// Third layer //
			case 16:
				line = gameBoard[18] + gameBoard[19] + gameBoard[20];
				break;
			case 17:
				line = gameBoard[21] + gameBoard[22] + gameBoard[23];
				break;
			case 18:
				line = gameBoard[24] + gameBoard[25] + gameBoard[26];
				break;
			case 19:
				line = gameBoard[18] + gameBoard[21] + gameBoard[24];
				break;
			case 20:
				line = gameBoard[19] + gameBoard[22] + gameBoard[25];
				break;
			case 21:
				line = gameBoard[20] + gameBoard[23] + gameBoard[26];
				break;
			// Third Layer Diagonals //
			case 22:
				line = gameBoard[18] + gameBoard[22] + gameBoard[26];
				break;
			case 23:
				line = gameBoard[20] + gameBoard[22] + gameBoard[24];
				break;
			// 3D //
			case 24:
				line = gameBoard[0] + gameBoard[9] + gameBoard[18];
				break;
			case 25:
				line = gameBoard[1] + gameBoard[10] + gameBoard[19];
				break;
			case 26:
				line = gameBoard[2] + gameBoard[11] + gameBoard[20];
				break;
			case 27:
				line = gameBoard[3] + gameBoard[12] + gameBoard[21];
				break;
			case 28:
				line = gameBoard[4] + gameBoard[13] + gameBoard[22];
				break;
			case 29:
				line = gameBoard[5] + gameBoard[14] + gameBoard[23];
				break;
			case 30:
				line = gameBoard[6] + gameBoard[15] + gameBoard[24];
				break;
			case 31:
				line = gameBoard[7] + gameBoard[16] + gameBoard[25];
				break;
			case 32:
				line = gameBoard[8] + gameBoard[17] + gameBoard[26];
				break;
			case 33:
				line = gameBoard[0] + gameBoard[10] + gameBoard[20];
				break;
			case 34:
				line = gameBoard[3] + gameBoard[13] + gameBoard[23];
				break;
			case 35:
				line = gameBoard[6] + gameBoard[16] + gameBoard[26];
				break;
			case 36:
				line = gameBoard[20] + gameBoard[10] + gameBoard[0];
				break;
			case 37:
				line = gameBoard[23] + gameBoard[13] + gameBoard[3];
				break;
			case 38:
				line = gameBoard[26] + gameBoard[16] + gameBoard[6];
				break;
			case 39:
				line = gameBoard[0] + gameBoard[12] + gameBoard[24];
				break;
			case 40:
				line = gameBoard[1] + gameBoard[13] + gameBoard[25];
				break;
			case 41:
				line = gameBoard[2] + gameBoard[14] + gameBoard[26];
				break;
			case 42:
				line = gameBoard[24] + gameBoard[12] + gameBoard[0];
				break;
			case 43:
				line = gameBoard[25] + gameBoard[13] + gameBoard[1];
				break;
			case 44:
				line = gameBoard[26] + gameBoard[14] + gameBoard[2];
				break;
			case 45:
				line = gameBoard[0] + gameBoard[13] + gameBoard[26];
				break;
			case 46:
				line = gameBoard[26] + gameBoard[13] + gameBoard[0];
				break;
			case 47:
				line = gameBoard[2] + gameBoard[13] + gameBoard[24];
				break;
			case 48:
				line = gameBoard[24] + gameBoard[13] + gameBoard[2];
				break;
			}

			if (line == "XXX") {
				return "XXX";
			} else if (line == "OOO") {
				return "OOO";
			}
		}
		return "   ";
	}

	public boolean checkWinnerX() {
		if (checkWinner() == "XXX") {
			return true;
		}
		return false;
	}

	public boolean checkWinnerO() {
		if (checkWinner() == "OOO") {
			return true;
		}
		return false;
	}
}
