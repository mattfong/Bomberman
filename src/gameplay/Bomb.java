package gameplay;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb extends GameObject {
	private boolean isSolid;
	private int explosionRadius;
	public Bomb(Rectangle location, World world){
		super(location); 
		isSolid=true;
		this.world=world;
		sprite=new ImageIcon("./src/gameplay/BombSprite.png").getImage();
		
	}
	
	public void explode(){
		remove();
		
	}
	
	
}
