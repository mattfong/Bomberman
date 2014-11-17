package gameplay.input;

import gameplay.Bomberman;
import gameplay.GameActor;

public class CommandDetonateBomb implements Command {

	public CommandDetonateBomb() {
	}

	@Override
	public void execute(GameActor actor) {
		((Bomberman) actor).detonateBomb();	
	}

}
