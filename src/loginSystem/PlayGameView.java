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

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.5 (current version number of program)
 * @since 2014-11-27 (the version of the package this class was first added to)
 */
public class PlayGameView {
	 
    /**
	 * This creates the PlayMenu Frame and panel                     (1)
	 * <p>
	 * The PlayMenu has four buttons. One plays the game, one loads a game, 
	 * one displays the highscores, one logs the player out.
	 * <p>
	 * 
	 */
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
		//These have to be after the panel add, so that the frame and panel display propely.
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(480, 440);
		f.setLocationRelativeTo(null);
		f.setResizable(false);

	}

	/**
	 * This is the main method for the PlayGameView (1)
	 * <p>
	 * It uses SwingUtilites to opend the PlayGameMenu method. This ensures that
	 * the Frame and Panel will load properly This also goes from static to non
	 * static, allowing non static varibles to be used in other classes.
	 * <p>
	 */
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
