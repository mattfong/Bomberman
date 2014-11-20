package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8
 *Command to instruct the GameActor to move right.
 */
public class CommandRight implements Command {

	public CommandRight() {
	}



	@Override
	public void execute(GameActor actor) {
		actor.moveRight();
	}

}
