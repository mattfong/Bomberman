package gameplay;

import gameplay.GameObject;
import gameplay.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor{

	public Bomberman (World world, Rectangle location){
		super(world, location);
		sprite=new ImageIcon("./src/gameplay/Sprite.png").getImage();
		 
	}
	



	private void placeBomb(int explosionRadius){
		
	}
	
	private void detonateBomb(){
		
	}
	

}
