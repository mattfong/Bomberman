package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * 
 * Command to move the gameactor down.
 *
 * @author mfong8
 */
public class CommandDown implements Command {

    public CommandDown() {

    }

    @Override
    public void execute(GameActor actor) {
	actor.moveDown();
    }

}
