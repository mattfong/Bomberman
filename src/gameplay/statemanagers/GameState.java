package gameplay.statemanagers;

import gameplay.Level;
import gameplay.World;

import java.io.Serializable;

/**
 * 
 * Class which contains information relevant to the state of the current game.
 * This class contains score, remaining lives, the world and the level.
 * 
 * @author MF
 *
 */
public class GameState implements Serializable {
    private String userName;
    private String playerName;
    private Level level;
    private World world;
    private int score;
    private int remainingLives;

    public GameState(String userName, String playerName) {
	super();
	this.userName = userName;
	this.playerName = playerName;
	this.level = Level.L1;
	remainingLives = 3;
    }

    public GameState(int score) {
	this.score = score;
	remainingLives = 3;
	world = null;
	level = Level.L1;
    }

    public GameState() {
	this.score = 0;
	remainingLives = 3;
	world = null;
	level = Level.L1;
    }

    public World getWorld() {
	return world;
    }

    public void setWorld(World world) {
	this.world = world;
    }

    public String getUserName() {
	return userName;
    }

    public void decreaseRemainingLives() {
	remainingLives--;
    }

    public String getPlayerName() {
	return playerName;
    }

    public int getScore() {
	return score;
    }

    public int getRemainingLives() {
	return remainingLives;
    }

    public void setRemainingLives(int remainingLives) {
	this.remainingLives = remainingLives;
    }

    public Level getLevel() {
	return level;
    }

    public void increaseScoreBy(int scoreToAdd) {
	this.score += scoreToAdd;
    }

    public void setLevel(Level level) {
	this.level = level;
    }
}
