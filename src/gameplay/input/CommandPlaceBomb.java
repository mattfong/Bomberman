package gameplay.input;

import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;

public class CommandPlaceBomb implements Command{

	public CommandPlaceBomb() {
	}

	@Override
	public void execute(GameActor actor) {
		((Bomberman) actor).placeBomb();
	}

}
