//TODO migrate this stuff to the board class and whereever this stupid stuff neeeds to go

package gameplay;

import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.blocks.Background;
import gameplay.gameobject.blocks.Bomb;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.blocks.Wall;
import gameplay.overlays.CountdownTimer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author mfong8
 *
 */
/**
 * @author MF
 *
 */
public class World implements Serializable {

    CountdownTimer gameTimer;
    private int gridWidth;
    private int gridHeight;
    private final int blockSize = 32;
    public Stack<GameObject>[][] grid;
    WorldGenerator worldGenerator;
    private final int explosionLength = 10;
    GameActor bomberman;
    ArrayList<GameActor> actorList;

    public World(int widthInBlocks, int heightInBlocks) {

	gridHeight = heightInBlocks;
	gridWidth = widthInBlocks;

	// prep the world
	worldGenerator = new WorldGenerator(this, widthInBlocks, heightInBlocks);
	worldGenerator.generateLevel(Level.L11);
	grid = worldGenerator.getGrid();
	actorList = worldGenerator.getActorList();

	registerBomberman(actorList); // add register bomberman to the world so
	// that we can interact wit him

	// prep the timer
	gameTimer = new CountdownTimer();
	gameTimer.registerOntoWorld(this);

    }

    public CountdownTimer getTimer() {
	return gameTimer;
    }

    public ArrayList<GameActor> getActorList() {
	return actorList;
    }

    public GameActor getBomberman() {
	return bomberman;
    }

    private void registerBomberman(ArrayList<GameActor> actorList) {

	for (GameActor actor : actorList) {

	    if (actor instanceof Bomberman) {
		this.bomberman = actor;
	    }
	}
    }

    public void update() {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (!(grid[i][j].empty())) {
		    grid[i][j].peek().update();
		}
	    }
	}
    }

    /**
     * draw method which draws the gameworld onto a Graphics object that is
     * later rendered.
     *
     * @param g
     *            graphics object to be drawn on.
     */
    public void draw(Graphics g) {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (!grid[i][j].empty()) {
		    grid[i][j].peek().draw(g);
		}
	    }
	}
    }

    /**
     * takes in a gameobject and places it on the grid at the location specified
     * by the object itself.
     *
     * @param gameObject
     *            object that is to be added to the game world.
     */
    public void addGameObject(GameObject gameObject) {
	int xIndex;
	int yIndex;

	xIndex = gameObject.getXCoordinate() / gameObject.getWidth();
	yIndex = gameObject.getYCoordinate() / gameObject.getHeight();

	grid[xIndex][yIndex].push(gameObject);

    }

    /**
     * remove the specified gameobject from the world. Object specified must be
     * the specific instance that is to be removed and not an equivalent one.
     *
     * @param obj
     *            the game object that is to be add to the game world.
     */
    public void removeGameObject(GameObject obj) {

	if (obj != null) {
	    for (int i = 0; i < gridWidth; i++) {
		for (int j = 0; j < gridHeight; j++) {
		    if (grid[i][j].peek() == obj) {
			grid[i][j].pop();
		    }
		}
	    }
	}
    }

    /**
     * @param location
     *            rectangle representing a location on the game grid
     * @return returns true if the rectangle is at an intersection of walls,
     *         returns false if it's not at an intersection of walls
     */
    public boolean isIntersection(Rectangle location) {
	int xIndex;
	int yIndex;

	xIndex = location.x / blockSize;
	yIndex = location.y / blockSize;

	if ((grid[xIndex - 1][yIndex].peek() instanceof Wall) && (grid[xIndex + 1][yIndex].peek() instanceof Wall)) {
	    return false;
	}
	if ((grid[xIndex][yIndex + 1].peek() instanceof Wall) && (grid[xIndex][yIndex - 1].peek() instanceof Wall)) {
	    return false;
	}

	return true;
    }

    public void detonateLocation(Rectangle location, int radius) {
	addGameObject(new Explosion(location, this, explosionLength));
	for (Direction dir : Direction.values()) {
	    detonateLine(location, dir, radius);
	}
    }

    private void detonateLine(Rectangle location, Direction direction, int radius) {

	if (radius == 0) {
	    return;
	}

	int xIndex = (location.x / 32) + direction.getX();
	int yIndex = (location.y / 32) + direction.getY();

	GameObject o = grid[xIndex][yIndex].peek();

	if (o.conductsExplosions()) {
	    addGameObject(new Explosion(new Rectangle(xIndex * 32, yIndex * 32, 32, 32), this, explosionLength));
	    detonateLine(new Rectangle(xIndex * 32, yIndex * 32, 32, 32), direction, radius - 1);
	    if (o.isDestroyable()) {
		o.destroy();
	    } else if (!o.isDestroyable()) {
		return;
	    }

	} else if (!o.conductsExplosions()) {
	    if (o.isDestroyable()) {
		o.destroy();
	    } else if (!o.isDestroyable()) {
		return;
	    }
	}

    }

    /**
     * checks if the given GameObject object has collided with any other
     * GameObject on the board
     *
     * @param object
     *            GameObject that is being checked if has collided with
     *            something.
     * @return true if the object has collided with another GameObject, false if
     *         it has not.
     */
    public boolean checkForCollision(GameObject object) {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (grid[i][j].peek().isSolid()) {
		    if (grid[i][j].peek().hasCollided(object)) {
			return true;
		    }
		}

	    }
	}
	return false;
    }

    /**
     * Checks a given direction relative to a GameActor to see if the GameActor
     * is able to move onto that space.
     *
     * @param actor
     *            GameActor that is going to be moving
     * @param direction
     *            direction that in which the actor wants to move
     * @return true if the direction is blocked, false if the direction is free
     *         to pass through.
     */
    public boolean willCollide(GameActor actor, Direction direction) {
	int indexX = (actor.getXCoordinate() / blockSize) + direction.getX();
	int indexY = (actor.getYCoordinate() / blockSize) - direction.getY();

	GameObject objectToCheck = grid[indexX][indexY].peek();

	boolean bool = actor.canPassThrough(objectToCheck);
	return (!bool);
    }

    public GameObject getGameObjectInstanceAt(Rectangle location) {
	int xIndex = location.x / blockSize;
	int yIndex = location.y / blockSize;

	if (!grid[xIndex][yIndex].empty()) {
	    GameObject temp = grid[xIndex][yIndex].peek();
	    return temp;
	}
	return new Background(location, this);
    }

    @Deprecated
    public int numberOfBombsOnMap() {
	int numberOfBombs = 0;
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (grid[i][j].peek() instanceof Bomb) {
		    numberOfBombs++;
		}
	    }
	}
	return numberOfBombs;
    }

    public int distanceToBomberman(GameActor actor) {
	int xDistance = Math.abs(actor.getXCoordinate() - bomberman.getXCoordinate()) / blockSize;
	int yDistance = Math.abs(actor.getYCoordinate() - bomberman.getYCoordinate()) / blockSize;

	return (xDistance + yDistance);
    }

    public boolean bombermanWithin(GameActor actor, int radius) {
	int xDistance = Math.abs(actor.getXCoordinate() - bomberman.getXCoordinate()) / blockSize;
	int yDistance = Math.abs(actor.getYCoordinate() - bomberman.getYCoordinate()) / blockSize;

	if ((xDistance <= radius) || (yDistance <= radius)) {
	    return true;
	}
	return false;

    }

    public void loadNextLevel() {
	worldGenerator.generateLevel(Level.L1);
	grid = worldGenerator.getGrid();
	actorList = worldGenerator.getActorList();
	gameTimer.reset();

    }

    public Rectangle getBombermanCoordinates() {
	return bomberman.getLocation();
    }
}
