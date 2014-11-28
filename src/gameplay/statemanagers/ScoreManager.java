package gameplay.statemanagers;

public class ScoreManager {

    private static GameStateManager gameStateManager;
    private static ScoreManager singleton = null;

    public static ScoreManager getInstance() {
	if (singleton == null) {
	    singleton = new ScoreManager();
	}
	return singleton;
    }

    protected ScoreManager() {
	gameStateManager = GameStateManager.getInstance();
    }

    public static void addToScore(int score) {
	GameState currentGameState = gameStateManager.getCurrentGameState();
	currentGameState.increaseScoreBy(score);
    }

    public static int getScore() {
	GameState currentGameState = gameStateManager.getCurrentGameState();
	return currentGameState.getScore();
    }

}
