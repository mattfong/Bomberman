package highscore;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JButton;

import loginSystem.PlayGame;

public class HighScoreView extends JFrame implements ActionListener{

	JFrame f;


	public HighScoreView (){


		//High Score Label
		
		f = new JFrame("Bomberman - High Score");
	    f.setLayout(new FlowLayout());
	    f.setSize(992, 448);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel label= new JLabel("highScoreLabel");
	    Border border = BorderFactory.createLineBorder(Color.BLACK);
	    label.setBorder(border);
	    label.setPreferredSize(new Dimension(950, 25));
	    
	    label.setText("HIGH SCORE: ");
	    label.setHorizontalAlignment(JLabel.LEFT);
	    label.setVerticalAlignment(JLabel.TOP);



	    //10 Players --NOTE EACH SCORE HAS IT'S BORDER, IT'S TO CUSTOMIZE THE COLORS LATER ON


	     //Player 1 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreOne= new JLabel("highScoreLabelOne");
	    Border borderOne = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreOne.setBorder(borderOne);
	    highScoreOne.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreOne.setText("Player1 Name");
	    highScoreOne.setHorizontalAlignment(JLabel.LEFT);
	    highScoreOne.setVerticalAlignment(JLabel.TOP);
	    
	    
	    //Player 2 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreTwo= new JLabel("highScoreLabelTwo");
	    Border borderTwo = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreTwo.setBorder(borderTwo);
	    highScoreTwo.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreTwo.setText("Player2 Name");
	    highScoreTwo.setHorizontalAlignment(JLabel.LEFT);
	    highScoreTwo.setVerticalAlignment(JLabel.TOP);
	    
	    
	    //Player 3 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreThree= new JLabel("highScoreLabelThree");
	    Border borderThree = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreThree.setBorder(borderThree);
	    highScoreThree.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreThree.setText("Player3 Name");
	    highScoreThree.setHorizontalAlignment(JLabel.LEFT);
	    highScoreThree.setVerticalAlignment(JLabel.TOP);
	    
	    
	    //Player 4 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreFour= new JLabel("highScoreLabelFour");
	    Border borderFour = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreFour.setBorder(borderFour);
	    highScoreFour.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreFour.setText("Player4 Name");
	    highScoreFour.setHorizontalAlignment(JLabel.LEFT);
	    highScoreFour.setVerticalAlignment(JLabel.TOP);
	    
	    
	    //Player 5 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreFive= new JLabel("highScoreLabelFive");
	    Border borderFive = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreFive.setBorder(borderTwo);
	    highScoreFive.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreFive.setText("Player5 Name");
	    highScoreFive.setHorizontalAlignment(JLabel.LEFT);
	    highScoreFive.setVerticalAlignment(JLabel.TOP);

	    
	    
	    //Player 6 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreSix= new JLabel("highScoreLabelSix");
	    Border borderSix = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreSix.setBorder(borderSix);
	    highScoreSix.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreSix.setText("Player6 Name");
	    highScoreSix.setHorizontalAlignment(JLabel.LEFT);
	    highScoreSix.setVerticalAlignment(JLabel.TOP);
	    
	    //Player 7 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreSeven= new JLabel("highScoreLabelSeven");
	    Border borderSeven = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreSeven.setBorder(borderSeven);
	    highScoreSeven.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreSeven.setText("Player7 Name");
	    highScoreSeven.setHorizontalAlignment(JLabel.LEFT);
	    highScoreSeven.setVerticalAlignment(JLabel.TOP);
	    
	    //Player 8 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreEight= new JLabel("highScoreLabelEight");
	    Border borderEight = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreEight.setBorder(borderEight);
	    highScoreEight.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreEight.setText("Player8 Name");
	    highScoreEight.setHorizontalAlignment(JLabel.LEFT);
	    highScoreEight.setVerticalAlignment(JLabel.TOP);
	    
	    //Player 9 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreNine= new JLabel("highScoreLabelNine");
	    Border borderNine = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreNine.setBorder(borderNine);
	    highScoreNine.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreNine.setText("Player9 Name");
	    highScoreNine.setHorizontalAlignment(JLabel.LEFT);
	    highScoreNine.setVerticalAlignment(JLabel.TOP);
	    
	    //Player 10 --REPLACE PLAYER NAME BY VARIABLE
	    JLabel highScoreTen= new JLabel("highScoreLabelTen");
	    Border borderTen = BorderFactory.createLineBorder(Color.BLACK);
	    highScoreTen.setBorder(borderTen);
	    highScoreTen.setPreferredSize(new Dimension(950, 25));
	    
	    highScoreTen.setText("Player10 Name");
	    highScoreTen.setHorizontalAlignment(JLabel.LEFT);
	    highScoreTen.setVerticalAlignment(JLabel.TOP);


	    //The button will make the player go back the game/main menu depending on where he was 
	    //beforehand
	    JButton goBack = new JButton("Back");
	    goBack.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0) {
			f.dispose();
			//notYet();	
			PlayGame.playMenu();
	    }});
	    //The following will be used to execute any commands related to the button
	    //goBack.addActionListener(this.actionPerformed(arg0););	    



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
