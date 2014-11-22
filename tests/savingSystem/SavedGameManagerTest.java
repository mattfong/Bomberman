package savingSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import savingSystem.SavedGame;
import savingSystem.SavedGameManager;

public class SavedGameManagerTest {

	SavedGameManager testSavedGameManager;
	
	@Before
	public void setup(){
		testSavedGameManager = new SavedGameManager();
	}
	
	@Test
	public void test() {
		String savedGame = "Game1";
		SavedGame sg = new SavedGame();
		assertTrue("Saved Game Name equals savedGame", 
				testSavedGameManager.addSavedGame(savedGame).contains(sg.getSavedGameName()));
	}

}
