package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Powerup which makes bomberman immune to fire.
 * 
 * @author mfong8
 */
public class FlamePassPowerup extends GameObject implements Powerup {

    public FlamePassPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(FlamePassPowerup.class.getResource("/PowerupFlamepass.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.setFlamePass(true);
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
