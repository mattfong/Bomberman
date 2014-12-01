package gameplay.input.commandobjects;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.bomberman.BombermanInterface;

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
