package savingSystem;

import gameplay.statemanagers.GameStateManager;

import java.io.IOException;
import java.util.List;

import loginSystem.Account;

public class SaveGameMenuController {
	
//	private String savedGameName = "";
	private SavedGameManager saveManager = new SavedGameManager();
	private SavedGame savedGame = new SavedGame();
	private String fileName = "";
	
	public void displaySavedGameMenu(){
		SaveGameMenuView saveMenu = new SaveGameMenuView();
		saveMenu.SaveGameMenuView();
	}
	
	public void saveGame(String savedGameName){
		Account acc =new Account();
		try {
	//		fileName = saveManager.getSaveGameFile("GameStateManager.getInstance().getCurrentGameState().getUserName()");
			fileName = saveManager.getSaveGameFile("Demo44");
			System.out.println("Step 1: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savedGame = saveManager.addSavedGame(savedGameName);
		savedGame.setGameState(GameStateManager.getInstance().getCurrentGameState());
		savedGame.setSavedGameName(savedGameName);
		savedGame.setUserName("GameStateManager.getInstance().getCurrentGameState().getUserName()");
		SavedGameSerialization serializeGame = new SavedGameSerialization();
		System.out.println("Line before Step 2 SavedGame: " + savedGame);
		System.out.println("Step 2: Save Game Name: " + savedGameName + ", username: " + "GameStateManager.getInstance().getCurrentGameState().getUserName()");
		
		try {
			serializeGame.serializeSaveGameName(savedGame, fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Step 4: Serialization Done");
		
		try {
			List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);

			System.out.println("Step 5: Deserialized List: " + allSavedGames); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
