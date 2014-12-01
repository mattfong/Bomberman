package highscore;

import java.util.LinkedList;
import java.util.List;

/**
 * This Players class stores two Lists containing the names of the players that
 * have a high score and their respective score.
 * 
 * @author Yahya Azami <yahya.azami@mail.mcgill.ca>
 * @since 2014-11-30
 * 
 */
public class Players {

    private List<String> playerNames = new LinkedList<String>();
    private List<Integer> scores = new LinkedList<Integer>();

    // Constructor
    public Players(List<String> stringList, List<Integer> integerList) {
	this.playerNames = stringList;
	this.scores = integerList;
    }

    // Getters/Setters for player names
    public List<String> getPlayerNames() {
	return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
	this.playerNames = playerNames;
    }

    // Getters/Setters for player scores
    public List<Integer> getScores() {
	return scores;
    }

    public void setScores(List<Integer> scores) {
	this.scores = scores;
    }

}
