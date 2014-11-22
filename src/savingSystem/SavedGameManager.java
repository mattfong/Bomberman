package savingSystem;

import gameplay.GameFrame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedGameManager {
	
	private List<SavedGame> savedGamesList = new ArrayList<SavedGame>();
	
	public SavedGameManager() {
		super();
	}

	public List<SavedGame> getSavedGamesList() {
		return savedGamesList;
	}

	public void setSavedGamesList(List<SavedGame> savedGamesList) {
		this.savedGamesList = savedGamesList;
	}

	public void addSavedGame(String savedGameName){
		SavedGame savedGame = new SavedGame();
		savedGame.setSavedGameName(savedGameName);
		savedGamesList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
	}
	
	public void removeSavedGame(String userName, String removeSavedGame){
		for(int i=0; i<savedGamesList.size(); i++){
			SavedGame savedGame = savedGamesList.get(i);
			if(savedGame.getSavedGameName().equals(removeSavedGame)){
				savedGamesList.remove(i);
			}
		}
	}
	
	public List<SavedGame> getSavedGameByUser(String userName){
		List<SavedGame> gameList = null;
		SavedGame savedGame = new SavedGame();
		gameList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
		/*for(int i=0; i<savedGames.size(); i++){
			if(savedGames.get(i).getUserName().equals(userName)){
				gameList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
			}
		}*/
		return gameList;
	}
	
	public void newOperation(){
	//	GameFrame gameplay=new GameFrame();
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
	
}
