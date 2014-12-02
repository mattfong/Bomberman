package highscore;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HighscoreDatabaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
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
	s.add(19);
	s.add(17);
	s.add(5);
	s.add(3);
	s.add(2);
	s.add(1);
	
	
	Players testPlayers = new Players(p, s);
	
	Integer scoreTest = testPlayers.getScores().get(0);
	assertEquals(scoreTest.intValue(), 10000);
	
	
	String nameTest = testPlayers.getPlayerNames().get(0);
	assertEquals("TenThousand", nameTest);
	
	HighScoreDatabase testDatabase = new HighScoreDatabase(testPlayers);

	Players sorted = testDatabase.sortByScore();

	testDatabase.sortedForm(sorted);
	
	Players updated = testDatabase.getListOfPlayers();
	
	Players topTenNames = testDatabase.topTen(updated);
	
	String firstName = topTenNames.getPlayerNames().get(0);
	
	assertEquals("ThirtyThousand", firstName);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	HighScoreDatabase testdb = new HighScoreDatabase(testPlayers);
	
	
	testdb.sortByScore();
	
	Players sorted = testdb.getListOfPlayers();
	
	Players topTenSorted = testdb.topTen(sorted);
	
	Integer integer = topTenSorted.getScores().get(0);
	
	
	assertEquals(integer.toString(), "30000");
	
	 */   
	    
	}

}
