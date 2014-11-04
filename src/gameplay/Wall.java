package gameplay;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall {
	private Rectangle gridLocation;
	private final boolean isSolid=true;
	private Image blockSprite;
	
	public Wall(Rectangle location){
		blockSprite= new ImageIcon("./src/gameplay/HardBlock.png").getImage();
		gridLocation=location;
	}
	
	public void draw(Graphics g){
		g.drawImage(blockSprite, gridLocation.x,gridLocation.y,null);	
	}
	
	public Rectangle getCollisionBorder(){
		return new Rectangle(gridLocation.x,gridLocation.y,gridLocation.width,gridLocation.height);
	}

	public void setXCooridnate(int newXCoordinate){
		gridLocation.x=newXCoordinate;
	}
	
	public void setYCoordinate(int newYCoordinate){
		gridLocation.y=newYCoordinate;
	}
}
