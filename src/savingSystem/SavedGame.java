package savingSystem;

import gameplay.statemanagers.GameState;

import java.io.Serializable;

/**
 * A class which creates the SavedGame object, which contains getters/setters
 * for GameState, userName, and savedGameName.
 * 
 * @author Kirththiga Murugupillai
 *
 */
public class SavedGame implements Serializable {

    private GameState gameState;
    private String userName;
    private String savedGameName;

    public SavedGame() {
	super();
    }

    public SavedGame(GameState gameState, String userName) {
	super();
	this.gameState = gameState;
	this.userName = userName;
    }

    public SavedGame(GameState gameState, String userName, String savedGameName) {
	super();
	this.gameState = gameState;
	this.userName = userName;
	this.savedGameName = savedGameName;
    }

    public GameState getGameState() {
	return gameState;
    }

    public void setGameState(GameState gameState) {
	this.gameState = gameState;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getSavedGameName() {
	return savedGameName;
    }

    public void setSavedGameName(String savedGameName) {
	this.savedGameName = savedGameName;
    }

    @Override
    public String toString() {
	return "SavedGame [gameState=" + gameState + ", userName=" + userName + ", savedGameName=" + savedGameName + "]";
    }

}
