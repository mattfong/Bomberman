package gameplay.input;

import gameplay.GameActor;

public class CommandManager {

	private GameActor actor;
	private InputListener commandSource;
	public CommandManager(GameActor actor,InputListener commandSource) {
		this.actor=actor;
		this.commandSource=commandSource;
	}
	
	
	public void processCommand(){
		Command bufferedCommand = commandSource.getCommand();
		
		if(bufferedCommand!=null){	
			handleCommand(bufferedCommand);
		}
	}
	
	
	private void handleCommand(Command inputCommand){
		inputCommand.execute(actor);
	}
	
	
	
}
