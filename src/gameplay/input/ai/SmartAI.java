package gameplay.input.ai;

import gameplay.gameobject.GameActor;
import gameplay.input.commandobjects.Command;
import gameplay.world.Direction;

import java.util.Random;

/**
 * AI implementation of the High inteligence AI as per requirement
 * "High intelligence enemies move like medium intelligence enemies with a 50% chance of changing directions. High intelligence enemies shall chase bomberman if he is within a 2 square radius; if there is an obstacle between bomberman and the enemy, it will use A star search to find the path to bomberman, if such a path exists. The enemy will check for bomberman and recalculate the path everytime it traverses 1 grid cell."
 * 
 * @author YA
 *
 */



public class SmartAI extends AI {

    // Did not finish implementing A*, average AI standin as logic for now, A*
    // can be implemented as taking over when world.distanceToBomberman() is
    // less than 2 squares.

    private Boolean justMovedLeft = false;
    private Boolean justMovedUp = false;

    private Boolean leftRight = true;
    private Boolean isAtIntersection;

    public SmartAI(GameActor actor, Speed speed) {
	super(actor, speed);

    }

    @Override
    public Command getCommand() {
	
	counter++;

	Boolean fiftyPercent = isFiftyPercent();
	
	
	if (counter > speed) {
	    
	    counter = 0;
	    
	    return chdirAndChaseBomberman(fiftyPercent);
	    
	}

	return null;
	
	
    }
    
    
    // HELPER METHODS

    public Command chdirAndChaseBomberman(Boolean percentChance) {

	Boolean canMoveRight = actor.canMove(Direction.RIGHT);
	Boolean canMoveLeft = actor.canMove(Direction.LEFT);

	Boolean cantMoveRight = !canMoveRight;
	Boolean cantMoveLeft = !canMoveLeft;

	// For moving up and down
	Boolean canMoveUp = actor.canMove(Direction.UP);
	Boolean canMoveDown = actor.canMove(Direction.DOWN);

	Boolean cantMoveUp = !canMoveUp;
	Boolean cantMoveDown = !canMoveDown;

	Integer creepX = actor.getLocation().x;
	Integer creepY = actor.getLocation().y;

	int bombermanX = actor.getBombermanCoordinates().x;
	int bombermanY = actor.getBombermanCoordinates().y;

	if (cantMoveLeft && cantMoveRight) {
	    leftRight = false;
	}

	if (cantMoveUp && cantMoveDown) {
	    leftRight = true;
	}

	if ((creepX + 32 == bombermanX)
		&& actor.canMove(Direction.RIGHT)
		&& ((creepY + 32 == bombermanY) || (creepY - 32 == bombermanY) || (creepY == bombermanY))) {

	    return right();
	}

	else if ((creepX - 32 == bombermanX)
		&& actor.canMove(Direction.LEFT)
		&& ((creepY + 32 == bombermanY) || (creepY - 32 == bombermanY) || (creepY == bombermanY))) {

	    return left();
	}

	else if ((creepY + 32 == bombermanY)
		&& actor.canMove(Direction.DOWN)
		&& ((creepX + 32 == bombermanX) || (creepX - 32 == bombermanX) || (creepX == bombermanX))) {

	    return down();
	}

	else if ((creepY - 32 == bombermanY)
		&& actor.canMove(Direction.UP)
		&& ((creepX + 32 == bombermanX) || (creepX - 32 == bombermanX) || (creepX == bombermanX))) {

	    return up();
	}

	else {

	    return changeDirection(percentChance);

	}

    }

    public Command changeDirection(Boolean percentChance) {

	if (leftRight) {
	    isAtIntersection = actor.isAtIntersection();

	    if (isAtIntersection && percentChance) {
		leftRight = false;
		// System.out.println("at intersection, changing dir...");
		return upAndDown();
	    }

	    return leftAndRight();
	}

	else if (!leftRight) {

	    isAtIntersection = actor.isAtIntersection();

	    if (isAtIntersection && percentChance) {
		leftRight = true;
		// System.out.println("at intersection, going from up/down to left/right");
		return leftAndRight();
	    }

	    return upAndDown();
	}

	else {
	    return null;
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
    
    // Randomizer methods
    public Boolean isFiftyPercent() {

	Random r = new Random();
	int number = r.nextInt(9);
	Boolean isFiftyPercent = isZeroOneTwoThreeFour(number);

	return isFiftyPercent;
    }

    public Boolean isZeroOneTwoThreeFour(int integer) {

	if (integer == 0){
	    return true;
	} 
	else if(integer == 1){
	    return true;
	}
	else if(integer == 2){
	    return true;
	}
	else if(integer == 3){
	    return true;
	}
	else if(integer == 4){
	    return true;
	}
	else {
	    return false;
	}

    }

    
}