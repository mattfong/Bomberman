package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import gameplay.gameobject.blocks.Background;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Minvo;
import gameplay.gameobject.enemies.Oneal;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameStateManagerTest {
    private World world;
    private GameStateManager manager;

    // set up a blank world to test on
    @Before
    public void setUp() throws Exception {
	world = new World(31, 15, Level.L1);
	Stack<GameObject>[][] grid = world.grid;
	manager = GameStateManager.getInstance();
	for (int i = 0; i < 31; i++) {
	    for (int j = 0; j < 15; j++) {
		if (!(grid[i][j].peek() instanceof Background)) {
		    grid[i][j].pop();
		}
	    }
	}
	world.getActorList().clear(); // getActorList returns a reference to the
				      // list, thus clearing it should also clea
				      // rit in the game.

    }

    @After
    public void tearDown() {
	manager.setCurrentGameState(new GameState()); // reset the score each
						      // time
    }

    @Test
    public void testSingleScoreAdd() {

	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));
	manager.openScorePoll();
	actor1.update();
	world.update();
	manager.closeScorePoll();
	assertEquals(100, manager.getScore());

    }

    @Test
    public void testDoubleScoreAdd() {

	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	GameActor actor2 = new Balloon(new Rectangle(96, 64, 32, 32), world);

	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));
	world.addGameObject(new Explosion(new Rectangle(96, 64, 32, 32), world, 1));
	manager.openScorePoll();

	actor1.update();
	actor2.update();
	world.update();

	manager.closeScorePoll();

	assertEquals(300, manager.getScore());

    }

    @Test
    public void testMobsOnTop() {
	// test to see what happens when two mobs die on top of each other
	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	GameActor actor2 = new Balloon(new Rectangle(96, 96, 32, 32), world);

	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));
	manager.openScorePoll();

	actor1.update();
	actor2.update();
	world.update();

	manager.closeScorePoll();

	assertEquals(300, manager.getScore());

    }

    @Test
    public void testKilledAfter() {
	// test to make sure mobs killed at different times don't add to each
	// other scores
	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	GameActor actor2 = new Balloon(new Rectangle(32, 32, 32, 32), world);

	// blow up first mob
	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));

	manager.openScorePoll();
	actor1.update();
	world.update();
	manager.closeScorePoll();

	// blow up second mob
	world.addGameObject(new Explosion(new Rectangle(32, 32, 32, 32), world, 1));

	manager.openScorePoll();
	actor2.update();
	world.update();
	manager.closeScorePoll();

	assertEquals(200, manager.getScore());

    }

    @Test
    public void testDifferentKills() {

	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	GameActor actor2 = new Oneal(new Rectangle(96, 64, 32, 32), world);

	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));
	world.addGameObject(new Explosion(new Rectangle(96, 64, 32, 32), world, 1));
	manager.openScorePoll();

	actor1.update();
	actor2.update();
	world.update();

	manager.closeScorePoll();

	assertEquals(500, manager.getScore());

    }

    @Test
    public void testTrippleKill() {

	GameActor actor1 = new Balloon(new Rectangle(96, 96, 32, 32), world);
	GameActor actor2 = new Oneal(new Rectangle(96, 128, 32, 32), world);
	GameActor actor3 = new Minvo(new Rectangle(96, 160, 32, 32), world);

	world.addGameObject(new Explosion(new Rectangle(96, 96, 32, 32), world, 1));
	world.addGameObject(new Explosion(new Rectangle(96, 128, 32, 32), world, 1));
	world.addGameObject(new Explosion(new Rectangle(96, 160, 32, 32), world, 1));
	manager.openScorePoll();

	actor1.update();
	actor2.update();
	actor3.update();
	world.update();

	manager.closeScorePoll();

	assertEquals(2900, manager.getScore());

    }
}
