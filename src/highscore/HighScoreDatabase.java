package highscore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * The HighScoreDatabase is the class that's mainly responsible for sorting the
 * lists of usernames and scores for the HighScoreView class to display
 * 
 * @author Yahya Azami <yahya.azami@mail.mcgill.ca>
 * @since 2014-11-30
 * 
 */
public class HighScoreDatabase {

    private Players listOfPlayers;

    // Constructor
    public HighScoreDatabase(Players database) {
	this.listOfPlayers = database;
    }

    // Getters/setters for listOfPlayers
    public Players getListOfPlayers() {
	return listOfPlayers;
    }

    public void setListOfPlayers(Players listOfPlayers) {
	this.listOfPlayers = listOfPlayers;
    }

    /**
     * This returns a Players object with the database of users sorted
     * 
     * @return returns a Players object with the database of users sorted
     *         according to their high score, i.e. whoever has the highest score
     *         will have both his name and his score first on the names List and
     *         on the scores List.
     */
    public Players sortByScore() {

	// Add to these lists and create a new Players object with them after
	List<String> players = new LinkedList<String>();
	List<Integer> scores = new LinkedList<Integer>();

	// Remove from these lists when adding to the ones above
	List<String> playersToRemove = listOfPlayers.getPlayerNames();
	List<Integer> scoresToRemove = listOfPlayers.getScores();

	// size of database
	Integer numberOfPlayers = listOfPlayers.getScores().size();

	// Trackers
	int currentScore = 0;
	int maxScore = 0;
	int maxIndex = 0;
	String maxPlayerName = "";

	while ((numberOfPlayers) != 0) {

	    // Resetting maxScore and current score
	    currentScore = 0;
	    maxScore = 0;

	    for (int i = 0; i < numberOfPlayers; i++) {

		// get current element
		currentScore = scoresToRemove.get(i);

		// i is the index of this element

		// store maxScore and the index of it
		if (currentScore >= maxScore) {
		    maxIndex = i;
		    maxScore = currentScore;
		    maxPlayerName = playersToRemove.get(maxIndex);
		}

	    }

	    players.add(maxPlayerName);
	    scores.add(maxScore);

	    playersToRemove.remove(maxIndex);
	    scoresToRemove.remove(maxIndex);

	    numberOfPlayers--;

	}

	Players newList = new Players(players, scores);

	return newList;

    }

    /**
     * This method replaces the fields of the listOfPlayers object (which are
     * lists) with a sorted version of them
     * 
     * @param players
     *            players is a duplicate of the listOfPlayers object that has
     *            had its fields sorted by the sortByScore method. The two
     *            sorted lists contained in this players object will replace the
     *            unsorted ones that is currently in the listOfPlayers object.
     */
    public void sortedForm(Players players) {

	List<String> names = players.getPlayerNames();

	List<Integer> scores = players.getScores();

	this.listOfPlayers.setPlayerNames(names);

	this.listOfPlayers.setScores(scores);

    }

    /**
     * This method is responsible for extracting the ten best high scores along
     * with the associated user names from a given Players object that has them
     * already sorted out.
     * 
     * @param players
     *            players is a previously sorted Players object with sortByScore
     * @return returns a Players object with only the top ten scores along with
     *         the user names associated with it.
     */
    public Players topTen(Players players) {

	List<String> names = players.getPlayerNames();
	List<Integer> scores = players.getScores();

	List<String> newNames = new LinkedList<String>();
	List<Integer> newScores = new LinkedList<Integer>();

	// names
	ListIterator<String> nameIterator = names.listIterator();

	int indexNames = 0;

	while (nameIterator.hasNext() && (indexNames < 10)) {

	    String nameToAdd = nameIterator.next();

	    newNames.add(nameToAdd);

	    indexNames++;

	}

	// scores
	ListIterator<Integer> scoreIterator = scores.listIterator();

	int indexScores = 0;

	while (scoreIterator.hasNext() && (indexScores < 10)) {

	    int scoreToAdd = scoreIterator.next();

	    newScores.add(indexScores, scoreToAdd);

	    indexScores++;

	}

	Players newPlayer = new Players(newNames, newScores);

	return newPlayer;

    }

}
