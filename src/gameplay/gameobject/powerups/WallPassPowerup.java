package gameplay.gameobject.powerups;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.gameobject.enemies.Oneal;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Powerup which allows bomberman to move through walls.
 * 
 * @author mfong8
 */
public class WallPassPowerup extends GameObject implements Powerup {

    public WallPassPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(WallPassPowerup.class.getResource("/PowerupWallpass.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.setWallPass(true);
    }

    @Override
    public void haveBeenBombed() {
	ArrayList<GameActor> actorList = new ArrayList<GameActor>();
	for (int i = 0; i < 5; i++) {
	    actorList.add(new Oneal(gridLocation, world));
	}
	world.spawnEnemies(actorList);

    }

}
