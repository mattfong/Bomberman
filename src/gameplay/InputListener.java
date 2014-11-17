package gameplay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter {
	
	private static InputListener singleton=null;
	private static GameActor p1;
	
	
	protected InputListener(){
		
	}
	
	public static InputListener getInstance(){
		if(singleton==null){
			singleton=new InputListener();
		}
		return singleton;
	}
	
	public static void setGameActor(GameActor actor){
		p1=actor;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			p1.moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			p1.moveRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.moveUp();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.moveDown();
		}
		if(e.getKeyCode()==KeyEvent.VK_X){
			if(p1 instanceof Bomberman){
				((Bomberman)p1).placeBomb();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_Z){
			if(p1 instanceof Bomberman){
				((Bomberman)p1).detonateBomb();
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e){

	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
}
