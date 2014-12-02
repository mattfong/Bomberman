package gameplay.gameobject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.blocks.Bomb;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Explosion;
import gameplay.gameobject.bomberman.Bomberman;
import gameplay.gameobject.enemies.Balloon;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.Direction;
import gameplay.world.Level;
import gameplay.world.World;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class GameActorTest {
    World world;
    Bomberman bomberman;

    @Before
    public void setUp() throws Exception {
	world = new World(32, 32, Level.L1);
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

    // @Test
    // public void testRangeToBomberman() {
    // Balloon balloon = new Balloon(new Rectangle(128, 32, 32, 32), world);
    // world.addGameObject(balloon);
    // assertEquals(3, balloon.distanceToBomberman());
    // }
    //
    // @Test
    // public void testRangeToBombermanOnTop() {
    // Balloon balloon = new Balloon(new Rectangle(32, 32, 32, 32), world);
    // world.addGameObject(balloon);
    // assertEquals(0, balloon.distanceToBomberman());
    // }

    // @Test
    // public void testBombermanWithinRange() {
    //
    // Balloon balloon = new Balloon(new Rectangle(128, 32, 32, 32), world);
    // world.addGameObject(balloon);
    // assertTrue(balloon.bombermanWithinRange(3));
    //
    // }

    @Test
    public void testDeathByFire() {
	Explosion explosion = new Explosion(new Rectangle(64, 32, 32, 32), world, 10);
	world.addGameObject(explosion);
	Balloon balloon = new Balloon(new Rectangle(64, 32, 32, 32), world);

	GameStateManager manager;
	manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(100));
	balloon.update();
	assertTrue(balloon.isDead());

    }

    @Test
    public void testCanMoveThrough() {
	GameActor actor = new Balloon(new Rectangle(32, 32, 32, 32), world);

	assertTrue(actor.canMove(Direction.RIGHT));
	assertTrue(actor.canMove(Direction.DOWN));

    }

    @Test
    public void testCannotMoveThrough() {
	GameActor actor = new Balloon(new Rectangle(32, 32, 32, 32), world);
	assertFalse(actor.canMove(Direction.LEFT));
	assertFalse(actor.canMove(Direction.UP));
	// place bomb and check it can't be moved through
	world.addGameObject(new Bomb(new Rectangle(64, 32, 32, 32), world, 10));
	assertFalse(actor.canMove(Direction.RIGHT));
    }
}
