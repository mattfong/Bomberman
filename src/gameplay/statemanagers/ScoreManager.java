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
    }

    public static void addToScore(int score) {
	GameState currentGameState = GameStateManager.getCurrentGameState();
	currentGameState.increaseScoreBy(score);
    }

    public static int getScore() {
	GameState currentGameState = GameStateManager.getCurrentGameState();
	return currentGameState.getScore();
    }

    public static void calculateScore() {

    }

}
