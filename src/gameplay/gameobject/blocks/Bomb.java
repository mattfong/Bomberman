package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Class implementing the bomb feature.
 */
public class Bomb extends GameObject {
    private int explosionRadius;
    private int bombCountdown;

    private static Queue<Bomb> bombList = new LinkedList<Bomb>();

    public Bomb(Rectangle location, World world, int radius) {
	super(location, world);
	sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();

	destroyable = false;
	solid = true;
	conductsExplosions = false;

	bombCountdown = 40;
	explosionRadius = radius;
    }

    public static int numberOfBombOnBoard() {
	return bombList.size();
    }

    public static void detonateBomb() {
	Bomb bomb;
	bomb = bombList.peek();
	if (bomb != null) {
	    bomb.explode();
	}

    }

    public static void addBomb(Bomb bomb) {
	bombList.add(bomb);
    }

    @Override
    public void update() {
	super.update();

	bombCountdown--;
	if (checkBombTimer()) {
	    this.explode();
	}

    }

    private void explode() {
	bombList.remove();
	this.destroy();
	world.detonateLocation(getLocation(), explosionRadius);

    }

    private boolean checkBombTimer() {
	if (bombCountdown == 0) {
	    return true;
	}
	return false;
    }

}
