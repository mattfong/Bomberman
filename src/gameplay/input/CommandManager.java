package gameplay.input;

import gameplay.gameobject.GameActor;

/**
 * @author MF
 *The CommandManager class is used to control the flow of commands. Each instance of CommandManager is binded to an individual GameActor and controls the GameActor's actions. 
 */
public class CommandManager {

	private GameActor actor;
	private InputListener commandSource;
	/**
	 * @param actor The GameActor which will be controlled by Command Manager.
	 * @param commandSource The source of the commands that will be piped to the GameActors, in the case of Bomberman this is the inputListener, in the case of an Enemy it will be an AI.
	 */
	public CommandManager(GameActor actor,InputListener commandSource) {
		this.actor=actor;
		this.commandSource=commandSource;
	}
	
	
	/**
	 * Method gets a command from the specified Command source defined in constructor and executes the command.
	 */
	public void processCommand(){
		Command bufferedCommand = commandSource.getCommand();
		
		if(bufferedCommand!=null){	
			executeCommand(bufferedCommand);
		}
	}
	
	
	/**
	 * executes the given command on the bounded GameActor
	 * @param inputCommand command that is to be executed.
	 */
	private void executeCommand(Command inputCommand){
		inputCommand.execute(actor);
	}
	
	
	
}
