package gameplay.input;

import gameplay.gameobject.GameActor;

public class CommandLeft implements Command {

	public CommandLeft() {
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveLeft();
	}

}
