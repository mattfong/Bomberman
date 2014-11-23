package savingSystem;

public class SaveGameMenuController {
	
	public void displaySavedGameMenu(){
		SaveGameMenuView saveMenu = new SaveGameMenuView();
		saveMenu.SaveGameMenuView();
	}
	
	public void saveGame(){
		SavedGame saveGame = new SavedGame();
	}
}
