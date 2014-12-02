package highscore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import loginSystem.Account;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import savingSystem.SavedGameManager;
import userProfile.UserProfile;

/**
 * The HighScoreManager class parses a list of Accounts given to it and uses the
 * methods in HighScoreDatabase to get to what is to be displayed on the the
 * HighScoreView.
 * 
 * @author Yahya Azami <yahya.azami@mail.mcgill.ca>
 * @since 2014-11-30
 */
public class HighScoreManager {

    // Constructor
    public HighScoreManager() {

    }

    // Getting the lists of accounts
    private List<Account> listOfAccounts() {

	List<Account> listOfAccounts = UserProfile.getInstance().getAccountManager().getAccounts();
	return listOfAccounts;
    }

    /**
     * This method gets the number of Accounts from the listOfAccounts method
     * above.
     * 
     * @return returns the size of the list of Accounts List.
     */
    private int numberOfAccounts() {

	return listOfAccounts().size();
    }

    /**
     * This method gets a list of all the usernames in a list of Account
     * objects.
     * 
     * @return returns a list of String objects (usernames)
     */
    private List<String> getListOfUsernames() {

	String userName = "";
	int sizeOfList = numberOfAccounts();

	// add to this and return it
	List<String> userNameList = new LinkedList<String>();

	// get usernames from this
	List<Account> listOfAccountsToIterateOver = listOfAccounts();

	for (int i = 0; i < sizeOfList; i++) {
	    Account acc = listOfAccountsToIterateOver.get(i);
	    userName = acc.getUserName();
	    userNameList.add(userName);
	}

	return userNameList;
    }

    /**
     * This method gets a list of scores that are saved on the csv file
     * 
     * @return returns a list scores
     */
    private List<Integer> getListOfScores() {

	int totalScore = 0;
	int sizeOfList = numberOfAccounts();

	// add to this and return it
	List<Integer> totalScoresList = new LinkedList<Integer>();

	// get usernames from this
	List<Account> listOfAccountsToIterateOver = listOfAccounts();

	for (int i = 0; i < sizeOfList; i++) {
	    Account acc = listOfAccountsToIterateOver.get(i);
	    totalScore = acc.getTotalScore();
	    totalScoresList.add(totalScore);

	}

	return totalScoresList;
    }

    /**
     * This method gets the topTen players and their scores
     * 
     * @return returns a Players object containing the top 10 scores along with
     *         their user names;
     */
    public Players showTopTen() {

	List<String> names = getListOfUsernames();
	List<Integer> scores = getListOfScores();

	Players newPlayer = new Players(names, scores);

	HighScoreDatabase database = new HighScoreDatabase(newPlayer);

	Players temp = database.sortByScore();

	database.sortedForm(temp);

	//
	// The lists are sorted now, gotta get the top 10 users/scores now
	//

	// Build a player with sorted lists
	Players temp2 = database.getListOfPlayers();

	// Extract the top ten players and store them in a Players object
	Players finalplayer = database.topTen(temp2);

	// The view will extract both the name and the score. It will return
	// something else
	// if the result from it is null [implement it that way]

	return finalplayer;

    }

}
