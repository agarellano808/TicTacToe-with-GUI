import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class gameGUI extends JFrame {

	private JPanel contentPane;
	private JPanel selectSignPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblChoseXPr;
	/**
	 * Create the frame.
	 */
	public gameGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		initializeContentPane();
		addComponents();
		addButtonActionListeners();

	}
	
	private void initializeContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void addComponents() {
		lblChoseXPr = new JLabel("Player 1: Chose X or Y");
		lblChoseXPr.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoseXPr.setBounds(154, 11, 139, 14);
		contentPane.add(lblChoseXPr);
		
		selectSignPanel = new JPanel();
		selectSignPanel.setBounds(100, 30, 240, 180);
		contentPane.add(selectSignPanel);
		selectSignPanel.setLayout(null);

		btnNewButton = new JButton("x");
		btnNewButton.setBounds(10, 75, 89, 23);
		selectSignPanel.add(btnNewButton);


		btnNewButton_1 = new JButton("o");
		btnNewButton_1.setBounds(141, 75, 89, 23);
		selectSignPanel.add(btnNewButton_1);
	}
	
	public void addButtonActionListeners() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(selectSignPanel);
				contentPane.revalidate();
				contentPane.repaint();
				addTicTacToePanel('x',lblChoseXPr);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(selectSignPanel);
				contentPane.revalidate();
				contentPane.repaint();
				addTicTacToePanel('o',lblChoseXPr);
			}
		});
	}
	
	public void addTicTacToePanel(char c,JLabel j) {
		ticTacToePanel panel = new ticTacToePanel(c,j);
		panel.setBounds(100, 30, 240, 180);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	}
}
