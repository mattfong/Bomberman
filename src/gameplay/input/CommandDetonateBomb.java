package gameplay.input;

import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameActor;

/**
 * @author mfong8 Command to detonate a bomb.
 */
public class CommandDetonateBomb implements Command {

    public CommandDetonateBomb() {
    }

    @Override
    public void execute(GameActor actor) {
	((BombermanInterface) actor).detonateBomb();
    }

}
