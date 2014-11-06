package gameplay;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb extends GameObject {
	private boolean isSolid;
	private int explosionRadius;
	public Bomb(Rectangle location){
		super(location); 
		isSolid=true;
		sprite=new ImageIcon("./src/gameplay/BombSprite.png").getImage();
		
	}
}
