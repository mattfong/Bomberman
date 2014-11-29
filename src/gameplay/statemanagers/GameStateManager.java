package gameplay.statemanagers;

public class GameStateManager {

    private static GameStateManager singleton = null;
    private GameState currentGameState;

    private GameStateManager() {

    }

    public void setCurrentGameState(GameState state) {
	currentGameState = state;
    }

    public GameState getCurrentGameState() {
	return currentGameState;
    }

    public static GameStateManager getInstance() {
	if (singleton == null) {
	    singleton = new GameStateManager();
	}
	return singleton;
    }

    public void increaseScore(int score) {
	currentGameState.increaseScoreBy(score);
    }

    public int getScore() {
	return currentGameState.getScore();
    }

}
