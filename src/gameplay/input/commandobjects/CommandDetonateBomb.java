package gameplay.input.commandobjects;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.bomberman.BombermanInterface;

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
