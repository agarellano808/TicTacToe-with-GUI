public class game {
	private char arr[][];
	private player p1;
	private player p2;
	private int turn;

	public game(char p1Symbol) {
		arr = new char[3][3];
		setPlayers(p1Symbol);
	}

	public game(game g) {
		arr=g.getBoard();
		
	}
	public void mark(char c, int x, int y) {
		arr[x][y] = c;
		
	}

	public boolean check(char s) {
		if ((arr[0][0] == s) && (arr[0][1] == s) && (arr[0][2] == s)) {
			return true;
		}
		if ((arr[1][0] == s) && (arr[1][1] == s) && (arr[1][2] == s)) {
			return true;
		}
		if ((arr[2][0] == s) && (arr[2][1] == s) && (arr[2][2] == s)) {
			return true;
		}
		if ((arr[0][0] == s) && (arr[1][0] == s) && (arr[2][0] == s)) {
			return true;
		}
		if ((arr[0][1] == s) && (arr[1][1] == s) && (arr[2][1] == s)) {
			return true;
		}
		if ((arr[0][2] == s) && (arr[1][2] == s) && (arr[2][2] == s)) {
			return true;
		}
		if ((arr[0][0] == s) && (arr[1][1] == s) && (arr[2][2] == s)) {
			return true;
		}
		if ((arr[2][0] == s) && (arr[1][1] == s) && (arr[0][2] == s)) {
			return true;
		}
		return false;

	}

	public char getPlayer1Sign() {
		return p1.getSign();

	}

	public char getPlayer2Sign() {
		return p2.getSign();

	}

	public void changeTurn() {
		switch (turn) {
		case 1:
			turn = 2;
			break;
		case 2:
			turn = 1;
			break;
		}
	}

	public void setTurn(int i) {
		turn = i;
	}

	public int getTurn() {
		return turn;
	}

	public void setPlayers(char ch) {
		switch (ch) {
		case 'o':
			p1 = new player('o');
			p2 = new player('x');
			turn = 1;
			break;
		case 'x':
			p1 = new player('x');
			p2 = new player('o');
			turn = 2;
			break;
		}
	}

	//THis is confusing change it is marked yes =false
	public boolean isMarked(int i, int j) {
		if (Character.isLetter(arr[i][j])) {
			return true;
		} else {
			return false;
		}
	}

	public char getSquareValue(int i, int j) {
		return arr[i][j];
	}
	
	public char[][] getBoard() {
		char c[][] = new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				c[i][j]=arr[i][j];
			}
		
		}
		return c;
	}
	//Figure out how to recongize draws
	public boolean isDraw() {
		int count = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(Character.isLetter(arr[i][j])) {
					count++;
				}
			}
		
		}
		if(count==9) {
			return true;
		}
		return false;
	}
	
}
