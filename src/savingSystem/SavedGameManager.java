package savingSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public void addSavedGame(SavedGame game) {
		savedGamesList.add(game);
	}
	
	public SavedGame addSavedGameName(String savedGameName){
		SavedGame currentSavedGame = new SavedGame();
		currentSavedGame.setSavedGameName(savedGameName);
		addSavedGame(new SavedGame(currentSavedGame.getGameState(), currentSavedGame.getUserName(), currentSavedGame.getSavedGameName()));
		System.out.println("size in add: " + numberOfSavedGames());
		return currentSavedGame;
	}
	
	public void removeSavedGame(String removeSavedGame){
		for(int i=0; i<savedGamesList.size(); i++){
			SavedGame savedGame = savedGamesList.get(i);
			if(savedGame.getSavedGameName().equals(removeSavedGame)){
				savedGamesList.remove(i);
			}
		}
	}
	
	public int numberOfSavedGames(){
		return savedGamesList.size();
	}
	
	public String getSaveGameFile(String userName) throws IOException{
		String fileName = userName + "SaveGameList.ser";
		File saveFile = new File(fileName);
		
		if(saveFile.exists() == false){
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
