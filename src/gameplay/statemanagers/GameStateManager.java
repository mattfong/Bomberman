package gameplay.statemanagers;

import gameplay.input.InputListener;

public class GameStateManager {

	private static GameStateManager singleton=null;
	private static GameState currentGameState;
	
	protected GameStateManager() {
	}
    
	public void setCurrentGameState(GameState state){
		currentGameState=state;
	}
	
	public GameState getCurrentGameState(){
		return currentGameState;
	}
	
	public static GameStateManager getInstance() {
	if (singleton == null) {
	    singleton = new GameStateManager();
	}
	return singleton;
    }
	
	
}
