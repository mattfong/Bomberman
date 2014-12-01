package gameplay.gameobject;

import static org.junit.Assert.fail;
import gameplay.Level;
import gameplay.World;
import gameplay.gameobject.blocks.Background;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorldTest {
    private World world;

    @Before
    public void setUp() throws Exception {
	world = new World(31, 15, Level.L1);
	Stack<GameObject>[][] grid = world.grid;

	for (int i = 0; i < 31; i++) {
	    for (int j = 0; j < 15; j++) {
		if (!(grid[i][j].peek() instanceof Background)) {
		    grid[i][j].pop();
		}
	    }
	}

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDestroyingWalls() {

    }

    @Test
    public void testCheckForCollision() {
	fail("Not yet implemented"); // TODO
    }

}
