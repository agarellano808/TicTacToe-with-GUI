
public class cpuPlayer extends player {
	private game G;
	int x;
	int y;
	/*
	 * Send G as a paramerter uso cpu player can read the the 2D grid
	 */
	public cpuPlayer(char c, game G) {
		super(c);
		this.G = G;
	}
	public void play() {
		 x=0;
		 y=0;
		
		minMax(x,y,G);
		System.out.println("Chosen X: "+x+"Chosen y: "+y);
	    G.mark(getSign(),x,y);
	}
	
	public int minMax(int x,int y, game g) {
		int score = -2;
		for (int i = x; i < 3; i++) {
			for (int j = y; j < 3; j++) {
				
				if (!g.isMarked(i, j)) {
					game TestGame=new game(g);
				//	System.out.println("i: "+i+"j: "+j);
					TestGame.mark(getSign(),i,j);
					int scoreFormMove= -(minMax(i,j,TestGame));
				//	System.out.println("The Score "+scoreFormMove);
					if(scoreFormMove>score) {
						
						score=scoreFormMove;
						this.x=i;
						this.y=j;
						System.out.println("x: "+y+"y: "+y);
						
					}
				}
			}
		}
		if(x==-1||y==-1) {
			return 0;
		}
		//System.out.println("Score:" +score);
		return score;
	}

}
