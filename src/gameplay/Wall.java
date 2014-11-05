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
	

	
	public Rectangle getCollisionBorder(){
		return new Rectangle(gridLocation.x,gridLocation.y,gridLocation.width,gridLocation.height);
	}

	public void setXCooridnate(int newXCoordinate){
		gridLocation.x=newXCoordinate;
	}
	
	public void setYCoordinate(int newYCoordinate){
		gridLocation.y=newYCoordinate;
	}

	@Override
	void updateStatus() {
		// TODO Auto-generated method stub
		
	}
}
