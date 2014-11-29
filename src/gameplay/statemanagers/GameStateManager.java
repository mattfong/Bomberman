package gameplay.statemanagers;

import gameplay.GamePanel;
import gameplay.World;

public class GameStateManager {

    private static GameStateManager singleton = null;
    private GameState currentGameState;
    private GamePanel gamePanel;

    private GameStateManager() {

    }

    public void setCurrentGameState(GameState state) {
	currentGameState = state;
    }

    public void registerGamePanel(GamePanel panel) {
	this.gamePanel = panel;
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

    public World getCurrentWorld() {
	return gamePanel.getWorld();

    }

}
