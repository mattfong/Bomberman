package gameplay.input;

import gameplay.GameActor;

public class CommandRight implements Command {

	public CommandRight() {
	}



	@Override
	public void execute(GameActor actor) {
		actor.moveRight();
	}

}
