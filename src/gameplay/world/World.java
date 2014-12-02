package gameplay.world;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.Level;
import gameplay.gameobject.blocks.Background;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.blocks.Wall;
import gameplay.gameobject.bomberman.Bomberman;
import gameplay.gameobject.powerups.Powerup;
import gameplay.overlays.CountdownTimer;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/**
 * The world class acts as the game board, it manages interactions between
 * gameactors and gameobject instances.
 * 
 * @author mfong8
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
    Level currentLevel;

    public World(int widthInBlocks, int heightInBlocks, Level level) {
	currentLevel = level;
	gridHeight = heightInBlocks;
	gridWidth = widthInBlocks;

	// store a reference to this to the GameState so it can used by
	// save/load
	// statement is this long because it avoids having to add a
	// GameStataManager as serilizable object reference
	GameStateManager manager = GameStateManager.getInstance();
	GameState state = manager.getCurrentGameState();

	// prep the world
	worldGenerator = new WorldGenerator(this, widthInBlocks, heightInBlocks);
	worldGenerator.generateLevel(level);
	grid = worldGenerator.getGrid();
	actorList = worldGenerator.getActorList();

	registerBombermanFromList(actorList); // add register bomberman to the
					      // world so that we can interact
					      // with him

	// prep the timer
	gameTimer = new CountdownTimer(this);

    }

    /**
     * @return CountdownTimer that is bounded to the world.
     */
    public CountdownTimer getTimer() {
	return gameTimer;
    }

    /**
     * @return list of GameActors operating on the game world.
     */
    public ArrayList<GameActor> getActorList() {
	return actorList;
    }

    /**
     * @return The bomberman gameActor operating on the game world.
     */
    public GameActor getBomberman() {
	return bomberman;
    }

    private void registerBombermanFromList(ArrayList<GameActor> actorList) {

	for (GameActor actor : actorList) {

	    if (actor instanceof Bomberman) {
		this.bomberman = actor;
	    }
	}
    }

    /**
     * Updates the static elements on the game World
     */
    public void update() {
	gameTimer.update();
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

    /**
     * Detonates the space specified by location, and causes explosions to
     * appear in the four directions within the given radius. Explosions
     * propegate until they hit a solid brick whic is not permeable to
     * explosions such as a brick or wall piece.
     * 
     * @param location
     *            loaction on the grid that is to be blown up
     * @param radius
     *            radius of the explosion
     */
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

	if (o instanceof Powerup) {
	    ((Powerup) o).haveBeenBombed(); // alert the powerup that someone
					    // has set it on fire
	}

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
    @Deprecated
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

    /**
     * Returns the instance of GameObject as the location specified by location.
     * 
     * @param location
     *            Rectangle representing a location on the grid
     * @return instance of gameObject at that point.
     */
    public GameObject getGameObjectInstanceAt(Rectangle location) {
	int xIndex = location.x / blockSize;
	int yIndex = location.y / blockSize;

	if (!grid[xIndex][yIndex].empty()) {
	    GameObject temp = grid[xIndex][yIndex].peek();
	    return temp;
	}

	return new Background(location, this); // returns a vanila tile that
					       // just represents the coordinate
					       // data.
    }

    @Deprecated
    public int distanceToBomberman(GameActor actor) {
	int xDistance = Math.abs(actor.getXCoordinate() - bomberman.getXCoordinate()) / blockSize;
	int yDistance = Math.abs(actor.getYCoordinate() - bomberman.getYCoordinate()) / blockSize;

	return (xDistance + yDistance);
    }

    @Deprecated
    public boolean bombermanWithin(GameActor actor, int radius) {
	int xDistance = Math.abs(actor.getXCoordinate() - bomberman.getXCoordinate()) / blockSize;
	int yDistance = Math.abs(actor.getYCoordinate() - bomberman.getYCoordinate()) / blockSize;

	if ((xDistance <= radius) || (yDistance <= radius)) {
	    return true;
	}
	return false;

    }

    /**
     * Loads the next game level.
     */
    public void loadNextLevel() {
	int levelNo = currentLevel.getLevelNumber();
	Level nextLevel;
	nextLevel = Level.getLevelByNumber(levelNo + 1);
	worldGenerator.generateLevel(currentLevel);
	grid = worldGenerator.getGrid();
	GameStateManager.getInstance().getCurrentGameState().setLevel(nextLevel);

	actorList = worldGenerator.getActorList();

	gameTimer.reset();

    }

    /**
     * Returns bomberman's location.
     * 
     * @return a rectangle which represents the location of bomberman on the
     *         game world.
     */
    public Rectangle getBombermanCoordinates() {
	return bomberman.getLocation();
    }

    public void spawnEnemies(ArrayList<GameActor> newActorList) {
	GameActor cachedBomberman = null;

	for (GameActor actor : actorList) {
	    if (actor instanceof Bomberman) {
		cachedBomberman = actor;
	    }
	}

	    actorList.clear();
	    actorList.addAll(newActorList);

	if (!(cachedBomberman == null)) {
	    actorList.add(cachedBomberman);
	}
    }
}
