package menuView;

import gameplay.engine.GamePanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * Class containing the JPanel of the pause menu.
 * 
 * @author MF
 */
public class PauseMenuPanel extends JPanel {

    private PanelTransitionManager panelTransitionManager = PanelTransitionManager.getInstance();
    private GamePanel parentPanel;

    public PauseMenuPanel() {

	initUI();

    }

    private void initUI() {
	setFocusable(true);
	requestFocus();
	setVisible(true);
	JLabel pauseMenuLabel = new JLabel("Pause Menu");
	pauseMenuLabel.setBounds(70, 30, 163, 40);
	pauseMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
	add(pauseMenuLabel);

	JButton saveGameButton = new JButton("Save Game");
	saveGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		panelTransitionManager.displaySaveMenu();
	    }
	});
	saveGameButton.setBounds(85, 180, 134, 25);
	add(saveGameButton);

	JButton returnToGameButton = new JButton("Return to game");
	returnToGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		panelTransitionManager.displayResumedGame();
	    }
	});
	returnToGameButton.setBounds(85, 88, 134, 25);
	add(returnToGameButton);

	JButton highScoreButton = new JButton("View Highscore");
	highScoreButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		panelTransitionManager.displayHighscoreMenu();
		;
	    }
	});
	highScoreButton.setBounds(85, 134, 134, 25);
	add(highScoreButton);

	JButton exitButton = new JButton("Exit Game");
	exitButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	    }
	});
	exitButton.setBounds(85, 272, 134, 25);
	add(exitButton);

	JButton loadGameButton = new JButton("Load Game");
	loadGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		panelTransitionManager.displayLoadMenu();
	    }
	});
	loadGameButton.setBounds(85, 226, 134, 25);
	add(loadGameButton);

	setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	setLayout(null);

    }
}
