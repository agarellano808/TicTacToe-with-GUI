import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MainMenuPanel extends JPanel {
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton2;
	private gameGUI frame;
	private AncestorListener ancestorListener;
	private JPanel panel;
	
	public MainMenuPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		addComponents();
		addActionListeners();
		setAncestorListener();
	}
	public void addComponents() {
		add(panel);
		btnNewButton = new JButton("x");
		btnNewButton.setAlignmentX(CENTER_ALIGNMENT);

		btnNewButton_1 = new JButton("o");
		btnNewButton_1.setAlignmentX(CENTER_ALIGNMENT);
		radioButton=new JRadioButton("Computer");
		radioButton.setAlignmentX(CENTER_ALIGNMENT);
		radioButton.setSelected(true);
		radioButton2=new JRadioButton("Human");
		radioButton2.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(Box.createRigidArea(new Dimension(10,0)));
		panel.add(btnNewButton);
		panel.add(Box.createRigidArea(new Dimension(10,0)));
		panel.add(btnNewButton_1);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(radioButton);
		add(radioButton2);
	}
	
	public void addActionListeners() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					frame.initializeGame('x',"COM");
				}
				else {
					frame.initializeGame('x',"HUM");
				}
				frame.changePanel("2");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					frame.initializeGame('o',"COM");
				}
				else {
					frame.initializeGame('o',"HUM");
				}
				frame.changePanel("2");
			}
		});
		
		radioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				radioButton2.setSelected(false);
			}
		
	});
		radioButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
			}
		
	});
	}
	
	private void setAncestor() {
		frame = (gameGUI) SwingUtilities.getWindowAncestor(this);

	}
	
	private void setAncestorListener() {
		ancestorListener = new AncestorListener() {

			@Override

			public void ancestorAdded(AncestorEvent ancestorEvent) {
				setAncestor();
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

}
