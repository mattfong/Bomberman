package gameplay;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor{

	Queue<Bomb> bombList= new LinkedList();
	
	public Bomberman (World world, Rectangle location){
		super(world, location);
		sprite=new ImageIcon("./src/gameplay/Sprite.png").getImage();
		 
	}
	



	public void placeBomb(){
		Bomb bomb=new Bomb( new Rectangle(gridLocation),this.world);
		bombList.add(bomb);
		world.grid[gridLocation.x/pictureSize][gridLocation.y/pictureSize]=bomb;
	}
	
	public void detonateBomb(){
		Bomb bomb;
		bomb=bombList.poll();
		bomb.remove();
		
	}
	

}
