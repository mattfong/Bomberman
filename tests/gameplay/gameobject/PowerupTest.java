package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.bomberman.Bomberman;
import gameplay.gameobject.powerups.BombPassPowerup;
import gameplay.gameobject.powerups.BombPowerup;
import gameplay.gameobject.powerups.DetonatorPowerup;
import gameplay.gameobject.powerups.FlamePassPowerup;
import gameplay.gameobject.powerups.FlamePowerup;
import gameplay.gameobject.powerups.Powerup;
import gameplay.gameobject.powerups.SpeedPowerup;
import gameplay.gameobject.powerups.WallPassPowerup;
import gameplay.input.InputListener;
import gameplay.world.Level;
import gameplay.world.World;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class PowerupTest {
    Bomberman bomberman;
    World world;

    @Before
    public void setUp() throws Exception {
	bomberman = new Bomberman(new Rectangle(32, 32, 32, 32), null);
    }

    @Test
    public void testBombPassPowerup() {
	Powerup power;
	power = new BombPassPowerup(null, null);
	power.applyPowerup(bomberman);
	assertTrue(bomberman.canBombPass());

    }

    @Test
    public void testBombPowerup() {
	Powerup power;
	power = new BombPowerup(null, null);
	power.applyPowerup(bomberman);
	assertEquals(2, bomberman.getBombLimit());
    }

    @Test
    public void testDetonatorPowerup() {
	Powerup power;
	power = new DetonatorPowerup(null, null);
	power.applyPowerup(bomberman);
	assertTrue(bomberman.canDetonateBomb());
    }

    @Test
    public void testFlamePassPowerup() {
	Powerup power;
	power = new FlamePassPowerup(null, null);
	power.applyPowerup(bomberman);
	assertTrue(bomberman.canTakeTheHeat());
    }

    @Test
    public void testFlamePowerup() {
	Powerup power;
	power = new FlamePowerup(null, null);
	power.applyPowerup(bomberman);
	assertEquals(2, bomberman.getBombRadius());
    }

    @Test
    public void testSpeedPowerup() {
	Powerup power;
	power = new SpeedPowerup(null, null);
	power.applyPowerup(bomberman);
	InputListener listener = InputListener.getInstance();
    }

    @Test
    public void testWallPassPowerup() {
	Powerup power;
	power = new WallPassPowerup(null, null);
	power.applyPowerup(bomberman);
	assertTrue(bomberman.canPassThrough(new Brick(null, null)));

    }

    @Test
    public void testHaveBeenBombed() {
	world = new World(31, 13, Level.L1);
	world.addGameObject(new DetonatorPowerup(new Rectangle(32, 32, 32, 32), world));
	world.detonateLocation(new Rectangle(64, 32, 32, 32), 1);
	assertEquals(6, world.getActorList().size());

    }
}
