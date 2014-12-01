package gameplay.gameobject.powerups;

import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * BombPass powerup which allows bomberman to move through bombs.
 * 
 * @author mfong8
 */
public class BombPassPowerup extends GameObject implements Powerup {

    public BombPassPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(BombPassPowerup.class.getResource("/PowerupBombpass.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.setBombPass(true);

    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
