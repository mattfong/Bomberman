package gameplay.statemanagers;

import gameplay.Level;
import gameplay.gameobject.GameObject;

import java.util.Stack;

public class GameState {
    private String userName;
    private String playerName;
    private Level level;

    private Stack<GameObject>[][] grid;
    private int score;
    private float timeRemaining;
    private int remainingLives;

    public GameState(String playerName, String userName){
    	
    }
    public GameState(int score){
    	this.score=score;
    	
    }
    
    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPlayerName() {
	return playerName;
    }

    public void setPlayerName(String playerName) {
	this.playerName = playerName;
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

    public void setScore(int score) {
	this.score = score;
    }

    public float getTimeRemaining() {
	return timeRemaining;
    }

    public void setTimeRemaining(float timeRemaining) {
	this.timeRemaining = timeRemaining;
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
    public void increaseScoreBy(int scoreToAdd){
    	this.score+=scoreToAdd;
    }

    public void setLevel(Level level) {
	this.level = level;
    }
}
