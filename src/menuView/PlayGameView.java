package menuView;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loginSystem.LoginMenuView;

public class PlayGameView extends JPanel{

	public PlayGameView() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		JButton playGameButton = new JButton("Play Game");
		JButton saveLoadButton = new JButton("Enter Save Load Game Menu");
		JButton highScoreButton = new JButton("View Highscores");
		JButton editAccountButton = new JButton("Edit Account");
		JButton logoutButton = new JButton("Logout");

		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});
		
		saveLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});

		highScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});
		
		editAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
				MenuDisplay md = new MenuDisplay();
				md.goTo("loginMenu");
			}
		});
		
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(playGameButton);
		add(saveLoadButton);
		add(highScoreButton);
		add(editAccountButton);
		add(logoutButton);
	}
}
