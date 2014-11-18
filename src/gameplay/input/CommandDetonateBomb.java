package gameplay.input;

import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;

public class CommandDetonateBomb implements Command {

	public CommandDetonateBomb() {
	}

	@Override
	public void execute(GameActor actor) {
		((Bomberman) actor).detonateBomb();	
	}

}
