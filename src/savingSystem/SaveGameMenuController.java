package savingSystem;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.io.IOException;

public class SaveGameMenuController {
	
	private SavedGameSerialization serializeGame = new SavedGameSerialization();
	private SavedGameManager saveManager = new SavedGameManager();
	private SavedGame savedGame = new SavedGame();
	private String fileName = "";
	
	public void displaySavedGameMenu(){
		SaveGameMenuView saveMenu = new SaveGameMenuView();
		saveMenu.SaveGameMenuView();
	}
	
	public void saveGame(String savedGameName){

		GameStateManager gameStateManager = GameStateManager.getInstance();
		GameState currentGame = gameStateManager.getCurrentGameState();
		
		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			System.out.println("Step 1: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savedGame = saveManager.addSavedGame(savedGameName);
		savedGame.setGameState(currentGame);
		savedGame.setSavedGameName(savedGameName);
		savedGame.setUserName(currentGame.getUserName());

		System.out.println("Line before Step 2 SavedGame: " + savedGame);
		System.out.println("Step 2: Save Game Name: " + savedGameName + ", username: " + currentGame.getUserName());
		
		try {
			serializeGame.serializeSaveGameName(savedGame, fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Step 4: Serialization Done");
		
	}
}
