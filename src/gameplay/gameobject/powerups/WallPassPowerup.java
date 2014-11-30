package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

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
	// TODO Auto-generated method stub

    }

}
