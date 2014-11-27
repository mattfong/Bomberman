package savingSystem;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.io.IOException;
import java.util.List;

public class LoadGameMenuController {

    private SavedGameSerialization serializeGame = new SavedGameSerialization();
    private SavedGameManager saveManager = new SavedGameManager();
    private GameState currentGame = GameStateManager.getInstance().getCurrentGameState();
    private String fileName = "";

    public void displayLoadGameMenu() {
	LoadGameMenuView loadMenu = new LoadGameMenuView();
	loadMenu.LoadGameMenuView();
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
		System.out.println("GameState parsed Information: \n Name: " + game.getGameState().getPlayerName() +
				"\n Username: " + game.getGameState().getUserName() + 
				"\n World: " + game.getGameState().getWorld() +
				"\n Level: " + game.getGameState().getLevel() +
				"\n Score: " + game.getGameState().getScore() +
				"\n Remaining Lives: " + game.getGameState().getRemainingLives());
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public List<SavedGame> deleteSavedGame(String deleteGame) {
    	List<SavedGame> allSavedGames = null;
	try {
	    fileName = saveManager.getSaveGameFile(currentGame.getUserName());
	    allSavedGames = serializeGame.deserializeSaveGameName(fileName);
	    saveManager.setSavedGamesList(allSavedGames);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
		System.out.println(saveManager.numberOfSavedGames());
		saveManager.removeSavedGame(deleteGame);
	return allSavedGames;
    }
}
