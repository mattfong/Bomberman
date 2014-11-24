package gameplay.statemanagers;

import gameplay.enums.Level;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;

import java.util.ArrayList;
import java.util.Stack;

public class GameState {
    private String userName;
    private String playerName;

    private Stack<GameObject>[][] grid;
    private int score;
    private int remainingLives;
    private Level level;
    private ArrayList<GameActor> actorList;

    public GameState(String playerName, String userName) {

    }

    public GameState(int score) {
	this.score = score;
	remainingLives = 3;
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

    public Stack<GameObject>[][] getGrid() {
	return grid;
    }

    public void setGrid(Stack<GameObject>[][] grid) {
	this.grid = grid;
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

    public void setLevel(Level level) {
	this.level = level;
    }

    public void increaseScoreBy(int scoreToAdd) {
	this.score += scoreToAdd;
    }

}
