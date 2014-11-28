package savingSystem;

import gameplay.GameFrame;
import gameplay.GamePanel;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.io.IOException;
import java.util.List;

public class SaveLoadController {

	private SavedGameSerialization serializeGame = new SavedGameSerialization();
	private SavedGameManager saveManager = new SavedGameManager();
	private GameState currentGame = GameStateManager.getInstance().getCurrentGameState();
	private String fileName = "";

	public void displaySaveGameMenu() {
		SaveGameMenuView saveMenu = new SaveGameMenuView();
		saveMenu.SaveGameMenuView();
	}

	public void displayLoadGameMenu() {
		LoadGameMenuView loadMenu = new LoadGameMenuView();
		loadMenu.LoadGameMenuView();
	}

	public void saveGame(String savedGameName) {

		SavedGame savedGame = new SavedGame();

		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			System.out.println("Step 1: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savedGame = saveManager.addSavedGameName(savedGameName);
		savedGame.setGameState(currentGame);
//		savedGame.setSavedGameName(savedGameName);
		savedGame.setUserName(currentGame.getUserName());
		
		System.out.println("Line before Step 2 SavedGame: " + savedGame);
		System.out.println("Step 2: Save Game Name: " + savedGameName
				+ ", username: " + currentGame.getUserName());

		try {
			serializeGame.serializeSaveGameName(savedGame, fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Step 4: Serialization Done");

	}

	public void loadGame() {
		SavedGame game = null;
		try {
			fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			System.out.println("Load Controller:" + fileName);
			List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);
			saveManager.setSavedGamesList(allSavedGames);

			System.out.println("Step 5: Deserialized List: " + allSavedGames);
			for (int i = 0; i < allSavedGames.size(); i++) {
				game = allSavedGames.get(i);
				game.getGameState();
				System.out.println("GameState parsed Information: \n Name: "
						+ game.getGameState().getPlayerName() + "\n Username: "
						+ game.getGameState().getUserName() + "\n World: "
						+ game.getGameState().getWorld() + "\n Level: "
						+ game.getGameState().getLevel() + "\n Score: "
						+ game.getGameState().getScore()
						+ "\n Remaining Lives: "
						+ game.getGameState().getRemainingLives()
						+ "\n Size of list: " + allSavedGames.size());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GameFrame gameplay = new GameFrame();
		gameplay.setVisible(true);
	}
	
	public void deleteGame(String deleteGame) {
		System.out.println(saveManager.getSavedGamesList() + "\n Size:"+ saveManager.numberOfSavedGames());
		saveManager.removeSavedGame(deleteGame);
	}

}
