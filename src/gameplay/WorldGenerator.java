package gameplay;

import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.blocks.Background;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Wall;
import gameplay.gameobject.enemies.MonsterFactory;
import gameplay.gameobject.powerups.BombPowerup;
import gameplay.gameobject.powerups.Door;
import gameplay.gameobject.powerups.Powerup;

import java.awt.Rectangle;
import java.util.ArrayList;
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
    private ArrayList<GameActor> actorList;
    private MonsterFactory factory;

    public WorldGenerator(World world, int gridWidth, int gridHeight) {
	this.world = world;
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	factory = new MonsterFactory(world);

    }

    public ArrayList<GameActor> getActorList() {
	return actorList;
    }

    public Stack<GameObject>[][] getGrid() {
	return grid;
    }

    /**
     * Generates a grid and game actor list associated with the level called on
     * generate. Once this method is called call getGrid and getActorList to
     * return the grid and list containing enemies
     * 
     * @param level
     *            the level that is to be loaded as an enum Level
     */
    public void generateLevel(Level level) {
	generateGameGrid(); // sets grid to the proper setup
	populateActors(level); // sets the ArrayList actorList to the proper
			       // setup

    }

    /**
     * Created a game grid populated with the GameObjects specifies in the level
     * generation
     *
     * @return a fully populated grid.
     */
    private void generateGameGrid() {
	grid = new Stack[gridWidth][gridHeight];
	populateGrid(grid);
	placePowerupAndDoor(grid, new BombPowerup(new Rectangle(0, 0, 32, 32), world));
    }

    private void populateActors(Level level) {

	// actorList = new ArrayList<GameActor>();
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));
	// actorList.add(new Balloon(new Rectangle(0, 0, 32, 32), world));

	actorList = factory.createClassList(level);
	placeEnemiesInEmptySpot(actorList, this.grid);

	actorList.add(new Bomberman(new Rectangle(32, 32, 32, 32), world));

    }

    private void placeEnemiesInEmptySpot(ArrayList<GameActor> enemiesList, Stack<GameObject>[][] grid) {
	ArrayList<Stack<GameObject>> emptyStacks = new ArrayList<Stack<GameObject>>();
	rng = new Random();

	for (int i = 1; i < (gridWidth - 1); i++) {
	    for (int j = 1; j < (gridHeight - 1); j++) {
		if (!(grid[i][j].peek() instanceof Brick) && !(grid[i][j].peek() instanceof Wall)) {
		    emptyStacks.add(grid[i][j]);
		}
	    }
	}
	int randomNumber;
	for (GameActor enemy : enemiesList) {
	    randomNumber = rng.nextInt(emptyStacks.size());
	    enemy.setLocation(emptyStacks.get(randomNumber).peek().getLocation());
	    emptyStacks.remove(randomNumber);

	}

    }

    private void placePowerupAndDoor(Stack<GameObject>[][] grid, Powerup powerup) {
	ArrayList<Stack<GameObject>> brickLocations = new ArrayList<Stack<GameObject>>();
	rng = new Random();

	for (int i = 1; i < (gridWidth - 1); i++) {
	    for (int j = 1; j < (gridHeight - 1); j++) {
		if (grid[i][j].peek() instanceof Brick) {
		    brickLocations.add(grid[i][j]);
		}
	    }
	}
	int randomNumber;

	Stack<GameObject> temp;
	GameObject tempObject;
	GameObject powerupObject = (GameObject) powerup;

	temp = brickLocations.get(rng.nextInt(brickLocations.size())); // get
								       // the
								       // object
								       // at the
								       // index
	tempObject = temp.pop();
	addGameObject(new Door(tempObject.getLocation(), world), grid);
	// System.out.println(tempObject.getLocation().toString()); TODO: remove
	temp.push(tempObject);

	temp = brickLocations.get(rng.nextInt(brickLocations.size()));
	tempObject = temp.pop();
	powerupObject.setLocation(tempObject.getLocation());
	// System.out.println(tempObject.getLocation().toString()); TODO: remove
	addGameObject(powerupObject, grid);
	temp.push(tempObject);

    }

    private void populateGrid(Stack<GameObject>[][] grid) {
	initStack(grid);
	fillBackground(grid);
	concreteFill(grid);
	placeBricks(grid);
	clearTopLeftCorner(grid);
	// placePowerup(grid);
	addGameObject(new Background(new Rectangle(32, 32, 32, 32), world), grid);
	// addGameObject(new DetonatorPowerup(new Rectangle(3 * 32, 4 * 32, 32,
	// 32), world), grid);
	// addGameObject(new Door(new Rectangle(3 * 32, 6 * 32, 32, 32), world),
	// grid);
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