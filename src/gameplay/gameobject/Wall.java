package gameplay.gameobject;

import gameplay.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall extends GameObject {
	private boolean isSolid;
	
	public Wall(Rectangle location, World world){
		super(location, world); 
		isSolid=true;
		sprite=new ImageIcon(Wall.class.getResource("/HardBlock.png")).getImage();
		destroyable=false;
		conductsExplosions=false;
		
	}

}
