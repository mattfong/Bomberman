package gameplay.gameobject.enemies;

import gameplay.Level;
import gameplay.World;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.powerups.BombPassPowerup;
import gameplay.gameobject.powerups.BombPowerup;
import gameplay.gameobject.powerups.DetonatorPowerup;
import gameplay.gameobject.powerups.FlamePassPowerup;
import gameplay.gameobject.powerups.FlamePowerup;
import gameplay.gameobject.powerups.Powerup;
import gameplay.gameobject.powerups.SpeedPowerup;
import gameplay.gameobject.powerups.WallPassPowerup;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Credit to TA Dominique for telling me how to implement this black magic with
 * meta classes.
 * 
 * @author MF
 */
public class Factory implements Serializable {

    private World world;

    public Factory(World world) {
	this.world = world;
    }

    /**
     * Creates a list of game actors that is associated with the given level.
     * 
     * @param level
     *            the level which is to be configured.
     * @return an array list populated with game actors set to the location 0,0.
     */
    public ArrayList<GameActor> getEnemyList(Level level) {

	ArrayList<GameActor> actorList = new ArrayList<GameActor>();
	Class[] classArray = level.getClassList();

	for (Class c : classArray) {
	    if (c == Balloon.class) {
		actorList.add(new Balloon(world));
	    }
	    if (c == Oneal.class) {
		actorList.add(new Oneal(world));
	    }
	    if (c == Kondoria.class) {
		actorList.add(new Kondoria(world));

	    }
	    if (c == Doll.class) {
		actorList.add(new Doll(world));
	    }
	    if (c == Minvo.class) {
		actorList.add(new Minvo(world));
	    }
	    if (c == Ovapi.class) {
		actorList.add(new Ovapi(world));
	    }
	    if (c == Pass.class) {
		actorList.add(new Pass(world));
	    }
	    if (c == Pontan.class) {
		actorList.add(new Pontan(world));
	    }
	}
	return actorList;

    }

    /**
     * Creates a powerup instance for the given level.
     * 
     * @param level
     *            required level
     * @return instance of the Powerup associated with that level with location
     *         set to 0,0
     */
    public Powerup getPowerup(Level level) {
	Powerup powerup;
	Class c;
	powerup = new DetonatorPowerup(new Rectangle(0, 0, 32, 32), world);// default
									   // powerup
									   // is
									   // located
									   // outside
									   // the
									   // world,
	c = level.getPowerupClass();

	if (c == BombPassPowerup.class) {
	    powerup = new BombPassPowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == BombPowerup.class) {
	    powerup = new BombPowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == DetonatorPowerup.class) {
	    powerup = new DetonatorPowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == FlamePassPowerup.class) {
	    powerup = new FlamePassPowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == FlamePowerup.class) {
	    powerup = new FlamePowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == SpeedPowerup.class) {
	    powerup = new SpeedPowerup(new Rectangle(0, 0, 32, 32), world);
	}
	if (c == WallPassPowerup.class) {
	    powerup = new WallPassPowerup(new Rectangle(0, 0, 32, 32), world);
	}

	return powerup;

    }

}
