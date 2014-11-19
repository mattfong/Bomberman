package savingSystem;

import loginSystem.Account;

public class LoadGameMenuController {
	
	public void displayLoadGameMenu(){
		LoadGameMenuView loadMenu = new LoadGameMenuView();
		loadMenu.LoadGameMenuView();
	}
	
	public void loadGame(){
	
	}
	
	public void deleteSavedGame(){
		String userName = "";
		String removeSavedGame = "";
		SavedGameManager gameManager = new SavedGameManager();
		gameManager.removeSavedGame(userName, removeSavedGame);
	}
}
