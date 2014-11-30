package highscore;

import java.util.List;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import savingSystem.SavedGameManager;

public class HighScoreManager {

  
    
    //Constructor
    public HighScoreManager(){
	
    }
    
    
    
 

    
    

    // TO KIRTH: ADD HERE
    private List<String> getPlayerNamesFromCSV() {
	// this should get data from the savedGame system and input into the
	// String list

	// setPlayerNames(List<String> list HERE);
	return null;
    }

    // TO KIRTH: ADD HERE
    private List<Integer> getPlayerScoresFromCSV() {
	// this should get data from the savedGame system and input it into the
	// Integer list

	// setScores(List<Integer> list HERE);
	return null;
    }

    public Players showTopTen() {

	// get the right info from the getCSVetc. methods above and implement
	// same logic as the main method in HighScoreDatabase
	// also logic to check if there is anything that is empty or what not
	// should go here.
	// when the view creates a HighScoreManager c
	
	List<String> names = getPlayerNamesFromCSV();
	List<Integer> scores = getPlayerScoresFromCSV();
	
	
	
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

	return null;

    }

}
