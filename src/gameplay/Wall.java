package gameplay;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall extends GameObject {
	private boolean isSolid;
	
	public Wall(Rectangle location){
		super(location); 
		isSolid=true;
		sprite=new ImageIcon("./src/gameplay/HardBlock.png").getImage();
		
	}

}
