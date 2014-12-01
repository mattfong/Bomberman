package highscore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HighScoreDatabase {
    
    
    private Players listOfPlayers;
    

    //Constructor
    public HighScoreDatabase(Players database){
	this.listOfPlayers = database;
    }
    
    
    
    public Players getListOfPlayers() {
        return listOfPlayers;
    }


    public void setListOfPlayers(Players listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }


    
    //TODO
    public List<String> transmitPlayerNames(){
	
	
	return listOfPlayers.getPlayerNames();
	
    }
    
    //TODO
    public List<Integer> transmitScores(){
	
	return listOfPlayers.getScores();
	
    }
    
    //This returns a Players object with the database of users sorted
    public Players sortByScore(){
	
	
	//Add to these lists and create a new Players object with them after
	List<String> players = new LinkedList <String>();
	List<Integer> scores = new LinkedList <Integer>();
	
	//Remove from these lists when adding to the ones above
	List <String> playersToRemove = listOfPlayers.getPlayerNames();
	List <Integer> scoresToRemove = listOfPlayers.getScores();
	
	//size of database
	Integer numberOfPlayers = listOfPlayers.getScores().size();
	
	
	//Trackers
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
    
    
    //This changes the listOfPlayers into sorted form
    public void sortedForm(Players players){
	
	List<String> names = players.getPlayerNames();
	
	List<Integer> scores = players.getScores();
	
	this.listOfPlayers.setPlayerNames(names);
	
	this.listOfPlayers.setScores(scores);
	
	
	//Sort player names
	//this.listOfPlayers.setPlayerNames(this.sortByScore().getPlayerNames());
	
	//Sort player scores
	//this.listOfPlayers.setScores(this.sortByScore().getScores());	
    }
    
    
    
    //takes two lists that have already been sorted by the sortedForm method
    public Players topTen(Players players){
	
	List<String> names = players.getPlayerNames();
	List<Integer> scores = players.getScores();
	
	List<String> newNames = new LinkedList<String>();
	List<Integer> newScores = new LinkedList<Integer>();
	
	
	//names
	ListIterator<String> nameIterator = names.listIterator();
	
	
	int indexNames = 0;
	
	while(nameIterator.hasNext() && (indexNames < 10)){
	     
	    String nameToAdd = nameIterator.next();
	    
	    newNames.add(nameToAdd);
	    
	    indexNames++;
	    
	}
	
	//scores
	ListIterator<Integer> scoreIterator = scores.listIterator();
	
	int indexScores = 0;
	
	while(scoreIterator.hasNext() && (indexScores < 10)){
	    
	    
	    
	    int scoreToAdd = scoreIterator.next();
	    
	    newScores.add(indexScores, scoreToAdd);
	    
	    indexScores++;
	    
	}
	
	Players newPlayer = new Players(newNames, newScores);
	
	return newPlayer;
	
	
    }
    
    
    
 
   
    
    //REMOVE THIS FROM THE FINAL SUBMISSION
    public static void main(String[]args){
	
	
	List<String> p = new LinkedList<String>();
	List<Integer> s = new LinkedList<Integer>();
	
	p.add("TenThousand");
	p.add("EightThousand");
	p.add("NineThousand");
	p.add("ThirtyThousand");
	p.add("SixteenThousand");
	p.add("Nineteen");
	p.add("Seventeen");
	p.add("Five");
	p.add("Three");
	p.add("Two");
	p.add("One");
	
	s.add(10000);
	s.add(8000);
	s.add(9000);
	s.add(30000);
	s.add(16000);
	s.add(19000);
	s.add(17000);
	s.add(5000);
	s.add(3000);
	s.add(2000);
	s.add(1000);
	
	
	
	//System.out.println(s.get(0));
	
	
	
	
	//Logic to be implemented by the controller
	
	//Linked list 1 = ...
	//Linked list 2 = ...
	Players testPlayers = new Players(p, s); //p and s should be coming from the players class. 
	
	HighScoreDatabase testdb = new HighScoreDatabase(testPlayers);
	
	
	Players jedi = testdb.sortByScore();
	
	
	testdb.sortedForm(jedi);
	//NOW IT'S SORTED
	
	//gotta extrac top 10 from it
	
	Players vader = testdb.getListOfPlayers();
	
	//Need players sorted
	Players newVader = testdb.topTen(vader);
	
	
	
	
	//testdb.topTen(players)
	
	String str = newVader.getScores().toString();
	//String str = testdb.sortByScore().getScores().toString();
	
	
	
	System.out.println(str);
	
	
	
	
	
	
	System.out.println("yo");
	
	
	
	
	
	
	
	//Players testing  = new Players
    }

}
