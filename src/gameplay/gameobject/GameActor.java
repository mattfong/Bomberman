package gameplay.gameobject;

import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.blocks.Explosion;
import gameplay.input.CommandManager;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.Direction;
import gameplay.world.World;

import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Implenting class for the abstract GameObject class. Implements features
 * associated with moveable game actor objects. Each GameActor is responsible to
 * manage it's own state, it checks if it has been killed and if is has raises a
 * flag for the game engine to remove it from play.
 *
 * @author mfong8
 */

public class GameActor extends GameObject implements Serializable {

    protected CommandManager inputManager;
    protected int moveSpeed = 32;
    protected boolean wallPass;
    protected CommandManager driver;
    protected boolean isDead;
    protected int queryRate;

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
	    GameStateManager.getInstance().increaseScore(score);
	}

    }

    /**
     * @return rectangle representing bomberman's coordinates
     */
    public Rectangle getBombermanCoordinates() {
	return world.getBombermanCoordinates();
    }

    protected boolean checkIfBombed() {

	if (world.getGameObjectInstanceAt(this.getLocation()) instanceof Explosion) {
	    return true;
	} else {
	    return false;
	}

    }

    /**
     * @param direction
     *            direction enum in which to check
     * @return true if the GameActor is able to move onto the grid element.
     */
    public boolean canMove(Direction direction) {
	return !(world.willCollide(this, direction));

    }

    /**
     * @return check if the GameActor is dead.
     */
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

    /**
     * @return true if bomberman is at an intersection, false if not
     */
    public boolean isAtIntersection() {
	return world.isIntersection(this.getLocation());
    }

    // /**
    // * @return int value for distance to Bomberman
    // */
    // public int distanceToBomberman() {
    // return world.distanceToBomberman(this);
    // }

    // /**
    // * @param range range to bomberan to check
    // * @return true if bomberman is within the range inclusively
    // */
    // public boolean bombermanWithinRange(int range) {
    // return world.bombermanWithin(this, range);
    // }

}
