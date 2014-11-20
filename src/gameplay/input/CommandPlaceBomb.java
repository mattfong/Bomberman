package gameplay.input;

import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameActor;

/**
 * @author mfong8 Command that instructs a GameActor to place a bomb.
 */
public class CommandPlaceBomb implements Command {

    public CommandPlaceBomb() {
    }

    @Override
    public void execute(GameActor actor) {
	((BombermanInterface) actor).placeBomb();
    }

}
