package savingSystem;

import gameplay.GameFrame;

import java.util.ArrayList;
import java.util.List;

public class SavedGameManager {
	
	private List<SavedGame> savedGames = new ArrayList<SavedGame>();
	private SavedGame savedGame = new SavedGame();
	
	
	public SavedGameManager() {
		super();
	}

	public List<SavedGame> addSavedGame(String savedGameName){
		savedGame.setSavedGameName(savedGameName);
		savedGames.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
//		savedGames.add(new SavedGame(null,"Ann", savedGameName));
		return savedGames;
	}
	
	public void removeSavedGame(String userName, String removeSavedGame){
		for(int i=0; i<savedGames.size(); i++){
			if(savedGames.get(i).getUserName().equals(userName)){
				if(savedGames.get(i).getSavedGameName().equals(removeSavedGame)){
					savedGames.remove(i);
				}
			}
		}
	}
	
	public List<SavedGame> getSavedGameByUser(String userName){
		List<SavedGame> gameList = null;
		gameList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
		/*for(int i=0; i<savedGames.size(); i++){
			if(savedGames.get(i).getUserName().equals(userName)){
				gameList.add(new SavedGame(savedGame.getGameState(), savedGame.getUserName(), savedGame.getSavedGameName()));
			}
		}*/
		return gameList;
	}
	
	public void newOperation(){
		GameFrame gameplay=new GameFrame();
	}
}
