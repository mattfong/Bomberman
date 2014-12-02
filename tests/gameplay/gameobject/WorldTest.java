package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import gameplay.gameobject.blocks.Background;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.World;

import java.util.Stack;

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




    // Tests if we can cache information about level changes when they occur.
    @Test
    public void testLoadNextLevel(){
	world.loadNextLevel();
	assertEquals(Level.L2, GameStateManager.getInstance().getCurrentGameState().getLevel());
    }

}
