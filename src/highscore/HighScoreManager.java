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

public class HighScoreManager {

  
    
    //Constructor
    public HighScoreManager(){
	
    }
    
    // getting the number of accounts
    private int numberOfAccounts() {

	return listOfAccounts().size();
    }
    
    
    //getting the lists of accounts
    private List<Account> listOfAccounts(){
	
	List<Account> listOfAccounts = UserProfile.getInstance().getAccountManager().getAccounts();
	return listOfAccounts;
    }
    
   
    
    private List<String> getListOfUsernames(){
	
	String userName = "";
	int sizeOfList = numberOfAccounts();
	
	//add to this and return it
	List<String> userNameList = new LinkedList<String>();
	
	
	//get usernames from this
	List<Account> listOfAccountsToIterateOver = listOfAccounts();
	
	for(int i = 0; i < sizeOfList; i++){
	    Account acc = listOfAccountsToIterateOver.get(i);
	    userName = acc.getUserName();
	    userNameList.add(userName);
	}
	
	return userNameList;
    }
    
    
    private List<Integer> getListOfScores(){
	
	int totalScore = 0;
	int sizeOfList = numberOfAccounts();
	
	//add to this and return it
	List<Integer> totalScoresList = new LinkedList<Integer>();
	
	//get usernames from this
	List<Account> listOfAccountsToIterateOver = listOfAccounts();
	
	for(int i = 0; i < sizeOfList; i++){
	    Account acc = listOfAccountsToIterateOver.get(i);
	    totalScore = acc.getTotalScore();
	    totalScoresList.add(totalScore);
	    
	}
	
	return totalScoresList;
    }
 
    
    
 


    public Players showTopTen() {

	// get the right info from the getCSVetc. methods above and implement
	// same logic as the main method in HighScoreDatabase
	// also logic to check if there is anything that is empty or what not
	// should go here.
	// when the view creates a HighScoreManager c
	
	List<String> names = getListOfUsernames();
	List<Integer> scores = getListOfScores();
	
	
	Players newPlayer = new Players(names, scores);
	
	HighScoreDatabase database = new HighScoreDatabase(newPlayer);

	Players temp = database.sortByScore();

	database.sortedForm(temp);
	
	// NOW IT'S SORTED

	// gotta extrac top 10 from it

	Players temp2 = database.getListOfPlayers();

	// Need players sorted
	Players finalplayer = database.topTen(temp2);
	
	//RETURN FINALPLAYER ONCE CSV METHODS IMPLEMENTED 
	//the view will extract both the name and the score. it will return something else
	//if the result from it is null.

	return finalplayer;

    }

}
