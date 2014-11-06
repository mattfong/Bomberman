package gameplay;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Brick extends GameObject {
	private boolean isSolid;
	
	public Brick(Rectangle location){
		super(location); 
		isSolid=true;
		sprite=new ImageIcon("./src/gameplay/SoftBlock.png").getImage();
		
	}

}
