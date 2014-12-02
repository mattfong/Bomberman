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

/**
 * Can access all the information such as account information, saved games,
 * highscores after the user has loginned in.
 * 
 * @author Kirththiga Murugupillai
 *
 */

public class UserProfile {

    private static UserProfile singleton = null;
    private String userName;
    private AccountManager accountManager;
    private SavedGameManager saveManager;
    private HighScoreDatabase scoreDatabase;
    private List<SavedGame> savedGames;

    private UserProfile() {

    }

    public static UserProfile getInstance() {
	if (singleton == null) {
	    singleton = new UserProfile();
	}

	return singleton;
    }

    /**
     * This method sets the userProfile when the user logins, so that all their
     * information can be collected and used throughout the transition.
     * 
     * @param userName
     * @throws IOException
     */
    public void setUserProfile(String userName) throws IOException {
	this.userName = userName;
	accountManager = new AccountManager();
	saveManager = new SavedGameManager();
	Init(userName);
    }

    /**
     * This method collects all the data that has been stored in files.
     * 
     * @param userName
     * @throws IOException
     */
    private void Init(String userName) throws IOException {
	CSVreader reader = new CSVreader();
	accountManager.setAccounts(reader.CSVreaderAccounts("UserPass.csv"));
	Account currentUser = getCurrentUser(userName);
	savedGames = getSavedGamesByUser(currentUser.getUserName());
	saveManager.setSavedGamesList(savedGames);
	setSaveManager(saveManager);
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public List<SavedGame> getSavedGames() {
	return savedGames;
    }

    public void setSavedGames(List<SavedGame> savedGames) {
	this.savedGames = savedGames;
    }

    private Account getCurrentUser(String userName) {
	Account currentAccount = accountManager.getAccount(userName);
	return currentAccount;
    }

    /**
     * The method gets the user's serialized file, and returns the list of saved
     * games.
     * 
     * @param userName
     * @return a list of saved games for the current user
     * @throws IOException
     */
    private List<SavedGame> getSavedGamesByUser(String userName) throws IOException {
	String fileName = saveManager.getSaveGameFile(userName);
	SavedGameSerialization serializeGame = new SavedGameSerialization();
	List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);
	saveManager.setSavedGamesList(allSavedGames);
	return saveManager.getSavedGamesList();
    }

    @Override
    public String toString() {
	return "UserProfile [userName=" + userName + ", accountManager=" + accountManager + ", saveManager=" + saveManager + ", scoreDatabase=" + scoreDatabase + ", savedGames=" + savedGames + "]";
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
