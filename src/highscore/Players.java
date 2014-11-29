package highscore;

import java.util.LinkedList;
import java.util.List;

public class Players {
    
    private List<String> playerNames = new LinkedList<String>();
    private List <Integer> scores = new LinkedList<Integer>();
    
    
    //Constructor
    public Players(LinkedList<String> stringList, LinkedList<Integer> integerList){
	
    }
    
    //Getters/Setters
    public List<String> getPlayerNames() {
	return playerNames;
    }
    public void setPlayerNames(List<String> playerNames) {
	this.playerNames = playerNames;
    }
    
    
    //Getters/Setters
    public List <Integer> getScores() {
	return scores;
    }
    public void setScores(List <Integer> scores) {
	this.scores = scores;
    }
    

}
