package gameplay.gameobject;

import static org.junit.Assert.assertNotNull;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.world.WorldGenerator;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorldGeneratorTest {

    WorldGenerator generator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Load all levels and actor lists and tests that none of the objects in the
     * game are set to null upon first initialization.
     */
    @Test
    public void testLoadAllLevels() {
	generator = new WorldGenerator(null, 32, 32);
	GameObject testObject;

	for (Level level : Level.values()) {
	    generator.generateLevel(level);
	    ArrayList<GameActor> actorList = generator.getActorList();
	    Stack<GameObject>[][] grid = generator.getGrid();

	    for (GameActor actor : actorList) {
		assertNotNull(actor);
	    }

	    for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[i].length; j++) {
		    testObject = grid[i][j].peek();
		    assertNotNull(testObject);
		}
	    }

	}

    }
}
