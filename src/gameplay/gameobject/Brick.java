package gameplay.gameobject;

import gameplay.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Brick extends GameObject {
	
	
	public Brick(Rectangle location, World world){
		super(location,world); 
		solid=true;
		destroyable=true;
		sprite=new ImageIcon(Brick.class.getResource("/SoftBlock.png")).getImage();
		
	}

}
