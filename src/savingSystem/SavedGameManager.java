package savingSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class performs operations on a list of SavedGame.
 * 
 * @author Kirththiga Murugupillai
 *
 */
public class SavedGameManager {

    private List<SavedGame> savedGamesList;

    public SavedGameManager() {
	savedGamesList = new ArrayList<SavedGame>();
    }

    public List<SavedGame> getSavedGamesList() {
	return savedGamesList;
    }

    public void setSavedGamesList(List<SavedGame> savedGamesList) {
	this.savedGamesList = savedGamesList;
    }

    /**
     * Add a saved game to the list of saved games.
     * 
     * @param savedGameName
     * @return a saved game
     */
    public SavedGame addSavedGameName(String savedGameName) {
	SavedGame currentSavedGame = new SavedGame();
	currentSavedGame.setSavedGameName(savedGameName);
	savedGamesList.add(new SavedGame(currentSavedGame.getGameState(), currentSavedGame.getUserName(), currentSavedGame.getSavedGameName()));
	return currentSavedGame;
    }

    /**
     * Removes a saved game from the list.
     * 
     * @param removeSavedGame
     */
    public void removeSavedGame(String removeSavedGame) {
	for (int i = 0; i < savedGamesList.size(); i++) {
	    SavedGame savedGame = savedGamesList.get(i);
	    if (savedGame.getSavedGameName().equals(removeSavedGame)) {
		savedGamesList.remove(i);
	    }
	}
    }

    /**
     * Determines the number of saved games in the list.
     * 
     * @return the number of saved games in the list
     */
    public int numberOfSavedGames() {
	return savedGamesList.size();
    }

    /***
     * Get the name of the saved game file of the user.
     * 
     * @param userName
     * @return
     * @throws IOException
     */
    public String getSaveGameFile(String userName) throws IOException {
	String fileName = userName + "SaveGameList.ser";
	File saveFile = new File(fileName);

	if (saveFile.exists() == false) {
	    saveFile.createNewFile();
	    return fileName;
	}

	return fileName;
    }

    @Override
    public String toString() {
	return "SavedGameManager [savedGamesList=" + savedGamesList + "]";
    }

}
