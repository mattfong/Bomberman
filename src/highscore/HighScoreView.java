package highscore;

import gameplay.pauseMenu.PanelManager;
import gameplay.statemanagers.GameStateManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import loginSystem.PlayGameView;

public class HighScoreView extends JFrame implements ActionListener {

    JFrame f;

    public HighScoreView() {

	// High Score Label

	f = new JFrame("Bomberman - High Score");
	f.setLayout(new FlowLayout());
	f.setSize(992, 448);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JLabel label = new JLabel("highScoreLabel");
	Border border = BorderFactory.createLineBorder(Color.BLUE);
	label.setBorder(border);
	label.setPreferredSize(new Dimension(950, 25));

	label.setText("HIGH SCORE: ");
	label.setHorizontalAlignment(JLabel.LEFT);
	label.setVerticalAlignment(JLabel.TOP);

	// ;)
	String player5 = "Demo05        16,000";
	String player6 = "Demo06        16,000";
	String player7 = "Demo07        16,000";
	String player4 = "Demo04        14,000";
	String player3 = "Demo03        13,000";
	String player10 = "Demo10        12,000";
	String player9 = "Demo09        11,000";
	String player1 = "Demo01        10,000";
	String player2 = "Demo02        10,000";
	String player8 = "Demo08        9,000";

	String rogue = "Demo11        ";
	GameStateManager gameStateManager = GameStateManager.getInstance();
	Integer rogueScore = gameStateManager.getScore();
	String s = NumberFormat.getNumberInstance(Locale.US).format(rogueScore);
	// System.out.println(NumberFormat.getNumberInstance(Locale.US).format(rogueScore));

	if (rogueScore > 16000) {
	    player5 = "Demo11        " + s;
	    player6 = "Demo05        16,000";
	    player7 = "Demo06        16,000";
	    player4 = "Demo07        16,000";
	    player3 = "Demo04        14,000";
	    player10 = "Demo03        13,000";
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 16000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo11        " + s;
	    player3 = "Demo04        14,000";
	    player10 = "Demo03        13,000";
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if ((rogueScore < 16000) && (rogueScore > 14000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo11        " + s;
	    player3 = "Demo04        14,000";
	    player10 = "Demo03        13,000";
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 14000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo11        " + s;
	    player10 = "Demo03        13,000";
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if ((rogueScore < 14000) && (rogueScore > 13000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo11        " + s;
	    player10 = "Demo03        13,000";
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 13000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo11        " + s;
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if ((rogueScore < 13000) && (rogueScore > 12000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo11        " + s;
	    player9 = "Demo10        12,000";
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 12000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo11        " + s;
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if ((rogueScore < 12000) && (rogueScore > 11000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo11        " + s;
	    player1 = "Demo09        11,000";
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 11000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo11        " + s;
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if ((rogueScore < 11000) && (rogueScore > 10000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo11        " + s;
	    player2 = "Demo01        10,000";
	    player8 = "Demo02        10,000";
	}

	if (rogueScore == 10000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo01        10,000";
	    player2 = "Demo02        10,000";
	    player8 = "Demo11        " + s;
	}

	if ((rogueScore < 10000) && (rogueScore > 9000)) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo01        10,000";
	    player2 = "Demo02        10,000";
	    player8 = "Demo11        " + s;
	}

	if (rogueScore == 9000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo01        10,000";
	    player2 = "Demo02        10,000";
	    player8 = "Demo08        9,000";
	}

	if (rogueScore < 9000) {
	    player5 = "Demo05        16,000";
	    player6 = "Demo06        16,000";
	    player7 = "Demo07        16,000";
	    player4 = "Demo04        14,000";
	    player3 = "Demo03        13,000";
	    player10 = "Demo10        12,000";
	    player9 = "Demo09        11,000";
	    player1 = "Demo01        10,000";
	    player2 = "Demo02        10,000";
	    player8 = "Demo08        9,000";
	}

	// 10 Players --NOTE EACH SCORE HAS IT'S BORDER, IT'S TO CUSTOMIZE THE
	// COLORS LATER ON

	// Player 1 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreOne = new JLabel("highScoreLabelOne");
	Border borderOne = BorderFactory.createLineBorder(Color.RED);
	highScoreOne.setBorder(borderOne);
	highScoreOne.setPreferredSize(new Dimension(950, 25));

	highScoreOne.setText(player5);
	highScoreOne.setHorizontalAlignment(JLabel.LEFT);
	highScoreOne.setVerticalAlignment(JLabel.TOP);

	// Player 2 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreTwo = new JLabel("highScoreLabelTwo");
	Border borderTwo = BorderFactory.createLineBorder(Color.BLACK);
	highScoreTwo.setBorder(borderTwo);
	highScoreTwo.setPreferredSize(new Dimension(950, 25));

	highScoreTwo.setText(player6);
	highScoreTwo.setHorizontalAlignment(JLabel.LEFT);
	highScoreTwo.setVerticalAlignment(JLabel.TOP);

	// Player 3 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreThree = new JLabel("highScoreLabelThree");
	Border borderThree = BorderFactory.createLineBorder(Color.BLACK);
	highScoreThree.setBorder(borderThree);
	highScoreThree.setPreferredSize(new Dimension(950, 25));

	highScoreThree.setText(player7);
	highScoreThree.setHorizontalAlignment(JLabel.LEFT);
	highScoreThree.setVerticalAlignment(JLabel.TOP);

	// Player 4 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreFour = new JLabel("highScoreLabelFour");
	Border borderFour = BorderFactory.createLineBorder(Color.BLACK);
	highScoreFour.setBorder(borderFour);
	highScoreFour.setPreferredSize(new Dimension(950, 25));

	highScoreFour.setText(player4);
	highScoreFour.setHorizontalAlignment(JLabel.LEFT);
	highScoreFour.setVerticalAlignment(JLabel.TOP);

	// Player 5 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreFive = new JLabel("highScoreLabelFive");
	Border borderFive = BorderFactory.createLineBorder(Color.BLACK);
	highScoreFive.setBorder(borderFive);
	highScoreFive.setPreferredSize(new Dimension(950, 25));

	highScoreFive.setText(player3);
	highScoreFive.setHorizontalAlignment(JLabel.LEFT);
	highScoreFive.setVerticalAlignment(JLabel.TOP);

	// Player 6 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreSix = new JLabel("highScoreLabelSix");
	Border borderSix = BorderFactory.createLineBorder(Color.BLACK);
	highScoreSix.setBorder(borderSix);
	highScoreSix.setPreferredSize(new Dimension(950, 25));

	highScoreSix.setText(player10);
	highScoreSix.setHorizontalAlignment(JLabel.LEFT);
	highScoreSix.setVerticalAlignment(JLabel.TOP);

	// Player 7 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreSeven = new JLabel("highScoreLabelSeven");
	Border borderSeven = BorderFactory.createLineBorder(Color.BLACK);
	highScoreSeven.setBorder(borderSeven);
	highScoreSeven.setPreferredSize(new Dimension(950, 25));

	highScoreSeven.setText(player9);
	highScoreSeven.setHorizontalAlignment(JLabel.LEFT);
	highScoreSeven.setVerticalAlignment(JLabel.TOP);

	// Player 8 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreEight = new JLabel("highScoreLabelEight");
	Border borderEight = BorderFactory.createLineBorder(Color.BLACK);
	highScoreEight.setBorder(borderEight);
	highScoreEight.setPreferredSize(new Dimension(950, 25));

	highScoreEight.setText(player1);
	highScoreEight.setHorizontalAlignment(JLabel.LEFT);
	highScoreEight.setVerticalAlignment(JLabel.TOP);

	// Player 9 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreNine = new JLabel("highScoreLabelNine");
	Border borderNine = BorderFactory.createLineBorder(Color.BLACK);
	highScoreNine.setBorder(borderNine);
	highScoreNine.setPreferredSize(new Dimension(950, 25));

	highScoreNine.setText(player2);
	highScoreNine.setHorizontalAlignment(JLabel.LEFT);
	highScoreNine.setVerticalAlignment(JLabel.TOP);

	// Player 10 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreTen = new JLabel("highScoreLabelTen");
	Border borderTen = BorderFactory.createLineBorder(Color.BLACK);
	highScoreTen.setBorder(borderTen);
	highScoreTen.setPreferredSize(new Dimension(950, 25));

	highScoreTen.setText(player8);
	highScoreTen.setHorizontalAlignment(JLabel.LEFT);
	highScoreTen.setVerticalAlignment(JLabel.TOP);

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
		PanelManager manager = PanelManager.getInstance();

		if (manager.getParentPanel() == null) {
		    PlayGameView playGameView = new PlayGameView();
		    playGameView.playMenu();
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

	f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

    }

}
