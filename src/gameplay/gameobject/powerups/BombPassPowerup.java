package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 BombPass powerup which allows bomberman to move through bombs.
 */
public class BombPassPowerup extends GameObject implements Powerup {

    public BombPassPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(BombPassPowerup.class.getResource("/PowerupBombpass.png")).getImage();

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.setBombPass(true);

    }

}
