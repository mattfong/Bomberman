package gameplay.input;

import java.io.Serializable;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8
 *	Common interace which defines how commands will be carried out.
 */
public interface Command extends Serializable{
	/**
	 * executes the command on the specified GameActor
	 * @param the actor that will carry out the command.
	 */
	public void execute(GameActor actor);
}
