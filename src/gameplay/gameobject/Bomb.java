package gameplay.gameobject;

import gameplay.Direction;
import gameplay.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Class implementing the bomb feature.
 */
public class Bomb extends GameObject {
    private int explosionRadius;
    private int bombCountdown;

    public Bomb(Rectangle location, World world, int radius) {
	super(location, world);
	sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();

	destroyable = false;
	solid = true;
	conductsExplosions = false;

	bombCountdown = 40;
	explosionRadius = radius;
    }

    @Override
    public void update() {
	super.update();

	bombCountdown--;
	if (checkBombTimer()) {
	    this.explode();
	}

    }

    /**
     * detonates the bomb it's called on which causes objects on the gamemap
     * that are within the explosion radius to be destroyed.
     */
    public void explode() {
	this.destroy();
	world.detonateLine(gridLocation.x, gridLocation.y, Direction.UP, explosionRadius);
	world.detonateLine(gridLocation.x, gridLocation.y, Direction.DOWN, explosionRadius);
	world.detonateLine(gridLocation.x, gridLocation.y, Direction.LEFT, explosionRadius);
	world.detonateLine(gridLocation.x, gridLocation.y, Direction.RIGHT, explosionRadius);
    }

    private boolean checkBombTimer() {
	if (bombCountdown == 0) {
	    return true;
	}
	return false;
    }

}
