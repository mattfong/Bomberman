package gameplay.input;

import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameActor;

/**
 * Command that instructs a GameActor to place a bomb.
 * 
 * @author mfong8
 */
public class CommandPlaceBomb implements Command {

    public CommandPlaceBomb() {
    }

    @Override
    public void execute(GameActor actor) {
	((BombermanInterface) actor).placeBomb();
    }

}
