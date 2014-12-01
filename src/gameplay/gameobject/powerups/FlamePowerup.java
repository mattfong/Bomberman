package gameplay.gameobject.powerups;

import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Powerup which increase the explosion radius of bombs.
 * 
 * @author mfong8
 */
public class FlamePowerup extends GameObject implements Powerup {

    public FlamePowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(FlamePowerup.class.getResource("/PowerupFlamepass.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.increaseExplosionRadius();
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
