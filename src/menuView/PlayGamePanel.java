package menuView;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayGamePanel extends JPanel{
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();

	public PlayGamePanel() {
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
				manager.displayLevels();
			}
		});
		
		saveLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displaySaveLoad();
			}
		});

		highScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayHighscoreMenu();
			}
		});
		
		editAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayModifyAccount();
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayLoginMenu();
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
