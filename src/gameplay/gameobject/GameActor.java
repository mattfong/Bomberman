package gameplay.gameobject;

import gameplay.World;

import java.awt.Rectangle;

/**
 * @author mfong8 Implenting class for the abstract GameObject class. Implements
 *         features associated with moveable game actor objects.
 */
public class GameActor extends GameObject {

    protected int moveSpeed = 32;

    protected int bombLimit;
    protected boolean wallPass;
    protected boolean bombPass;
    protected boolean flamePass;
    protected boolean detonator;
    protected int explosionRadius;

    public GameActor(Rectangle location, World world) {
	super(location, world);

	conductsExplosions = true;
	wallPass = false;
	bombPass = false;
	flamePass = false;
	detonator = false;
	explosionRadius = 1;
    }

    @Override
    public void update() {

    }

    private boolean hasCollided() {

	return world.checkForCollision(this);

    }

    /**
     * @return true if the GameActor can detonate bombs.
     */

    public boolean canDetonateBomb() {
	return detonator;

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
    public boolean canBombPass() {
	return bombPass;
    }

    /**
     * Increase the explosion radius of the bombs placed by 1.
     */
    public void increaseExplosionRadius() {
	this.explosionRadius++;
    }

    /**
     * Increases the amount of bombs that can be placed on the board at a given
     * time by 1.
     */
    public void increaseBombLimit() {
	this.bombLimit++;
    }

    /**
     * returns if the gameactor is immune to bomb fire.
     *
     * @return true if the actor can "take the heat", false if he turns into
     *         jerky.
     */
    public boolean canTakeTheHeat() {
	return flamePass;
    }

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

    public void setWallPass(boolean wallPass) {
	this.wallPass = wallPass;
    }

    public void setBombPass(boolean bombPass) {
	this.bombPass = bombPass;
    }

    public void setFlamePass(boolean flamePass) {
	this.flamePass = flamePass;
    }

    public void setDetonator(boolean detonator) {
	this.detonator = detonator;
    }
}
