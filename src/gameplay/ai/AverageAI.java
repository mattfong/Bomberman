package gameplay.ai;

import java.util.Random;

import gameplay.Direction;
import gameplay.World;
import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;
import gameplay.input.Command;
import gameplay.input.CommandDown;
import gameplay.input.CommandLeft;
import gameplay.input.CommandRight;
import gameplay.input.CommandUp;

public class AverageAI extends AI {

    private Integer speed = 200;
    
    private Boolean justMovedLeft = false;
    private Boolean justMovedUp = false;

    private Boolean leftRight = true;
    private Boolean isAtIntersection;
    

    public AverageAI(GameActor actor) {
	super(actor, AILevel.MEDIUM);

    }

    @Override
    public Command getCommand() {

	counter++;

	Boolean tenPercent = isTenPercent();
	
	
	if (counter > speed) {

	    Boolean canMoveRight = actor.canMove(Direction.RIGHT);
	    Boolean canMoveLeft = actor.canMove(Direction.LEFT);

	    Boolean cantMoveRight = !canMoveRight;
	    Boolean cantMoveLeft = !canMoveLeft;

		// For moving up and down
	    Boolean canMoveUp = actor.canMove(Direction.UP);
	    Boolean canMoveDown = actor.canMove(Direction.DOWN);

	    Boolean cantMoveUp = !canMoveUp;
	    Boolean cantMoveDown = !canMoveDown;

	    
	    counter = 0;
	    
	    Integer creepX = actor.getLocation().x;
	    Integer creepY = actor.getLocation().y;
	    
	    
	    	    
	    int bombermanX = actor.getBombermanCoordinates().x;
	    int bombermanY = actor.getBombermanCoordinates().y;
	    
	    if(cantMoveLeft && cantMoveRight){
		leftRight = false;
	    }
	    
	    if(cantMoveUp && cantMoveDown){
		leftRight = true;
	    }
	        
	    
	    
	    if((creepX + 32 == bombermanX) && actor.canMove(Direction.RIGHT) && ((creepY + 32 == bombermanY) || (creepY -32 == bombermanY) || (creepY == bombermanY))){
		
		return right();
	    }
	    
	    else if((creepX - 32 == bombermanX) && actor.canMove(Direction.LEFT) && ((creepY + 32 == bombermanY) || (creepY - 32 == bombermanY) || (creepY == bombermanY))){
		
		return left();
	    }
	    
	    else if((creepY + 32 == bombermanY) && actor.canMove(Direction.DOWN) && ((creepX + 32 == bombermanX) || (creepX - 32 == bombermanX) || (creepX == bombermanX))){
		
		return down();
	    }
	    
	    else if((creepY - 32 == bombermanY) && actor.canMove(Direction.UP) && ((creepX + 32 == bombermanX) || (creepX - 32 == bombermanX) || (creepX == bombermanX))){
		
		return up();
	    }
	    
	    
	    else{
		
		return changeDirection(tenPercent);
		
	    }

	}

	return null;
    }
    

    
    // HELPER METHODS

    //towrite if time allows
    public Boolean bombermanIsWithinOne(){
	return null;
    }
    
    public Integer setToZero(Integer anInt){
	return anInt = 0;
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

	else if(!leftRight) {

	    isAtIntersection = actor.isAtIntersection();

	    if (isAtIntersection && percentChance) {
		leftRight = true;
		// System.out.println("at intersection, going from up/down to left/right");
		return leftAndRight();
	    }

	    return upAndDown();
	}
	
	else{
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
    public Boolean isTenPercent() {

	Random r = new Random();
	int number = r.nextInt(9);
	Boolean isTenPercent = isZero(number);

	return isTenPercent;
    }

    public Boolean isZero(int integer) {

	if (integer == 0) {
	    return true;
	} else {
	    return false;
	}

    }

}
