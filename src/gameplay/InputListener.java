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
			p1.setXDirection(-32);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			p1.setXDirection(32);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.setYDirection(-32);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setYDirection(32);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			p1.setXDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			p1.setXDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.setYDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setYDirection(0);
		}
	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
}
