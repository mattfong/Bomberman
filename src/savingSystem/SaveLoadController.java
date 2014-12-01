package savingSystem;

import gameplay.engine.GameFrame;
import gameplay.engine.GamePanel;
import gameplay.gameobject.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.World;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This class deals with loading, saving, and deleting a game from a serialized file.
 * @author Kirththiga Murugupillai
 *
 */
public class SaveLoadController {

	private SavedGameSerialization serializeGame;
	private SavedGameManager saveManager;
	private GameState currentGame;
	private String fileName;
	
	public SaveLoadController() {
		serializeGame = new SavedGameSerialization();
		saveManager = new SavedGameManager();
		currentGame = GameStateManager.getInstance().getCurrentGameState();
		fileName = "";
	}

	public void displaySaveGameMenu() {
		SaveGameMenuView saveMenu = new SaveGameMenuView();
		saveMenu.SaveGameMenuView();
	}

	public void displayLoadGameMenu() {
		LoadGameMenuView loadMenu = new LoadGameMenuView();
		loadMenu.LoadGameMenuView();
	}

	/**
	 * Uses the save game name entered by the user, and saves the game by serializing the information.
	 * @param savedGameName
	 */
	public void saveGame(String savedGameName) {

		SavedGame savedGame = new SavedGame();

		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		savedGame = saveManager.addSavedGameName(savedGameName);
		savedGame.setGameState(currentGame);
		savedGame.setSavedGameName(savedGameName);
		savedGame.setUserName(currentGame.getUserName());

		try {
			serializeGame.serializeSaveGameName(savedGame, fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Obtain's the user's save game file, and deserializes all the games within the file.
	 * @param index
	 */
	public void loadGame(int index) {
		SavedGame game = null;
		
		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);
			saveManager.setSavedGamesList(allSavedGames);

			System.out.println("Step 5: Deserialized List: " + allSavedGames);
			for (int i = 0; i < allSavedGames.size(); i++) {
				if(index == i){
					game = allSavedGames.get(i);
	
					World world = game.getGameState().getWorld();
					GameFrame gameplay = new GameFrame(world);
					gameplay.setVisible(true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Uses the delete game name entered by the user, and deletes the game from the file.
	 * Then, the file is serialized and overwritten with the new list.
	 * @param deleteGame
	 */
	public void deleteGame(String deleteGame) {
		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			serializeGame.serializeGamesAfterRemoval(fileName, deleteGame);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtaining all the save games and the levels reached for each saved game.
	 * Then the levels are stored in an array and sorted in ascending order.
	 * The highest level reached by user would be stored in the last index.
	 * @return maximum level achieved by user
	 */
	public int maxLevelReachedByUser() {
		SavedGame game = null;
		int[] levelsStored; 
		//If there are no saved games, then the user starts at level 1.
		int maxLevel = 1;
		
		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);
			saveManager.setSavedGamesList(allSavedGames);
			levelsStored = new int[saveManager.numberOfSavedGames()];
	
			/* Looping through the list of saved games, and get all the levels of the saved games.
			 * Then, store the levels in an array and sort. 
			*/
			for (int i = 0; i < allSavedGames.size(); i++) {
				game = allSavedGames.get(i);
				Level level = game.getGameState().getLevel();
				levelsStored[i] = level.getLevelNumber();
			}
			Arrays.sort(levelsStored);
			
			if(saveManager.numberOfSavedGames() > 0) {
				// Obtaining the highest level achieved by the user, which is stored in the last index.
				maxLevel = levelsStored[saveManager.numberOfSavedGames()-1];
			} else {
				maxLevel = 1;
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return maxLevel;
	}

}
