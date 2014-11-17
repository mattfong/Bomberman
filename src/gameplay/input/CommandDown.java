package gameplay.input;

import gameplay.GameActor;

public class CommandDown implements Command {

	public CommandDown() {
		
	}

	@Override
	public void execute(GameActor actor) {
		actor.moveDown();
	}

}
