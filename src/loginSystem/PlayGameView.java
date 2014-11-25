package loginSystem;

import highscore.HighScoreController;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import savingSystem.SaveLoadView;

public class PlayGameView {

    public void playMenu() {
	String user = LoginMenuView.justUsername;

	final JFrame f = new JFrame("Main Menu");
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(4, 1, 5, 10));

	JButton play = new JButton("Play Game");
	play.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		System.out.println("New Game Frame");

		LevelSelectView view = new LevelSelectView();

		f.dispose();

	    }
	});

	JButton saved = new JButton("Load Saved game");
	saved.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		SaveLoadView saveLoadMenu = new SaveLoadView();
		saveLoadMenu.SaveLoadView();
		f.dispose();
	    }
	});

	JButton high = new JButton("High Scores");
	high.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		HighScoreController.displayHighScore();
		f.dispose();
	    }
	});

	JButton logOut = new JButton("Log Out");
	logOut.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		f.dispose();
		LoginMenuView.main(null);

	    }
	});

	panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	panel.add(play);
	panel.add(saved);
	panel.add(high);
	panel.add(logOut);
	f.add(panel);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(480, 440);
	f.setLocationRelativeTo(null);
	f.setResizable(false);

    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		PlayGameView PMV = new PlayGameView();

		PMV.playMenu();
	    }
	});
    }
}
