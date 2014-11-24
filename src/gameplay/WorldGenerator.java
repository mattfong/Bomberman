package gameplay;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.blocks.Background;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Wall;
import gameplay.gameobject.powerups.DetonatorPowerup;
import gameplay.gameobject.powerups.Door;

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

    public WorldGenerator(World world, int gridWidth, int gridHeight) {
	this.world = world;
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;

    }

    /**
     * Created a game grid populated with the GameObjects specifies in the level
     * generation
     *
     * @return a fully populated grid.
     */
    public Stack<GameObject>[][] generateGameGrid() {
	Stack<GameObject>[][] grid;
	grid = new Stack[gridWidth][gridHeight];
	populateGrid(grid);
	return grid;
    }

    private void populateGrid(Stack<GameObject>[][] grid) {
	initStack(grid);
	fillBackground(grid);
	concreteFill(grid);
	placeBricks(grid);
	clearTopLeftCorner(grid);
	// placePowerup(grid);
	addGameObject(new Background(new Rectangle(32, 32, 32, 32), world), grid);
	addGameObject(new DetonatorPowerup(new Rectangle(3 * 32, 4 * 32, 32, 32), world), grid);
	addGameObject(new Door(new Rectangle(3 * 32, 6 * 32, 32, 32), world), grid);
    }

    private void placeEnemie(GameActor enemy) {

    }

    private void initStack(Stack<GameObject>[][] grid) {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		grid[i][j] = new Stack<GameObject>();
	    }
	}
    }

    private void fillBackground(Stack<GameObject>[][] grid) {
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		addGameObject(new Background(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world), grid);
	    }
	}
    }

    private void concreteFill(Stack<GameObject>[][] grid) {
	for (int i = 0; i < gridWidth; i++) {

	    addGameObject(new Wall(new Rectangle(i * blockSize, 0 * blockSize, blockSize, blockSize), world), grid);
	    addGameObject(new Wall(new Rectangle(i * blockSize, 12 * blockSize, blockSize, blockSize), world), grid);

	    for (int j = 1; j < (gridHeight - 1); j++) {
		addGameObject(new Wall(new Rectangle(0 * blockSize, j * blockSize, blockSize, blockSize), world), grid);
		addGameObject(new Wall(new Rectangle(30 * blockSize, j * blockSize, blockSize, blockSize), world), grid);
	    }
	}

	for (int i = 0; i < gridWidth; i += 2) {
	    for (int j = 0; j < gridHeight; j += 2) {
		addGameObject(new Wall(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world), grid);
	    }
	}
    }

    private void placeBricks(Stack<GameObject>[][] grid) {

	rng = new Random();
	for (int i = 0; i < gridWidth; i++) {
	    for (int j = 0; j < gridHeight; j++) {
		if (!(grid[i][j].peek() instanceof Wall) && (rng.nextInt(100) >= (100 - probabilityConstant))) {
		    addGameObject(new Brick(new Rectangle(i * blockSize, j * blockSize, blockSize, blockSize), world), grid);
		}
	    }
	}

    }

    private void clearTopLeftCorner(Stack<GameObject>[][] grid) {
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
    private void placePowerup(Stack<GameObject>[][] grid) {
	// TODO: IMPLEMENT THIS
    }

    private void addGameObject(GameObject gameObject, Stack<GameObject>[][] grid) {
	int xIndex;
	int yIndex;

	xIndex = gameObject.getXCoordinate() / gameObject.getWidth();
	yIndex = gameObject.getYCoordinate() / gameObject.getHeight();

	grid[xIndex][yIndex].push(gameObject);

    }
}