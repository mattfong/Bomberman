package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8
 *Command to move the GameActor left
 */
public class CommandLeft implements Command {

	public CommandLeft() {
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveLeft();
	}

}
