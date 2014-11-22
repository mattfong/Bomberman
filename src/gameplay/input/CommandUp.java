package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8
 *Command to tell the GameActor the move up.
 */
public class CommandUp implements Command {

	public CommandUp() {
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveUp();
	}

}
