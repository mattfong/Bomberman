package gameplay.gameobject.powerups;

import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Powerup which increase the movement speed of bomberman.
 * 
 * @author mfong8
 */
public class SpeedPowerup extends GameObject implements Powerup {

    public SpeedPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(SpeedPowerup.class.getResource("/PowerupSpeed.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.increaseMoveSpeed();
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
