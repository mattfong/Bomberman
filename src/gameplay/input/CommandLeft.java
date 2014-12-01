package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * 
 * Command to move the GameActor left * @author mfong8
 */
public class CommandLeft implements Command {

    public CommandLeft() {
    }

    @Override
    public void execute(GameActor actor) {
	actor.moveLeft();
    }

}
