package gameplay.gameobject;

import gameplay.Direction;
import gameplay.World;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Explosion;
import gameplay.input.CommandManager;
import gameplay.statemanagers.ScoreManager;

import java.awt.Rectangle;

/**
 * @author mfong8 Implenting class for the abstract GameObject class. Implements
 *         features associated with moveable game actor objects.
 */
/**
 * @author MF
 *
 */
public class GameActor extends GameObject {

    CommandManager inputManager;
    protected int moveSpeed = 32;
    protected boolean wallPass;
    protected CommandManager driver;
    protected boolean isDead;

    public GameActor(Rectangle location, World world) {
	super(location, world);

	conductsExplosions = true;
	wallPass = false;
	solid = false;
	destroyable = true;
	isDead = false;

    }

    @Override
    public void update() {
	inputManager.processCommand();
	if (checkIfBombed()) {
	    isDead = true;
	    ScoreManager.addToScore(score);
	}

    }

    protected boolean checkIfBombed() {

	if (world.getGameObjectInstanceAt(this.getLocation()) instanceof Explosion) {
	    return true;
	} else {
	    return false;
	}

    }

    public boolean canMove(Direction direction) {
	return !(world.willCollide(this, direction));

    }

    private boolean hasCollided() {

	return world.checkForCollision(this);

    }

    public boolean isDead() {
	return isDead;
    }

    /**
     * @return true if the GameActor can walk through brick elements, false if
     *         the GameActor cannot.
     */
    public boolean canWallPass() {
	return wallPass;
    }

    /**
     * @return true if the GameActor can be move through bombs, false if the
     *         game actor cannot move through bombs.
     */

    /**
     * command to move the game actor left.
     */
    public void moveLeft() {
	if (canMove(Direction.LEFT)) {
	    gridLocation.x = gridLocation.x - moveSpeed;
	}

    }

    /**
     * command to move the game actor right.
     */
    public void moveRight() {
	if (canMove(Direction.RIGHT)) {
	    gridLocation.x = gridLocation.x + moveSpeed;
	}
    }

    /**
     * command to move the game actor up
     */
    public void moveUp() {
	if (canMove(Direction.UP)) {
	    gridLocation.y = gridLocation.y - moveSpeed;
	}
    }

    /**
     * command to move the game actor down.
     */
    public void moveDown() {
	if (canMove(Direction.DOWN)) {
	    gridLocation.y = gridLocation.y + moveSpeed;
	}
    }

    /**
     * Checks if the GameActor can pass through a given GameObject.
     *
     * @param object
     *            GameObject that is being checked
     * @return true if the GameActor can pass through the object, false if the
     *         object is solid to the GameActor
     */
    public boolean canPassThrough(GameObject object) {
	if (object instanceof Brick) {
	    return wallPass;
	} else if (object.isSolid()) {
	    return false;
	}
	return true;

    }

    public boolean isAtIntersection() {
	return world.isIntersection(this.getLocation());
    }

    public int distanceToBomberman() {
	return world.distanceToBomberman(this);
    }

    public boolean bombermanWithinRange(int range) {
	return world.bombermanWithin(this, range);
    }

}
