package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import gameplay.World;
import gameplay.gameobject.blocks.Bomb;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class BombTest {
    private World world;
    private GameStateManager manager;

    @Before
    public void setUp() {
	world = new World(31, 15);
	manager = new GameStateManager();
	manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(0));

    }

    @Test
    public void testBombCount() {

	new Bomb(new Rectangle(32, 32, 32, 32), world, 1);
	new Bomb(new Rectangle(32, 32, 32, 32), world, 1);
	new Bomb(new Rectangle(32, 32, 32, 32), world, 1);
	new Bomb(new Rectangle(32, 32, 32, 32), world, 1);

	assertEquals(4, Bomb.numberOfBombOnBoard());
    }

    @Test
    public void testDetonateBomb() {
	Bomb.resetBombList();
	new Bomb(new Rectangle(32, 32, 32, 32), world, 10);
	Bomb.detonateBomb();
	assertEquals(0, Bomb.numberOfBombOnBoard());

    }
}