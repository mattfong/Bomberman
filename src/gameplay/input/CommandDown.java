package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8
 *Command to move the gameactor down.
 */
public class CommandDown implements Command {

	public CommandDown() {
		
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveDown();
	}

}
