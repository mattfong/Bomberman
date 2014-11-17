package gameplay.input;

import gameplay.Bomberman;
import gameplay.GameActor;

public class CommandPlaceBomb implements Command{

	public CommandPlaceBomb() {
	}

	@Override
	public void execute(GameActor actor) {
		((Bomberman) actor).placeBomb();
	}

}
