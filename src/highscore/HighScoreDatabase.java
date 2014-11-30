package highscore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HighScoreDatabase {
    
    //private List <Integer> scores = new LinkedList<Integer>();
    //private List<String> playerNames = new LinkedList<String>();
    
    private Players listOfPlayers;
    
    //Constructor
    public HighScoreDatabase(Players database){
	this.listOfPlayers = database;
    }
    
    
    //TO KIRTH: ADD HERE
    public void getPlayerNamesFromCSV(){
	//this should get data from the savedGame system and input into the String list
	
	//listOfPlayers.setPlayerNames(List<String> list HERE);
    }
    
    //TO KIRTH: ADD HERE
    public void getPlayerScoresFromCSV(){
	//this should get data from the savedGame system and input it into the Integer list
	
	//listOfPlayers.setScores(List<Integer> list HERE);
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
		if (currentScore > maxScore) {
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
    public void sortedForm(){
	
	
	//Sort player names
	this.listOfPlayers.setPlayerNames(this.sortByScore().getPlayerNames());
	
	//Sort player scores
	this.listOfPlayers.setScores(this.sortByScore().getScores());	
    }
    
    //Populates the a list of string with "Empty"
    public static List<String> playersListPopulator(List<String> strlist){
	
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	strlist.add("<Empty>");
	
	return strlist;
    }
    
    
    //Populates a list of Integers with -1
    public static List<Integer> scoresListPopulator(List<Integer> intlist){
	
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	intlist.add(-1);
	
	
	return intlist;
	
	
    }
    
 
    
    
    //This looks at the listOfPlayers and returns the top 10 players along with their scores
    public Players topTen(){
	
	this.sortedForm();
	
	List<String> p = new LinkedList<String>();
	List<Integer> s = new LinkedList<Integer>();
	
	playersListPopulator(p);
	scoresListPopulator(s);
	
	
	//Putting the right number of Strings in
	ListIterator<String> nameIterator = this.listOfPlayers.getPlayerNames().listIterator();
	
	int indexNames = 0;
	while(nameIterator.hasNext() && (nameIterator.next()!=null) && (indexNames < 10)){
	    
	    
	    p.remove(indexNames);
	    
	    String str = nameIterator.next();
	    
	    p.add(indexNames, str);
	    
	    indexNames++;
	    
	}
	
	
	//Putting the right number of scores in
	ListIterator<Integer> scoreIterator = this.listOfPlayers.getScores().listIterator();
	
	int indexScores = 0;
	
	while(scoreIterator.hasNext() && (scoreIterator.next() != null) && (indexScores < 10)){
	    
	    s.remove(indexScores);
	    
	    int integer = scoreIterator.next();
	    
	    s.add(indexScores, integer);
	    
	    indexScores++;
	    
	}
	
	
	Players newPlayer = new Players(p, s);
	
	
	return newPlayer;
	
    }
    
    
    
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
	
	
	
	
	
	
	
	Players testPlayers = new Players(p, s);
	
	HighScoreDatabase testdb = new HighScoreDatabase(testPlayers);
	
	//testdb.sortedForm();
	
	//Players jedi = testdb.topTen();
	
	//System.out.println(jedi.getScores().toString());
	
	testdb.sortedForm();
	
	System.out.println(testdb.listOfPlayers.getPlayerNames().toString());
	
	
	
	
	
	
	
	/*
	
	List<String> tlist = new LinkedList<String>();
	
	tlist.add("TenThousand");
	tlist.add("EightThousand");
	tlist.add("NineThousand");
	tlist.add("ThirtyThousand");
	
	
	ListIterator<String> itr = tlist.listIterator(0);
	
	
	*/
	
	
	
	
	/*
	
	
	while (itr.hasNext() && itr.next() != null ){
	   
	    String str = itr.next();
	    System.out.println(str);
	   
	}
	
	*/
	
	System.out.println("yo");
	
	//String str = testdb.listOfPlayers.getPlayerNames().get(2);
	
	//System.out.println(str);
	
	//getting something
	//System.out.println(testdb.listOfPlayers.getPlayerNames().get(0));
	
	
	//System.out.println(testdb.sortByScore().getScores().get(3));
	
	
	
	//removeUser(testPlayers, 0);
	
	//System.out.println(testPlayers.getScores().get(0));
	
	
	//Players test = new Players(p, s);
	
	//HighScoreDatabase testdb = new HighScoreDatabase(test);
	
	//test = testdb.sortByScore();
	
	//System.out.println(test.getPlayerNames().get(0));
	//System.out.println(test.getScores().get(0));
	
	//System.out.println(testdb.sortByScore().getPlayerNames().get(0));
	//System.out.println(testdb.sor)
	//test.s
	
	
	
	
	
	//Players testing  = new Players
    }

}
