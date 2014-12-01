package gameplay.statemanagers;

import gameplay.engine.GamePanel;
import gameplay.world.World;

import java.util.ArrayList;

/**
 * Singleton wrapper for accessing and modifying the a gamestate from anywhere
 * in the system.
 * 
 * 
 * @author MF
 *
 */
public class GameStateManager {

    private static GameStateManager singleton = null;
    private GameState currentGameState;
    private GamePanel gamePanel;
    private ArrayList<Integer> scoreValues = new ArrayList<Integer>();

    private GameStateManager() {

    }

    public void setCurrentGameState(GameState state) {
	currentGameState = state;
    }

    public void registerGamePanel(GamePanel panel) {
	this.gamePanel = panel;
    }

    public GameState getCurrentGameState() {
	if (currentGameState == null) {
	    currentGameState = new GameState();
	    return currentGameState;
	}
	return currentGameState;

    }

    public static GameStateManager getInstance() {
	if (singleton == null) {
	    singleton = new GameStateManager();
	}
	return singleton;

    }

    public void increaseScore(int score) {
	scoreValues.add(score);
    }

    public int getScore() {
	return currentGameState.getScore();
    }

    public World getCurrentWorld() {
	return gamePanel.getWorld();

    }

    /**
     * Method to be called at the begining of each "round" at the begining of
     * the game update.
     */
    public void openScorePoll() {
	scoreValues.clear();
    }

    /**
     * Method to be called at the end of each "round" at the end of each game
     * update.
     */
    public void closeScorePoll() {
	int counter = 1;
	int scoreWithMultiplier;
	for (Integer scores : scoreValues) {
	    scoreWithMultiplier = scores * counter;
	    currentGameState.increaseScoreBy(scoreWithMultiplier);
	    counter++;
	}
    }

}
