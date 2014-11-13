package gameplay;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall extends GameObject {
	private boolean isSolid;
	
	public Wall(Rectangle location){
		super(location); 
		isSolid=true;
		sprite=new ImageIcon(Wall.class.getResource("/HardBlock.png")).getImage();
		
	}

}
