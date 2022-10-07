import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;

public class gameGUI extends JFrame {
	private JLabel label;
	private CardLayout cl;
	private MainMenuPanel mainMenuPanel;
	private ticTacToePanel panel;
	private JPanel messagePanel;
	private JPanel cardPanel;
	/**
	 * Create the frame.
	 */
	public gameGUI() {
		initializeContentPane();
	}
	
	private void initializeContentPane() {
		setTitle("TicTacToe");
		setLayout(new BorderLayout());
		
		intializePanels();
		label= new JLabel("Player 1: Chose X or Y");
		messagePanel.add(label);
		addPanels();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	private void intializePanels() {
		messagePanel=new JPanel();
		mainMenuPanel= new MainMenuPanel();
		cardPanel=new JPanel();
		cl = new CardLayout(50, 50);
		cardPanel.setLayout(cl);
		panel = new ticTacToePanel();
	}
	private void addPanels() {
		cardPanel.add(mainMenuPanel, "1");
		cardPanel.add(panel, "2");
		add(cardPanel,BorderLayout.CENTER);
		add(messagePanel,BorderLayout.NORTH);
	}

	public void initializeGame(char c,String mode) {
		panel.initializeGame(c, mode);
	}
	public void setLabel(String s) {
		label.setText(s);
	}
	
	public void changePanel(String s) {
		cl.show(cardPanel, s);
	}

	public void setVgap(int i) {
		cl.setVgap(i);
	}

	public void setHgap(int i) {
		cl.setHgap(i);
	}
	

}

