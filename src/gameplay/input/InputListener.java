package gameplay.input;

import gameplay.Bomberman;
import gameplay.GameActor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter {
	
	private static InputListener singleton=null;
	private static KeyEvent bufferedKey;
	
	
	protected InputListener(){
		
	}
	
	public static InputListener getInstance(){
		if(singleton==null){
			singleton=new InputListener();
		}
		return singleton;
	}

	@Override
	public void keyPressed(KeyEvent e){
		bufferedKey=e;
	}
	@Override
	public void keyReleased(KeyEvent e){

	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	public Command getCommand(){
		
		if(bufferedKey!=null){
			if(bufferedKey.getKeyCode()==KeyEvent.VK_LEFT){
				bufferedKey=null;
				return new CommandLeft();
			}
			if(bufferedKey.getKeyCode()==KeyEvent.VK_RIGHT){
				bufferedKey=null;
				return new CommandRight();
			}
			if(bufferedKey.getKeyCode()==KeyEvent.VK_UP){
				bufferedKey=null;
				return new CommandUp();	
			}
			if(bufferedKey.getKeyCode()==KeyEvent.VK_DOWN){
				bufferedKey=null;
				return new CommandDown();
			}
		
		}
		return null;
	}
}