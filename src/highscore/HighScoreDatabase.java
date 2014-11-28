package highscore;

import java.util.LinkedList;
import java.util.List;

public class HighScoreDatabase {
    
    //private List <Integer> scores = new LinkedList<Integer>();
    //private List<String> playerNames = new LinkedList<String>();
    Players listOfPlayers;
    
    
    //TO KIRTH: ADD HERE
    public void getPlayerNames(){
	//this should get data from the savedGame system and input into the String list
	
	//listOfPlayers.setPlayerNames(List<String> list HERE);
    }
    
    //TO KIRTH: ADD HERE
    public void getPlayerScores(){
	//this should get data from the savedGame system and input it into the Integer list
	
	//listOfPlayers.setScores(List<Integer> list HERE);
    }
    
    
    public List<String> transmitPlayerNames(){
	
	
	return listOfPlayers.getPlayerNames();
	
    }
    
    public List<Integer> transmitScores(){
	
	return listOfPlayers.getScores();
	
    }
    
    public void sortByScore(){
	
	Players newList;
	
	Integer tracker;
	Integer currentScore;
	Integer currentMaxScore = 0;
	
	for(int i = 0; i < listOfPlayers.getScores().size(); i++){
	    
	    currentScore = listOfPlayers.getScores().get(i);
	}
	
	listOfPlayers.getPlayerNames();
	
    }
    
    public static void main(){
	
	List<Integer> s = new LinkedList<Integer>();
	List<String> p = new LinkedList<String>();
	
	s.add(10000);
	s.add(12000);
	s.add(9000);
	s.add(30000);
	
	
	p.add("TenThousand");
	p.add("TwelveThousad");
	p.add("NineThousand");
	p.add("ThirtyThousand");
	
	//Players testing  = new Players
    }

}
