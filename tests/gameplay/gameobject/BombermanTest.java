package gameplay.gameobject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gameplay.gameobject.blocks.Bomb;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.bomberman.Bomberman;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.Direction;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BombermanTest {

    private World world;
    private Bomberman bomberman;

    @Before
    public void setUp() throws Exception {
	world = new World(31, 15,Level.L1);
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), world);
	GameStateManager manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(100));
    }

    @Test
    public void testBombPass() {
	world.addGameObject(new Bomb(new Rectangle(64, 32, 32, 32), world, 10));
	bomberman.setBombPass(true);
	assertTrue(bomberman.canMove(Direction.RIGHT));
    }

    @Test
    public void testPlaceBombSuccessful() {
	bomberman.placeBomb();
	Stack<GameObject>[][] grid = world.grid;
	assertTrue(grid[1][1].peek() instanceof Bomb);
    }

    @Test
    public void testMultipleBombPlacement() {
	bomberman.placeBomb();
	bomberman.placeBomb();
	Stack<GameObject>[][] grid = world.grid;
	grid[1][1].pop();
	assertFalse(grid[1][1].peek() instanceof Bomb);
    }

    @Test
    public void testDetonateWithoutDetonator() {
	bomberman.placeBomb();
	bomberman.detonateBomb();
	Stack<GameObject>[][] grid = world.grid;
	assertTrue(grid[1][1].peek() instanceof Bomb);
    }

    @Test
    public void testDetonateWithDetonator() {
	bomberman.placeBomb();
	bomberman.setDetonator(true);
	bomberman.detonateBomb();
	Stack<GameObject>[][] grid = world.grid;
	assertFalse(grid[1][1].peek() instanceof Bomb);
    }

    @Test
    public void testCheckDeathByBomb() {
	world.addGameObject(new Bomb(new Rectangle(64, 32, 32, 32), world, 1));

	for (int i = 0; i < 41; i++) {
	    world.update();
	    bomberman.update();
	}

    }

    @Test
    public void testCheckIfCanTakeTheHeat() {

	world.addGameObject(new Explosion(new Rectangle(32, 32, 32, 32), world, 1));
	bomberman.update();

	System.out.println(bomberman.isDead());
	assertFalse(bomberman.isDead());

    }

    @After
    public void tearDown() {
	Bomb.resetBombList();
    }

}
