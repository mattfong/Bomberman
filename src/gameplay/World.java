//TODO migrate this stuff to the board class and whereever this stupid stuff neeeds to go

package gameplay;

import gameplay.gameobject.Background;
import gameplay.gameobject.Brick;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.Wall;
import gameplay.powerups.DetonatorPowerup;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Stack;

/**
 * @author mfong8
 *
 */
public class World {

    private final int probabilityConstant = 20;

    private int gridWidth;
    private int gridHeight;
    private final int blockSize = 32;
    public Stack<GameObject>[][] grid;

    public World(int widthInBlocks, int heightInBlocks) {

	gridHeight = heightInBlocks;
	gridWidth = widthInBlocks;

	grid = new Stack[widthInBlocks][heightInBlocks];

	createGrid();

    }

    private void createGrid() {
	initStack();
	fillBackground();
	concreteFill();
	placeBricks();
	clearTopLeftCorner();
	placePowerup();
    }

    private void initStack() {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		grid[i][j] = new Stack<GameObject>();
	    }
	}
    }

    // TODO implement it so that it's placed under a random spot
    private void placePowerup() {
	Rectangle location = new Rectangle(1 * blockSize, 2 * blockSize, blockSize, blockSize);
	addGameObject(new DetonatorPowerup(location, this));

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

    Random rng = new Random();
    double percentage;

    private void placeBricks() {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (!(grid[i][j].peek() instanceof Wall) && (rng.nextInt(100) >= (100 - probabilityConstant))) {
		    addGameObject(new Brick(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), this));
		}
	    }
	}

    }

    private void clearTopLeftCorner() {
	if (grid[1][1].peek() instanceof Brick) {
	    grid[1][1].pop();
	}
	if (grid[2][1].peek() instanceof Brick) {
	    grid[2][1].pop();
	}
	if (grid[1][2].peek() instanceof Brick) {
	    grid[1][2].pop();
	}

    }

    private void concreteFill() {
	for (int i = 0; i < gridWidth; i++) {

	    addGameObject(new Wall(new Rectangle(i * blockSize, 0 * blockSize, blockSize, blockSize), this));
	    addGameObject(new Wall(new Rectangle(i * blockSize, 12 * blockSize, blockSize, blockSize), this));

	    for (int j = 1; j < (gridHeight - 1); j++) {
		addGameObject(new Wall(new Rectangle(0 * blockSize, j * blockSize, blockSize, blockSize), this));
		addGameObject(new Wall(new Rectangle(30 * blockSize, j * blockSize, blockSize, blockSize), this));
	    }
	}

	for (int i = 0; i < gridWidth; i += 2) {
	    for (int j = 0; j < gridHeight; j += 2) {
		addGameObject(new Wall(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), this));
	    }
	}
    }

    private void fillBackground() {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		addGameObject(new Background(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), this));
	    }
	}
    }

    public void removeGameObject(GameObject obj) {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (grid[i][j].peek() == obj) {
		    grid[i][j].pop();
		}
	    }
	}

    }

    public int getGridWidth() {
	return gridWidth;
    }

    public int getGridHeight() {
	return gridHeight;
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

	if ((grid[xIndex - 1][yIndex].peek() instanceof Wall) || (grid[xIndex + 1][yIndex].peek() instanceof Wall)) {
	    return false;
	}
	if ((grid[xIndex][yIndex + 1].peek() instanceof Wall) || (grid[xIndex][yIndex - 1].peek() instanceof Wall)) {
	    return false;
	}

	return true;
    }

    /**
     * @param xCoordinate
     * @param yCoordinate
     * @param direction
     * @param radius
     */
    public void detonateLine(int xCoordinate, int yCoordinate, Direction direction, int radius) {

	if (radius == 0) {
	    return;
	}

	int xIndex = (xCoordinate / 32) + direction.getX();
	int yIndex = (yCoordinate / 32) + direction.getY();

	if ((grid[xIndex][yIndex] != null) && (grid[xIndex][yIndex].peek().isDestroyable() == true)) {
	    GameObject o;
	    o = grid[xIndex][yIndex].peek();

	    if (o.conductsExplosions()) {
		detonateLine(xIndex * 32, yIndex * 32, direction, radius - 1);
	    }

	    o.destroy();

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
		if (grid[i][j].peek().isSolid()) { // TODO: Implement a way to
		    // deal with null cases,
		    // unused grid elements are
		    // set to null
		    if (grid[i][j].peek().hasCollided(object)) {
			return true;
		    }
		}

	    }
	}
	return false;
    }

}
