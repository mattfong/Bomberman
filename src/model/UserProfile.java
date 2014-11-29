package model;

import highscore.HighScoreDatabase;

import java.io.IOException;
import java.util.List;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import savingSystem.SavedGame;
import savingSystem.SavedGameManager;
import savingSystem.SavedGameSerialization;


public class UserProfile {
	
	private static UserProfile singleton = null;
	private AccountManager accountManager;
	private SavedGameManager saveManager;
	private HighScoreDatabase scoreDatabase;
	// Insert Unlocked Levels

	public UserProfile() {
		accountManager = new AccountManager();
		saveManager = new SavedGameManager();
	}
	
	public static UserProfile getInstance() {
		if(singleton == null) {
			singleton = new UserProfile();
		}
		
		return singleton;
	}
	
	private List<Account> getAllUserAccounts() throws IOException {
		CSVreader reader = new CSVreader();
		accountManager.setAccounts(reader.CSVreaderAccounts());
		return accountManager.getAccounts();
	}
	
	private Account getCurrentUser(String userName) {
		Account currentAccount = accountManager.getAccount(userName);
		return currentAccount;
	}
	
	private List<SavedGame> getSavedGamesByUser(String userName) throws IOException {
		String fileName = saveManager.getSaveGameFile(userName);
		SavedGameSerialization serializeGame = new SavedGameSerialization();
		List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);
		saveManager.setSavedGamesList(allSavedGames);
		return saveManager.getSavedGamesList();
	}
	
}
