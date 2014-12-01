package gameplay.input;

import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameActor;

/**
 * Command to detonate a bomb.
 * 
 * @author mfong8
 */
public class CommandDetonateBomb implements Command {

    public CommandDetonateBomb() {
    }

    @Override
    public void execute(GameActor actor) {
	((BombermanInterface) actor).detonateBomb();
    }

}
