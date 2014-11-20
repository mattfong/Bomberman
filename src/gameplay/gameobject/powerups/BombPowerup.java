package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.blocks.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Bomb powerup which allows bomberman to place additional bombs.
 */
public class BombPowerup extends GameObject implements Powerup {

    public BombPowerup(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(BombPowerup.class.getResource("/PowerupBombs.png")).getImage();

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(GameActor actor) {
	actor.increaseBombLimit();
    }

}
