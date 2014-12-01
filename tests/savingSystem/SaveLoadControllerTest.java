package savingSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaveLoadControllerTest {
	
	private SaveLoadController controller;
	private String savedGameName;
	private SavedGame game, game2;
	
	@Before
	public void setUp() throws Exception {
		controller = new SaveLoadController();
		savedGameName = "Game2";
		game = new SavedGame();
		game2 = new SavedGame();
	}

	@Test
	public void test() {
		controller.saveGame(savedGameName);
		String nameFromSave = game.getSavedGameName();
		
		controller.loadGame(1);
		String nameFromLoad = game.getSavedGameName();
		assertEquals(nameFromSave, nameFromLoad);
	}

}
