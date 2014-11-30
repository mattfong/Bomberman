package gameplay.pauseMenu;

import gameplay.GamePanel;
import highscore.HighScoreView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import savingSystem.SaveLoadController;

/**
 * @author MF Class containing the JPanel of the pause menu.
 */
public class PauseMenuView extends JPanel {

    private GamePanel parentPanel;
    private SaveLoadController saveLoadController = new SaveLoadController();
    private PanelManager manager = PanelManager.getInstance();

    public PauseMenuView(GamePanel panel) {

	this.parentPanel = panel;
	initUI();
	setFocusable(true);
	requestFocus();

	manager.setParentPanel(panel);
    }

    private void initUI() {
	JLabel pauseMenuLabel = new JLabel("Pause Menu");
	pauseMenuLabel.setBounds(70, 30, 163, 40);
	pauseMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
	add(pauseMenuLabel);

	JButton saveGameButton = new JButton("Save Game");
	saveGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		saveLoadController.displaySaveGameMenu();
	    }
	});
	saveGameButton.setBounds(85, 180, 134, 25);
	add(saveGameButton);

	JButton returnToGameButton = new JButton("Return to game");
	returnToGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		parentPanel.closePauseMenu();
	    }
	});
	returnToGameButton.setBounds(85, 88, 134, 25);
	add(returnToGameButton);

	JButton highScoreButton = new JButton("View Highscore");
	highScoreButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		new HighScoreView();
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
		saveLoadController.displayLoadGameMenu();
	    }
	});
	loadGameButton.setBounds(85, 226, 134, 25);
	add(loadGameButton);

	setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	setLayout(null);

    }
}
