package gameplay.input.ai;

import gameplay.gameobject.GameActor;
import gameplay.input.commandobjects.Command;
import gameplay.world.Direction;

/**
 * AI which implements the logic for the Low intelligence AI as specified by
 * "Low intelligence enemies will move in one direction until they hit an obstacle then they will move in the opposite direction"
 * 
 * @author YA
 *
 */
public class DumbAI extends AI {

    private boolean justMovedLeft = false;
    private boolean justMovedUp = false;
    private boolean wentDownOnce = false;

    // Constructor
    public DumbAI(GameActor actor, Speed speed) {
	super(actor, speed);
    }

    @Override
    public Command getCommand() {

	counter++;

	Boolean canMoveRight = actor.canMove(Direction.RIGHT);
	Boolean canMoveLeft = actor.canMove(Direction.LEFT);

	Boolean cantMoveRight = !canMoveRight;
	Boolean cantMoveLeft = !canMoveLeft;

	// For moving up and down
	Boolean canMoveUp = actor.canMove(Direction.UP);
	Boolean canMoveDown = actor.canMove(Direction.DOWN);

	Boolean cantMoveUp = !canMoveUp;
	Boolean cantMoveDown = !canMoveDown;

	/*
	 * System.out.println("Move Down: " + canMoveDown);
	 * System.out.println("Move Up: " + canMoveUp);
	 * System.out.println("Move Right: " + canMoveRight);
	 * System.out.println("Move Left: " + canMoveLeft);
	 */

	if (counter > speed) {
	    counter = 0;

	    if (wentDownOnce == true) {
		return upAndDown();
	    }

	    if (cantMoveLeft && cantMoveRight) {
		wentDownOnce = true;
		return upAndDown();
	    }

	    else {
		return leftAndRight();
	    }

	}

	return null;

    }

    private Command leftAndRight() {

	Boolean canMoveRight = actor.canMove(Direction.RIGHT);
	Boolean canMoveLeft = actor.canMove(Direction.LEFT);
	Boolean cantMoveLeft = !canMoveLeft;

	if (cantMoveLeft) {
	    justMovedLeft = false;
	}

	if (canMoveRight && (justMovedLeft == false)) {
	    return right();

	}

	else {
	    justMovedLeft = true;

	    return left();
	}

    }

    private Command upAndDown() {

	// For moving up and down
	Boolean canMoveUp = actor.canMove(Direction.UP);
	Boolean canMoveDown = actor.canMove(Direction.DOWN);
	Boolean cantMoveUp = !canMoveUp;

	if (cantMoveUp) {
	    justMovedUp = false;
	}

	if (canMoveDown && (justMovedUp == false)) {
	    return down();

	}

	else {
	    justMovedUp = true;

	    return up();
	}
    }

}
