package gameplay.input;

import gameplay.GameActor;

public interface Command {
	public void execute(GameActor actor);
}
