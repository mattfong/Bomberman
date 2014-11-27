package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gameplay.World;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.enemies.Balloon;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class GameActorTest {
    World world;
    Bomberman bomberman;

    @Before
    public void setUp() throws Exception {
	world = new World(32, 32);
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), world);
    }

    @Test
    public void testMoveBlocked() {

	world.addGameObject(new Brick(new Rectangle(32, 64, 32, 32), world));
	world.addGameObject(new Brick(new Rectangle(64, 32, 32, 32), world));
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), world);
	bomberman.moveLeft();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(32, 32, 32, 32)));
	bomberman.moveRight();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(32, 32, 32, 32)));
	bomberman.moveUp();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(32, 32, 32, 32)));
	bomberman.moveDown();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(32, 32, 32, 32)));
    }

    @Test
    public void testMoveDown() {
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), world);
	bomberman.moveDown();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(32, 64, 32, 32)));

    }

    @Test
    public void testMoveRight() {
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), world);
	bomberman.moveRight();
	assertTrue((bomberman.getLocation()).equals(new Rectangle(64, 32, 32, 32)));

    }

    @Test
    public void testAtIntersectionTrue() {
	assertTrue(bomberman.isAtIntersection());
    }

    @Test
    public void testAtIntersectionFalse() {
	bomberman.moveRight();
	assertFalse(bomberman.isAtIntersection());
    }

    @Test
    public void testRangeToBomberman() {
	Balloon balloon = new Balloon(new Rectangle(128, 32, 32, 32), world);
	world.addGameObject(balloon);
	assertEquals(3, balloon.distanceToBomberman());
    }

    @Test
    public void testRangeToBombermanOnTop() {
	Balloon balloon = new Balloon(new Rectangle(32, 32, 32, 32), world);
	world.addGameObject(balloon);
	assertEquals(0, balloon.distanceToBomberman());
    }

    @Test
    public void testBombermanWithinRange() {

	Balloon balloon = new Balloon(new Rectangle(128, 32, 32, 32), world);
	world.addGameObject(balloon);
	assertTrue(balloon.bombermanWithinRange(3));

    }

    @Test
    public void testDeathByFire() {
	Explosion explosion = new Explosion(new Rectangle(64, 32, 32, 32), world, 10);
	world.addGameObject(explosion);
	Balloon balloon = new Balloon(new Rectangle(64, 32, 32, 32), world);

	GameStateManager manager;
	manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(100));
	balloon.update();
	assertTrue(balloon.checkIfBombed());

    }
}
