package menuView.panels;

import highscore.HighScoreManager;
import highscore.Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import menuView.PanelTransitionManager;

/**
 * This class displays the high score of the players using the HighScoreManager
 * and the HighScoreDatabase
 * 
 * @author Yahya Azami <yahya.azami@mail.mcgill.ca>
 * @since 2014-11-30
 *
 */
public class HighScorePanel extends JPanel{

    JFrame f;
	
    HighScoreManager highScoreManager = new HighScoreManager();

    private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public HighScorePanel() {
		initUI();
	}
	
	private void initUI() {
	    
	Players listOfPlayers = highScoreManager.showTopTen();

	f = new JFrame("Bomberman - High Score");
	f.setLayout(new FlowLayout());
	f.setSize(496, 448);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("highScoreLabel");
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		label.setBorder(border);
		label.setPreferredSize(new Dimension(475, 25));

		label.setText("HIGH SCORE: ");
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.TOP);
		

		//String playerOne = listOfPlayers.getPlayerNames().get(0);
		
	String playerOne;
	String playerTwo;
	String playerThree;
	String playerFour;
	String playerFive;
	String playerSix;
	String playerSeven;
	String playerEight;
	String playerNine;
	String playerTen;

	int numberOfUsernames = listOfPlayers.getPlayerNames().size();

	if (numberOfUsernames == 0) {
	    playerOne = "";
	    playerTwo = "";
	    playerThree = "";
	    playerFour = "";
	    playerFive = "";
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";
	}

	else if (numberOfUsernames == 1) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = "";
	    playerThree = "";
	    playerFour = "";
	    playerFive = "";
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";
	}

	else if (numberOfUsernames == 2) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = "";
	    playerFour = "";
	    playerFive = "";
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 3) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = "";
	    playerFive = "";
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 4) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = "";
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 5) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = "";
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 6) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = listOfPlayers.getPlayerNames().get(5);
	    playerSeven = "";
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 7) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = listOfPlayers.getPlayerNames().get(5);
	    playerSeven = listOfPlayers.getPlayerNames().get(6);
	    playerEight = "";
	    playerNine = "";
	    playerTen = "";

	} else if (numberOfUsernames == 8) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = listOfPlayers.getPlayerNames().get(5);
	    playerSeven = listOfPlayers.getPlayerNames().get(6);
	    playerEight = listOfPlayers.getPlayerNames().get(7);
	    playerNine = "";
	    playerTen = "";

	}

	else if (numberOfUsernames == 9) {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = listOfPlayers.getPlayerNames().get(5);
	    playerSeven = listOfPlayers.getPlayerNames().get(6);
	    playerEight = listOfPlayers.getPlayerNames().get(7);
	    playerNine = listOfPlayers.getPlayerNames().get(8);
	    playerTen = "";

	}

	else {
	    playerOne = listOfPlayers.getPlayerNames().get(0);
	    playerTwo = listOfPlayers.getPlayerNames().get(1);
	    playerThree = listOfPlayers.getPlayerNames().get(2);
	    playerFour = listOfPlayers.getPlayerNames().get(3);
	    playerFive = listOfPlayers.getPlayerNames().get(4);
	    playerSix = listOfPlayers.getPlayerNames().get(5);
	    playerSeven = listOfPlayers.getPlayerNames().get(6);
	    playerEight = listOfPlayers.getPlayerNames().get(7);
	    playerNine = listOfPlayers.getPlayerNames().get(8);
	    playerTen = listOfPlayers.getPlayerNames().get(9);
	    ;

	}

	int numberOfScores = listOfPlayers.getScores().size();

	String scoreOne;
	String scoreTwo;
	String scoreThree;
	String scoreFour;
	String scoreFive;
	String scoreSix;
	String scoreSeven;
	String scoreEight;
	String scoreNine;
	String scoreTen;

	if (numberOfScores == 0) {
	    scoreOne = "";
	    scoreTwo = "";
	    scoreThree = "";
	    scoreFour = "";
	    scoreFive = "";
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 1) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = "";
	    scoreThree = "";
	    scoreFour = "";
	    scoreFive = "";
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 2) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = "";
	    scoreFour = "";
	    scoreFive = "";
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 3) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = "";
	    scoreFive = "";
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 4) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = "";
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 5) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = "";
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 6) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = "";
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 7) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = listOfPlayers.getScores().get(6).toString();
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 7) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = listOfPlayers.getScores().get(6).toString();
	    scoreEight = "";
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 8) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = listOfPlayers.getScores().get(6).toString();
	    scoreEight = listOfPlayers.getScores().get(7).toString();
	    scoreNine = "";
	    scoreTen = "";
	}

	if (numberOfScores == 9) {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = listOfPlayers.getScores().get(6).toString();
	    scoreEight = listOfPlayers.getScores().get(7).toString();
	    scoreNine = listOfPlayers.getScores().get(8).toString();
	    scoreTen = "";
	}

	else {
	    scoreOne = listOfPlayers.getScores().get(0).toString();
	    scoreTwo = listOfPlayers.getScores().get(1).toString();
	    scoreThree = listOfPlayers.getScores().get(2).toString();
	    scoreFour = listOfPlayers.getScores().get(3).toString();
	    scoreFive = listOfPlayers.getScores().get(4).toString();
	    scoreSix = listOfPlayers.getScores().get(5).toString();
	    scoreSeven = listOfPlayers.getScores().get(6).toString();
	    scoreEight = listOfPlayers.getScores().get(7).toString();
	    scoreNine = listOfPlayers.getScores().get(8).toString();
	    scoreTen = listOfPlayers.getScores().get(9).toString();
	}

	String player1 = playerOne + ":     " + scoreOne;
	String player2 = playerTwo + ":     " + scoreTwo;
	String player3 = playerThree + ":     " + scoreThree;
	String player4 = playerFour + ":     " + scoreFour;
	String player5 = playerFive + ":     " + scoreFive;
	String player6 = playerSix + ":     " + scoreSix;
	String player7 = playerSeven + ":     " + scoreSeven;
	String player8 = playerEight + ":     " + scoreEight;
	String player9 = playerNine + ":     " + scoreNine;
	String player10 = playerTen + ":     " + scoreTen;
		
		// 10 Players --NOTE EACH SCORE HAS IT'S BORDER, IT'S TO CUSTOMIZE THE
		// COLORS LATER ON

		// Player 1 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreOne = new JLabel("highScoreLabelOne");
		Border borderOne = BorderFactory.createLineBorder(Color.RED);
		highScoreOne.setBorder(borderOne);
		highScoreOne.setPreferredSize(new Dimension(475, 25));

		highScoreOne.setText(player1);
		highScoreOne.setHorizontalAlignment(JLabel.LEFT);
		highScoreOne.setVerticalAlignment(JLabel.TOP);

		// Player 2 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreTwo = new JLabel("highScoreLabelTwo");
		Border borderTwo = BorderFactory.createLineBorder(Color.BLACK);
		highScoreTwo.setBorder(borderTwo);
		highScoreTwo.setPreferredSize(new Dimension(475, 25));

		highScoreTwo.setText(player3);
		highScoreTwo.setHorizontalAlignment(JLabel.LEFT);
		highScoreTwo.setVerticalAlignment(JLabel.TOP);

		// Player 3 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreThree = new JLabel("highScoreLabelThree");
		Border borderThree = BorderFactory.createLineBorder(Color.BLACK);
		highScoreThree.setBorder(borderThree);
		highScoreThree.setPreferredSize(new Dimension(475, 25));

		highScoreThree.setText(player3);
		highScoreThree.setHorizontalAlignment(JLabel.LEFT);
		highScoreThree.setVerticalAlignment(JLabel.TOP);

		// Player 4 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreFour = new JLabel("highScoreLabelFour");
		Border borderFour = BorderFactory.createLineBorder(Color.BLACK);
		highScoreFour.setBorder(borderFour);
		highScoreFour.setPreferredSize(new Dimension(475, 25));

		highScoreFour.setText(player4);
		highScoreFour.setHorizontalAlignment(JLabel.LEFT);
		highScoreFour.setVerticalAlignment(JLabel.TOP);

		// Player 5 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreFive = new JLabel("highScoreLabelFive");
		Border borderFive = BorderFactory.createLineBorder(Color.BLACK);
		highScoreFive.setBorder(borderFive);
		highScoreFive.setPreferredSize(new Dimension(475, 25));

		highScoreFive.setText(player5);
		highScoreFive.setHorizontalAlignment(JLabel.LEFT);
		highScoreFive.setVerticalAlignment(JLabel.TOP);

		// Player 6 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreSix = new JLabel("highScoreLabelSix");
		Border borderSix = BorderFactory.createLineBorder(Color.BLACK);
		highScoreSix.setBorder(borderSix);
		highScoreSix.setPreferredSize(new Dimension(475, 25));

		highScoreSix.setText(player6);
		highScoreSix.setHorizontalAlignment(JLabel.LEFT);
		highScoreSix.setVerticalAlignment(JLabel.TOP);

		// Player 7 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreSeven = new JLabel("highScoreLabelSeven");
		Border borderSeven = BorderFactory.createLineBorder(Color.BLACK);
		highScoreSeven.setBorder(borderSeven);
		highScoreSeven.setPreferredSize(new Dimension(475, 25));

		highScoreSeven.setText(player7);
		highScoreSeven.setHorizontalAlignment(JLabel.LEFT);
		highScoreSeven.setVerticalAlignment(JLabel.TOP);

		// Player 8 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreEight = new JLabel("highScoreLabelEight");
		Border borderEight = BorderFactory.createLineBorder(Color.BLACK);
		highScoreEight.setBorder(borderEight);
		highScoreEight.setPreferredSize(new Dimension(475, 25));

		highScoreEight.setText(player8);
		highScoreEight.setHorizontalAlignment(JLabel.LEFT);
		highScoreEight.setVerticalAlignment(JLabel.TOP);

		// Player 9 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreNine = new JLabel("highScoreLabelNine");
		Border borderNine = BorderFactory.createLineBorder(Color.BLACK);
		highScoreNine.setBorder(borderNine);
		highScoreNine.setPreferredSize(new Dimension(475, 25));

		highScoreNine.setText(player9);
		highScoreNine.setHorizontalAlignment(JLabel.LEFT);
		highScoreNine.setVerticalAlignment(JLabel.TOP);

		// Player 10 --REPLACE PLAYER NAME BY VARIABLE
		JLabel highScoreTen = new JLabel("highScoreLabelTen");
		Border borderTen = BorderFactory.createLineBorder(Color.BLACK);
		highScoreTen.setBorder(borderTen);
		highScoreTen.setPreferredSize(new Dimension(475, 25));

		highScoreTen.setText(player10);
		highScoreTen.setHorizontalAlignment(JLabel.LEFT);
		highScoreTen.setVerticalAlignment(JLabel.TOP);
		
		
		//CurrentHighScore goes here
		JLabel highScoreEleven = new JLabel("currentHighScore");
		Border borderEleven = BorderFactory.createLineBorder(Color.BLACK);
		highScoreEleven.setBorder(borderEleven);
		highScoreEleven.setPreferredSize(new Dimension(475, 25));

		highScoreEleven.setText("Current High Score: ");
		highScoreEleven.setHorizontalAlignment(JLabel.LEFT);
		highScoreEleven.setVerticalAlignment(JLabel.TOP);
		

		// The button will make the player go back the game/main menu depending
		// on where he was
		// beforehand
		JButton goBack = new JButton("Back");
		goBack.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		f.dispose();
		// notYet();

		// Won't work if called from the pause menu.
		// PanelTransitionManager manager =
		// PanelTransitionManager.getInstance();

		if (manager.getInstance() != null) {

		    manager.displayPlayGameMenu();
		    /*
		     * PlayGameView playGameView = new PlayGameView();
		     * playGameView.playMenu();
		     */
		}

		    }
		});
		// The following will be used to execute any commands related to the
		// button
		// goBack.addActionListener(this.actionPerformed(arg0););

	f.add(label);
	f.add(goBack);
	f.add(highScoreOne);
	f.add(highScoreTwo);
	f.add(highScoreThree);
	f.add(highScoreFour);
	f.add(highScoreFive);
	f.add(highScoreSix);
	f.add(highScoreSeven);
	f.add(highScoreEight);
	f.add(highScoreNine);
	f.add(highScoreTen);
	f.add(highScoreEleven);

	f.setVisible(true);

	    }

	
}
