package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Powerup which allows bomberman to detonate bombs.
 * 
 * @author mfong8
 */
public class DetonatorPowerup extends GameObject implements Powerup {

    public DetonatorPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(DetonatorPowerup.class.getResource("/PowerupDetonator.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.setDetonator(true);
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
