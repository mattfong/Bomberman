package gameplay.input;

import gameplay.gameobject.GameActor;

public class CommandUp implements Command {

	public CommandUp() {
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveUp();
	}

}
