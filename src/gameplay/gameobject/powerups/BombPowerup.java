package gameplay.gameobject.powerups;

import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Bomb powerup which allows bomberman to place additional bombs.
 * 
 * @author mfong8
 */
public class BombPowerup extends GameObject implements Powerup {

    public BombPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(BombPowerup.class.getResource("/PowerupBombs.png"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface actor) {
	actor.increaseBombLimit();
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
