package gameplay.input;

import gameplay.gameobject.GameActor;

public class CommandRight implements Command {

	public CommandRight() {
	}



	@Override
	public void execute(GameActor actor) {
		actor.moveRight();
	}

}
