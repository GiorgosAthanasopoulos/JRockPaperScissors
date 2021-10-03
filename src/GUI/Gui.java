package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.*;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final String[] choices = new String[] {"Rock", "Paper", "Scissors"};
	private static Random random;

	private int scorePlayer;
	private int scorePC;
	
	private JLabel lblNewLabel;
	private JLabel lblScorePc;
	/**
	 * Create the frame.
	 */
	public Gui() {
		random = new Random();
		scorePlayer = 0;
		scorePC = 0;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		setTitle("RPS");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Rock");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String playerMove = "Rock";
				
				int randInt = random.nextInt(3);
				String pcMove = choices[randInt];
				
				showWinner(playerMove, pcMove);
			}
		});
		
		JButton btnPaper = new JButton("Paper");
		btnPaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String playerMove = "Paper";
				
				int randInt = random.nextInt(3);
				String pcMove = choices[randInt];
				
				showWinner(playerMove, pcMove);
			}
		});
		
		JButton btnScissors = new JButton("Scissors");
		btnScissors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String playerMove = "Scissors";
				
				int randInt = random.nextInt(3);
				String pcMove = choices[randInt];
				
				showWinner(playerMove, pcMove);
			}
		});
		
		lblNewLabel = new JLabel("Score Player: 0");
		lblNewLabel.setForeground(Color.GREEN);
		
		lblScorePc = new JLabel("Score PC: 0");
		lblScorePc.setForeground(Color.GREEN);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(62))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPaper, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(btnScissors, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblScorePc, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScorePc, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnScissors, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
							.addComponent(btnPaper, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	private void showWinner(String move1, String move2) {
		switch(move1) {
		case "Rock":
			switch(move2) {
			case "Rock":
				JOptionPane.showMessageDialog(null, "Player Move: Rock\nPC Move: Rock\nWinner: None");
				break;
			case "Paper":
				JOptionPane.showMessageDialog(null, "Player Move: Rock\nPC Move: Paper\nWinner: PC");
				scorePC++;
				break;
			case "Scissors":
				JOptionPane.showMessageDialog(null, "Player Move: Rock\nPC Move: Scissors\nWinner: Player");
				scorePlayer++;
				break;
			}
			break;
		case "Paper":
			switch(move2) {
			case "Rock":
				JOptionPane.showMessageDialog(null, "Player Move: Paper\nPC Move: Rock\nWinner: Player");
				scorePlayer++;
				break;
			case "Paper":
				JOptionPane.showMessageDialog(null, "Player Move: Paper\nPC Move: Paper\nWinner: None");
				break;
			case "Scissors":
				JOptionPane.showMessageDialog(null, "Player Move: Paper\nPC Move: Scissors\nWinner: PC");
				scorePC++;
				break;
			}
			break;
		case "Scissors":
			switch(move2) {
			case "Rock":
				JOptionPane.showMessageDialog(null, "Player Move: Scissors\nPC Move: Rock\nWinner: PC");
				scorePC++;
				break;
			case "Paper":
				JOptionPane.showMessageDialog(null, "Player Move: Scissors\nPC Move: Paper\nWinner: Player");
				scorePlayer++;
				break;
			case "Scissors":
				JOptionPane.showMessageDialog(null, "Player Move: Scissors\nPC Move: Scissors\nWinner: None");
				break;
			}
			break;
		}
		
		lblNewLabel.setText("Score Player: "+scorePlayer);
		lblScorePc.setText("Score PC: "+scorePC);
		repaint();
		
	}
}
