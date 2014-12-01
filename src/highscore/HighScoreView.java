package highscore;

import gameplay.overlays.pauseMenu.PanelManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.PlayGameView;
import userProfile.UserProfile;

public class HighScoreView extends JFrame implements ActionListener {

    JFrame f;
    
    //For testing
    public static void main(String[]args){
	
	//This is going to be the way to call it after. 
	//UserProfile user = UserProfile.getInstance();
	
	/*
	CSVreader reader = new CSVreader();
	AccountManager accountManager = new AccountManager();
	try {
		accountManager.setAccounts(reader.CSVreaderAccounts());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	List<Account> accounts = accountManager.getAccounts();
	
	int size = accounts.size();
	
	*/
	
	
	//HighScoreView hs = new HighScoreView(1);
	//Players testp = hs.showTopTen();
	
	//System.out.println(testp.getPlayerNames().toString());
	
	
	
	
    }
    /*
    
    //For testing
    public HighScoreView(int integ){
	
    }
   
    //For testing
    private List<String> getListOfUsernames(int size, List<Account> accounts){
	
	String userName = "";
	int sizeOfList = size;
	
	//add to this and return it
	List<String> userNameList = new LinkedList<String>();
	
	
	//get usernames from this
	List<Account> listOfAccountsToIterateOver = accounts;
	
	for(int i = 0; i < sizeOfList; i++){
	    Account acc = listOfAccountsToIterateOver.get(i);
	    userName = acc.getUserName();
	    userNameList.add(userName);
	}
	
	return userNameList;
    }
    
    
    //For testing
    private List<Integer> getListOfScores(int size, List<Account> accounts){
	
	int totalScore = 0;
	int sizeOfList = size;
	
	//add to this and return it
	List<Integer> totalScoresList = new LinkedList<Integer>();
	
	//get usernames from this
	List<Account> listOfAccountsToIterateOver = accounts;
	
	for(int i = 0; i < sizeOfList; i++){
	    Account acc = listOfAccountsToIterateOver.get(i);
	    totalScore = acc.getTotalScore();
	    totalScoresList.add(totalScore);
	    
	}
	
	return totalScoresList;
    }
 
    //For testing
    public Players showTopTen() {
	
	
	CSVreader reader = new CSVreader();
	AccountManager accountManager = new AccountManager();
	try {
		accountManager.setAccounts(reader.CSVreaderAccounts());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	List<Account> accounts = accountManager.getAccounts();
	
	int size = accounts.size();
	
	List<String> names = getListOfUsernames(size, accounts);
	List<Integer> scores = getListOfScores(size, accounts);
	
	
	Players newPlayer = new Players(names, scores);
	
	HighScoreDatabase database = new HighScoreDatabase(newPlayer);

	Players temp = database.sortByScore();

	database.sortedForm(temp);	
	//The lists are sorted now, gotta get the top 10 users/scores now
	
	//build a player with sorted lists
	Players temp2 = database.getListOfPlayers();

	//Extract the top ten players and store them in a Players object
	Players finalplayer = database.topTen(temp2);
	
	
	//the view will extract both the name and the score. it will return something else
	//if the result from it is null.

	return finalplayer;

    }
    
    */
    
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
	String player1 = "Demo01        16,000";
	String player2 = "Demo02        16,000";
	String player3 = "Demo03        16,000";
	String player4 = "Demo04        14,000";
	String player5 = "Demo05        13,000";
	String player6 = "Demo06        12,000";
	String player7 = "Demo07        11,000";
	String player8 = "Demo08        10,000";
	String player9 = "Demo09        10,000";
	String player10 = "Demo10        9,000";


	// 10 Players --NOTE EACH SCORE HAS IT'S BORDER, IT'S TO CUSTOMIZE THE
	// COLORS LATER ON

	// Player 1 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreOne = new JLabel("highScoreLabelOne");
	Border borderOne = BorderFactory.createLineBorder(Color.RED);
	highScoreOne.setBorder(borderOne);
	highScoreOne.setPreferredSize(new Dimension(950, 25));

	highScoreOne.setText(player1);
	highScoreOne.setHorizontalAlignment(JLabel.LEFT);
	highScoreOne.setVerticalAlignment(JLabel.TOP);

	// Player 2 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreTwo = new JLabel("highScoreLabelTwo");
	Border borderTwo = BorderFactory.createLineBorder(Color.BLACK);
	highScoreTwo.setBorder(borderTwo);
	highScoreTwo.setPreferredSize(new Dimension(950, 25));

	highScoreTwo.setText(player3);
	highScoreTwo.setHorizontalAlignment(JLabel.LEFT);
	highScoreTwo.setVerticalAlignment(JLabel.TOP);

	// Player 3 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreThree = new JLabel("highScoreLabelThree");
	Border borderThree = BorderFactory.createLineBorder(Color.BLACK);
	highScoreThree.setBorder(borderThree);
	highScoreThree.setPreferredSize(new Dimension(950, 25));

	highScoreThree.setText(player3);
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

	highScoreFive.setText(player5);
	highScoreFive.setHorizontalAlignment(JLabel.LEFT);
	highScoreFive.setVerticalAlignment(JLabel.TOP);

	// Player 6 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreSix = new JLabel("highScoreLabelSix");
	Border borderSix = BorderFactory.createLineBorder(Color.BLACK);
	highScoreSix.setBorder(borderSix);
	highScoreSix.setPreferredSize(new Dimension(950, 25));

	highScoreSix.setText(player6);
	highScoreSix.setHorizontalAlignment(JLabel.LEFT);
	highScoreSix.setVerticalAlignment(JLabel.TOP);

	// Player 7 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreSeven = new JLabel("highScoreLabelSeven");
	Border borderSeven = BorderFactory.createLineBorder(Color.BLACK);
	highScoreSeven.setBorder(borderSeven);
	highScoreSeven.setPreferredSize(new Dimension(950, 25));

	highScoreSeven.setText(player7);
	highScoreSeven.setHorizontalAlignment(JLabel.LEFT);
	highScoreSeven.setVerticalAlignment(JLabel.TOP);

	// Player 8 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreEight = new JLabel("highScoreLabelEight");
	Border borderEight = BorderFactory.createLineBorder(Color.BLACK);
	highScoreEight.setBorder(borderEight);
	highScoreEight.setPreferredSize(new Dimension(950, 25));

	highScoreEight.setText(player8);
	highScoreEight.setHorizontalAlignment(JLabel.LEFT);
	highScoreEight.setVerticalAlignment(JLabel.TOP);

	// Player 9 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreNine = new JLabel("highScoreLabelNine");
	Border borderNine = BorderFactory.createLineBorder(Color.BLACK);
	highScoreNine.setBorder(borderNine);
	highScoreNine.setPreferredSize(new Dimension(950, 25));

	highScoreNine.setText(player9);
	highScoreNine.setHorizontalAlignment(JLabel.LEFT);
	highScoreNine.setVerticalAlignment(JLabel.TOP);

	// Player 10 --REPLACE PLAYER NAME BY VARIABLE
	JLabel highScoreTen = new JLabel("highScoreLabelTen");
	Border borderTen = BorderFactory.createLineBorder(Color.BLACK);
	highScoreTen.setBorder(borderTen);
	highScoreTen.setPreferredSize(new Dimension(950, 25));

	highScoreTen.setText(player10);
	highScoreTen.setHorizontalAlignment(JLabel.LEFT);
	highScoreTen.setVerticalAlignment(JLabel.TOP);
	
	
	//CurrentHighScore goes here
	JLabel highScoreEleven = new JLabel("currentHighScore");
	Border borderEleven = BorderFactory.createLineBorder(Color.BLACK);
	highScoreEleven.setBorder(borderEleven);
	highScoreEleven.setPreferredSize(new Dimension(950, 25));

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
	f.add(highScoreEleven);

	f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

    }

}
