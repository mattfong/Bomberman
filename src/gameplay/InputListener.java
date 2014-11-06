package gameplay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter {
	
	private Bomberman p1;
	
	public InputListener(Bomberman o){
		p1=o;
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
			p1.placeBomb();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e){

	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
}
