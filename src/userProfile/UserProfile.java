package userProfile;

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
<<<<<<< Updated upstream
	
	private static UserProfile singleton = null;
	private String userName;
	private AccountManager accountManager;
	private SavedGameManager saveManager;
	private HighScoreDatabase scoreDatabase;
	
	private UserProfile() {

	}
	
	public static UserProfile getInstance() {
		if(singleton == null) {
			singleton = new UserProfile();
		}
		
		return singleton;
	}
	
	public void setUserProfile(String userName) throws IOException {
		this.userName = userName;
		accountManager = new AccountManager();
		saveManager = new SavedGameManager();
		Init(userName);
	}
	
	private void Init(String userName) throws IOException{
		Account currentUser = getCurrentUser(userName);
		List<SavedGame> savedGames = getSavedGamesByUser(currentUser.getUserName());
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
=======
>>>>>>> Stashed changes

    private static UserProfile singleton = null;
    private AccountManager accountManager;
    private SavedGameManager saveManager;
    private HighScoreDatabase scoreDatabase;

    // Insert Unlocked Levels

    public UserProfile() {

    }

    public UserProfile(String userName) throws IOException {
	accountManager = new AccountManager();
	saveManager = new SavedGameManager();
	Init(userName);
    }

    public static UserProfile getInstance() {
	if (singleton == null) {
	    singleton = new UserProfile();
	}

	return singleton;
    }

    private void Init(String userName) throws IOException {
	List<Account> allAccounts = getAllUserAccounts();
	Account currentUser = getCurrentUser(userName);
	List<SavedGame> savedGames = getSavedGamesByUser(currentUser.getUserName());
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

    public AccountManager getAccountManager() {
	return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
	this.accountManager = accountManager;
    }

    public SavedGameManager getSaveManager() {
	return saveManager;
    }

    public void setSaveManager(SavedGameManager saveManager) {
	this.saveManager = saveManager;
    }

}
