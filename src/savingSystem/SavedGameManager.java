package savingSystem;

import gameplay.GameFrame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedGameManager {
	
	private static SavedGameManager singleton = null;
	private List<SavedGame> savedGamesList = new ArrayList<SavedGame>();
	
	public SavedGameManager() {
		super();
	}
	
	public static SavedGameManager getInstance() {
		if(singleton == null) {
			singleton = new SavedGameManager();
		}
		return singleton;
	}

	public List<SavedGame> getSavedGamesList() {
		return savedGamesList;
	}

	public void setSavedGamesList(List<SavedGame> savedGamesList) {
		this.savedGamesList = savedGamesList;
	}

	public SavedGame addSavedGame(String savedGameName){
		SavedGame currentSavedGame = new SavedGame();
		currentSavedGame.setSavedGameName(savedGameName);
		savedGamesList.add(new SavedGame(currentSavedGame.getGameState(), currentSavedGame.getUserName(), currentSavedGame.getSavedGameName()));
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
	
	public List<SavedGame> getSavedGameByUser(String userName){
		List<SavedGame> gameList = null;
		
		for(int i=0; i<numberOfSavedGames(); i++){
			SavedGame savedGame = savedGamesList.get(i);
			if(savedGame.getUserName().equals(userName)){
				gameList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
			}
		}
		
		return gameList;
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
