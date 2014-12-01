package gameplay.gameobject.blocks;

import gameplay.gameobject.GameObject;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

/**
 * Class implementing the bomb feature.
 * 
 * @author mfong8
 * 
 */
public class Bomb extends GameObject {
    private int explosionRadius;
    private int bombCountdown;

    private static Queue<Bomb> bombList = new LinkedList<Bomb>();

    public Bomb(Rectangle location, World world, int radius) {
	super(location, world);
	sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png"));

	destroyable = false;
	solid = true;
	conductsExplosions = false;
	bombCountdown = 40;
	explosionRadius = radius;
	addBomb(this);
    }

    /**
     * Static method that returns the total number of bombs placed on the board.
     *
     * @return number of bombs on the board as an int
     */
    public static int numberOfBombOnBoard() {
	return bombList.size();
    }

    /**
     * Static method that when called detonates the oldest bomb on the board.
     * Does nothing if there are no bombs on the board.
     */
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

    /**
     * Method which resets all placed bombs on the board.
     */
    public static void resetBombList() {
	bombList.clear();
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
