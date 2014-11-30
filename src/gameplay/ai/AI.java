package gameplay.ai;

import gameplay.gameobject.GameActor;
import gameplay.input.Command;
import gameplay.input.CommandDown;
import gameplay.input.CommandIssuer;
import gameplay.input.CommandLeft;
import gameplay.input.CommandRight;
import gameplay.input.CommandUp;

public abstract class AI implements CommandIssuer {

    // protected int responseSpeed;
    protected GameActor actor;
    protected int counter;
    protected int speed;

    // Constructor
    public AI(GameActor actor, Speed speed) {
	this.actor = actor;
	this.speed = speed.getSpeed();

    }

    // Shortened move commands
    public Command up() {
	return new CommandUp();
    }

    public Command down() {
	return new CommandDown();
    }

    public Command right() {
	return new CommandRight();
    }

    public Command left() {
	return new CommandLeft();
    }

}
