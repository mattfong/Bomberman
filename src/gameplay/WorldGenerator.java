package gameplay;

import gameplay.gameobject.Background;
import gameplay.gameobject.Brick;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.Wall;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Stack;

/**
 * @author mfong8 WorldGenerator's role is to take in a level configuration and
 *         generate a populated grid based on the given level specifications.
 */
public class WorldGenerator {

    private Random rng;
    private final int probabilityConstant = 20;
    private final int blockSize = 32;
    private World world;
    private int gridWidth;
    private int gridHeight;
    private Stack<GameObject>[][] grid;

    public WorldGenerator(World world, int gridWidth, int gridHeight) {
	this.world = world;
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	grid = new Stack[gridWidth][gridHeight];
    }

    /**
     * Created a game grid populated with the GameObjects specifies in the level
     * generation
     *
     * @return a fully populated grid.
     */
    public Stack<GameObject>[][] generateGameGrid() {
	populateGrid();
	return grid;
    }

    private void populateGrid() {
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

    private void fillBackground() {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		addGameObject(new Background(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world));
	    }
	}
    }

    private void concreteFill() {
	for (int i = 0; i < gridWidth; i++) {

	    addGameObject(new Wall(new Rectangle(i * blockSize, 0 * blockSize, blockSize, blockSize), world));
	    addGameObject(new Wall(new Rectangle(i * blockSize, 12 * blockSize, blockSize, blockSize), world));

	    for (int j = 1; j < (gridHeight - 1); j++) {
		addGameObject(new Wall(new Rectangle(0 * blockSize, j * blockSize, blockSize, blockSize), world));
		addGameObject(new Wall(new Rectangle(30 * blockSize, j * blockSize, blockSize, blockSize), world));
	    }
	}

	for (int i = 0; i < gridWidth; i += 2) {
	    for (int j = 0; j < gridHeight; j += 2) {
		addGameObject(new Wall(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world));
	    }
	}
    }

    private void placeBricks() {

	rng = new Random();
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (!(grid[i][j].peek() instanceof Wall) && (rng.nextInt(100) >= (100 - probabilityConstant))) {
		    addGameObject(new Brick(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world));
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

    // TODO implement it so that it's placed under a random spot
    private void placePowerup() {
	// TODO: IMPLEMENT THIS
    }

    private void addGameObject(GameObject gameObject) {
	int xIndex;
	int yIndex;

	xIndex = gameObject.getXCoordinate() / gameObject.getWidth();
	yIndex = gameObject.getYCoordinate() / gameObject.getHeight();

	grid[xIndex][yIndex].push(gameObject);

    }
}