package gameplay.gameobject;

import gameplay.World;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

/**
 * @author mfong8 Implenting class for the abstract GameObject class. Implements
 *         features associated with moveable game actor objects.
 */
public class GameActor extends GameObject implements Cloneable {

    protected int moveSpeed = 32;
    protected boolean wallPass;
    protected CommandManager driver;

    public GameActor(Rectangle location, World world) {
	super(location, world);

	conductsExplosions = true;
	wallPass = false;
	solid = false;
	destroyable = true;

	// Bomberman specific stuff

    }

    @Override
    public void update() {
	// driver.getCommand();
    }

//    @Override
//    public GameActor clone(Rectangle location) {
//	GameActor clone = new GameActor(location, this.world);
//
//	clone.sprite = this.sprite;
//	clone.solid = this.solid;
//	clone.destroyable = this.destroyable;
//	clone.conductsExplosions = this.conductsExplosions;
//	clone.score = this.score;
//	clone.conductsExplosions = this.conductsExplosions;
//	clone.wallPass = this.wallPass;
//	clone.sprite = this.sprite;
//
//	return clone;
//    }

    private boolean hasCollided() {

	return world.checkForCollision(this);

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
	gridLocation.x = gridLocation.x - moveSpeed;
	if (hasCollided()) {
	    gridLocation.x = gridLocation.x + moveSpeed;
	}

    }

    /**
     * command to move the game actor right.
     */
    public void moveRight() {
	gridLocation.x = gridLocation.x + moveSpeed;
	if (hasCollided()) {
	    gridLocation.x = gridLocation.x - moveSpeed;
	}
    }

    /**
     * command to move the game actor up
     */
    public void moveUp() {
	gridLocation.y = gridLocation.y - moveSpeed;
	if (hasCollided()) {
	    gridLocation.y = gridLocation.y + moveSpeed;
	}
    }

    /**
     * command to move the game actor down.
     */
    public void moveDown() {
	gridLocation.y = gridLocation.y + this.moveSpeed;
	if (hasCollided()) {
	    gridLocation.y = gridLocation.y - moveSpeed;
	}

    }

}
