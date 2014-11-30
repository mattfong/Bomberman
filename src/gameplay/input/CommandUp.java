package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * 
 * Command to tell the GameActor the move up.
 * 
 * @author mfong8
 */
public class CommandUp implements Command {

    public CommandUp() {
    }

    @Override
    public void execute(GameActor actor) {
	actor.moveUp();
    }

}
