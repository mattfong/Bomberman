package gameplay.ai;

import gameplay.Direction;
import gameplay.GameFrame;
import gameplay.gameobject.Creep;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.input.Command;
import gameplay.input.CommandDown;
import gameplay.input.CommandLeft;
import gameplay.input.CommandRight;
import gameplay.input.CommandUp;
import gameplay.*;

public class DumbAI extends AI {

    private boolean justMovedLeft = false;
    private boolean justMovedUp = false;
    private boolean wentDownOnce = false;

    // Constructor
    public DumbAI(GameActor actor) {
	super(actor, AILevel.EASY);
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

	if (counter > 5) {
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

    public Command leftAndRight() {

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

    public Command upAndDown() {

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
