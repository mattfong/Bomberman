package deprecated;

import highscore.HighScoreController;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import loginSystem.LevelSelectView;
import loginSystem.LoginMenuView;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.6 (current version number of program)
 * @since 2014-11-28 (the version of the package this class was first added to)
 */
public class PlayGameView {

    /**
     * This creates the PlayMenu Frame and panel (1)
     * <p>
     * The PlayMenu has four buttons. One plays the game, one loads a game, one
     * displays the highscores, one logs the player out.
     * <p>
     * 
     */
    public void playMenu() {

	String user = LoginMenuView.justUsername; /*
						   * this gets the username from
						   * the login menu
						   */
	/*
	 * This creates a JFrame and JPanel for the Login menu. It sets the
	 * panel to be a grid layout of 8 spots
	 */
	final JFrame f = new JFrame("Main Menu");
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(5, 1, 5, 10));
	/*
	 * This button startes the game.
	 */
	JButton play = new JButton("Play Game");
	play.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		System.out.println("New Game Frame");

		LevelSelectView view = new LevelSelectView();

		f.dispose();
	    }
	});
	/*
	 * This button opens the load game menu.
	 */
	JButton saved = new JButton("Load Saved game");
	saved.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		SaveLoadView saveLoadMenu = new SaveLoadView();
		saveLoadMenu.SaveLoadView();
		f.dispose();
	    }
	});
	/*
	 * This button opens the highscore menu.
	 */
	JButton high = new JButton("High Scores");
	high.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		HighScoreController.displayHighScore();
		f.dispose();
	    }
	});
	/*
	 * This button opens the modify account menu.
	 */
	JButton editAccount = new JButton("Modify Account");
	editAccount.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		EditAccountView.main(null);
		f.dispose();
	    }
	});
	/*
	 * This button logs the user out, taking them back to the loginMenu.
	 */
	JButton logOut = new JButton("Log Out");
	logOut.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		f.dispose();
		LoginMenuView.main(null);

	    }
	});
	/*
	 * These add the buttons to the panel. Their order deterimines the order
	 * that the objects display on the panel.
	 */
	panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	panel.add(play);
	panel.add(saved);
	panel.add(high);
	panel.add(editAccount);
	panel.add(logOut);
	f.add(panel);
	// These have to be after the panel add, so that the frame and panel
	// display propely.
	/*
	 * The next part is the frame conditions. They set the frame visable, to
	 * a certin size, etc.
	 */
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
	/*
	 * This is very important. It ensure that the frame and panel will
	 * display properly and avoid the "grey screen" glitch we have
	 * experienced. It makes sure that the frame and panel always load
	 * properly.
	 */
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		/*
		 * This allows a non static method to be called from a static
		 * method
		 */
		PlayGameView PMV = new PlayGameView();

		PMV.playMenu();
	    }
	});
    }
}
