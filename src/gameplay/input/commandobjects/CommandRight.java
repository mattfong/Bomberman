package gameplay.input.commandobjects;

import gameplay.gameobject.GameActor;

/**
 * 
 * Command to instruct the GameActor to move right.
 * 
 * @author mfong8
 */
public class CommandRight implements Command {

    public CommandRight() {
    }

    @Override
    public void execute(GameActor actor) {
	actor.moveRight();
    }

}
