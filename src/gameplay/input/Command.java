package gameplay.input;

import gameplay.gameobject.GameActor;

import java.io.Serializable;

/**
 * Common interface which defines how commands will be carried out.
 * 
 * @author mfong8
 */
public interface Command extends Serializable {
    /**
     * executes the command on the specified GameActor
     * 
     * @param actor
     *            that will carry out the command.
     */
    public void execute(GameActor actor);
}
