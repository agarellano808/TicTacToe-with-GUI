import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ticTacToePanel extends JPanel {

	private int x, y;

	private game ticTacToeGame;
	private AncestorListener ancestorListener;
	private cpuPlayer test;
	private gameGUI frame;
	private String mode;
	/**
	 * Create the panel.
	 */
	public ticTacToePanel() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAncestorListener();
		add(Box.createRigidArea(new Dimension(240, 175)));

	}

	public void addMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				System.out.println(ticTacToeGame.getTurn());
				// Comment this out when chanign to AI| remoce the swtich case and have the ai
				// play by using a function in cas2 by passing game as parameter
				// switch (ticTacToeGame.getTurn()) {
				// case 1:
				
				if(mode.equals("COM")) {
					mark(ticTacToeGame.getPlayer1Sign(), x, y);
					test.play();
					if (checkIfWon(ticTacToeGame.getPlayer1Sign()) || checkIfDraw()) {
						removeMouseListener(this);
					}
				}
				

				else {
					switch (ticTacToeGame.getTurn()) {
					case 1:
						mark(ticTacToeGame.getPlayer1Sign(), x, y);
						if (checkIfWon(ticTacToeGame.getPlayer1Sign()) || checkIfDraw()) {
							removeMouseListener(this);
						}
						break;
					case 2:
						mark(ticTacToeGame.getPlayer2Sign(), x, y);
						  if(checkIfWon(ticTacToeGame.getPlayer2Sign())||checkIfDraw() ) {
						       removeMouseListener(this); 
						       } 
						  break; 
				}}
				/*
				 * break; case 2: mark(ticTacToeGame.getPlayer2Sign(), x, y);
				 * if(checkIfWon(ticTacToeGame.getPlayer2Sign())||checkIfDraw() ) {
				 * removeMouseListener(this); } break; }
				 */
			}
		});
	}
	
	
	public void initializeAncestorListener() {
		frame = (gameGUI) SwingUtilities.getWindowAncestor(this);
	}

	public void initializeGame(char c, String mode) {
		ticTacToeGame = new game(c);
		this.mode=mode;
		if(mode.equals("COM")) {
			if(c=='o') {
			test = new cpuPlayer('x', ticTacToeGame);
			}
			if(c=='x') {
				
			test = new cpuPlayer('o', ticTacToeGame);
			}
		}
		if(mode.equals("HUM")){
			//test = new cpuPlayer('x', ticTacToeGame);
		}
		
		
	}

	private void setAncestorListener() {
		ancestorListener = new AncestorListener() {
			@Override
			public void ancestorAdded(AncestorEvent ancestorEvent) {
				addMouseListener();
				initializeAncestorListener();
				turnLabelChange();
		
			}

			@Override
			// This method is not being used and has been left intentionally blank
			public void ancestorMoved(AncestorEvent ancestorEvent) {
			}

			@Override
			// This method is not being used and has been left intentionally blank
			public void ancestorRemoved(AncestorEvent ancestorEvent) {
			}

		};
		addAncestorListener(ancestorListener);
	}

	// Change it so marked is resolved int he game class so that you can get rid of
	// double array here
	public void mark(char playerSign, int x, int y) {

		if (x < 80 && y < 60 && !ticTacToeGame.isMarked(0, 0)) {
			ticTacToeGame.mark(playerSign, 0, 0);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 80 && x < 160 && y < 60 && !ticTacToeGame.isMarked(1, 0)) {

			ticTacToeGame.mark(playerSign, 1, 0);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 160 && y < 60 && !ticTacToeGame.isMarked(2, 0)) {
			ticTacToeGame.mark(playerSign, 2, 0);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x < 80 && y > 60 && y < 120 && !ticTacToeGame.isMarked(0, 1)) {
			ticTacToeGame.mark(playerSign, 0, 1);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 80 && x < 160 && y > 60 && y < 120 && !ticTacToeGame.isMarked(1, 1)) {
			ticTacToeGame.mark(playerSign, 1, 1);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 160 && y > 60 && y < 120 && !ticTacToeGame.isMarked(2, 1)) {
			ticTacToeGame.mark(playerSign, 2, 1);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x < 80 && y > 120 && !ticTacToeGame.isMarked(0, 2)) {
			ticTacToeGame.mark(playerSign, 0, 2);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 80 && x < 160 && y > 120 && !ticTacToeGame.isMarked(1, 2)) {
			ticTacToeGame.mark(playerSign, 1, 2);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		} else if (x > 160 && y > 120 && !ticTacToeGame.isMarked(2, 2)) {
			ticTacToeGame.mark(playerSign, 2, 2);
			ticTacToeGame.changeTurn();
			turnLabelChange();

		}
		repaint();
	}

	public void paintComponent(Graphics G) {
		super.paintComponent(G);
		// Horizantal Lines
		G.drawLine(80, 0, 80, 190);
		G.drawLine(160, 0, 160, 190);

		// Vertical Lines
		G.drawLine(0, 60, 240, 60);
		G.drawLine(0, 120, 240, 120);

		// First Row
		if (ticTacToeGame.getSquareValue(0, 0) == 'x') {
			G.drawLine(15, 5, 65, 55);
			G.drawLine(15, 55, 65, 5);
		}
		if (ticTacToeGame.getSquareValue(1, 0) == 'x') {
			G.drawLine(95, 5, 145, 55);
			G.drawLine(95, 55, 145, 5);

		}
		if (ticTacToeGame.getSquareValue(2, 0) == 'x') {
			G.drawLine(175, 5, 225, 55);
			G.drawLine(175, 55, 225, 5);

		}
		// Second Row
		if (ticTacToeGame.getSquareValue(0, 1) == 'x') {
			G.drawLine(15, 65, 65, 115);
			G.drawLine(15, 115, 65, 65);

		}
		if (ticTacToeGame.getSquareValue(1, 1) == 'x') {
			G.drawLine(95, 65, 145, 115);
			G.drawLine(95, 115, 145, 65);

		}
		if (ticTacToeGame.getSquareValue(2, 1) == 'x') {
			G.drawLine(175, 65, 225, 115);
			G.drawLine(175, 115, 225, 65);

		}
		// Third Row
		if (ticTacToeGame.getSquareValue(0, 2) == 'x') {
			G.drawLine(15, 125, 65, 175);
			G.drawLine(15, 175, 65, 125);

		}

		if (ticTacToeGame.getSquareValue(1, 2) == 'x') {
			G.drawLine(95, 125, 145, 175);
			G.drawLine(95, 175, 145, 125);

		}
		if (ticTacToeGame.getSquareValue(2, 2) == 'x') {
			G.drawLine(175, 125, 225, 175);
			G.drawLine(175, 175, 225, 125);

		}

		// First Row
		if (ticTacToeGame.getSquareValue(0, 0) == 'o') {
			G.drawOval(15, 5, 50, 50);
		}
		if (ticTacToeGame.getSquareValue(1, 0) == 'o') {

			G.drawOval(95, 5, 50, 50);
		}
		if (ticTacToeGame.getSquareValue(2, 0) == 'o') {
			G.drawOval(175, 5, 50, 50);
		}
		// Second Row
		if (ticTacToeGame.getSquareValue(0, 1) == 'o') {
			G.drawOval(15, 65, 50, 50);
		}
		if (ticTacToeGame.getSquareValue(1, 1) == 'o') {
			G.drawOval(95, 65, 50, 50);
		}
		if (ticTacToeGame.getSquareValue(2, 1) == 'o') {
			G.drawOval(175, 65, 50, 50);
		}
		// Third Row
		if (ticTacToeGame.getSquareValue(0, 2) == 'o') {
			G.drawOval(15, 125, 50, 50);
		}

		if (ticTacToeGame.getSquareValue(1, 2) == 'o') {
			G.drawOval(95, 125, 50, 50);
		}
		if (ticTacToeGame.getSquareValue(2, 2) == 'o') {
			G.drawOval(175, 125, 50, 50);
		}
	}

	public void turnLabelChange() {
		if (ticTacToeGame.getTurn() == 1) {
			frame.setLabel("Its player one's turn");
		}
		if (ticTacToeGame.getTurn() == 2) {
			frame.setLabel("Its player two's turn");
		}
	}

	public boolean checkIfWon(char c) {
		if (ticTacToeGame.check(c)) {
			frame.setLabel("success");
			return true;
		}
		return false;
	}

	public boolean checkIfDraw() {
		if (ticTacToeGame.isDraw()) {
			frame.setLabel("DRAW");
			return true;
		}
		return false;
	}
}
