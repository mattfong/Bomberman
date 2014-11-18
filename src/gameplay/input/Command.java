package gameplay.input;

import gameplay.gameobject.GameActor;

public interface Command {
	public void execute(GameActor actor);
}
