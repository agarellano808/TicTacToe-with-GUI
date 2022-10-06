
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
		
		 findBestMove(x,y,G);
		System.out.println("Chosen X: "+x+"Chosen y: "+y);
	    G.mark(getSign(),x,y);
	}
	
	public int minMax(game g,int depth,Boolean max) {
	
		if(g.check(g.getPlayer2Sign())) {
			System.out.println("max");
			return 10;
		}
		if(g.check(g.getPlayer1Sign())) {
			return -10;
		}
		if(g.isDraw()) {
			return 0;
		}
		if(max) {
			int score = -1000;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(!g.isMarked(i, j)) {
						g.mark(g.getPlayer2Sign(),i,j);
						score=Math.max(score,minMax(g,depth+1,false));
					}
				}
			}
			return score;
		}
		else {
			int score =1000;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(!g.isMarked(i, j)) {
						g.mark(g.getPlayer1Sign(),i,j);
						score=Math.min(score,minMax(g,depth+1,true));
					}
				}
			}
			return score;
		}
	
	}
	public int findBestMove(int x,int y, game g) {
		int score = -2;
		for (int i = x; i < 3; i++) {
			for (int j = y; j < 3; j++) {
				
				if (!g.isMarked(i, j)) {
					game TestGame=new game(g);
					TestGame.setPlayers(g.getPlayer1Sign());
					TestGame.mark(getSign(),i,j);
					System.out.println("i: "+i+"j: "+j);
					
					int scoreFromMove= minMax(TestGame,0,false);
					System.out.println("The Score "+scoreFromMove);
					if(scoreFromMove>score) {
						
						score=scoreFromMove;
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
