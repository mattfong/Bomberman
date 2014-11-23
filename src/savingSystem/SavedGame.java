package savingSystem;

import gameplay.statemanagers.GameState;

import java.io.Serializable;

public class SavedGame implements Serializable{
	
	private GameState gameState;
	private String userName;
	private String savedGameName;
	
	public SavedGame() {
		super();
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
	
}
