package gameplay.gameobject;

import gameplay.Direction;
import gameplay.World;
import gameplay.gameobject.blocks.Brick;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

/**
 * @author mfong8 Implenting class for the abstract GameObject class. Implements
 *         features associated with moveable game actor objects.
 */
/**
 * @author MF
 *
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

    public boolean canMove(Direction direction){
    	return !(world.willCollide(this, direction));
    
    }
    
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
    if(canMove(Direction.DOWN)){
	    gridLocation.y = gridLocation.y + moveSpeed;
    }
	}

    
    
    /**
     * Checks if the GameActor can pass through a given GameObject.
     * @param object GameObject that is being checked
     * @return true if the GameActor can pass through the object, false if the object is solid to the GameActor
     */
    public boolean canPassThrough(GameObject object){
    	if(object instanceof Brick){
    		return wallPass;
    	}else if (object.isSolid()){
    		return false;
    	}
    		return true;
    		
    }

}
