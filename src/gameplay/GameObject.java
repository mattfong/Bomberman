package gameplay;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {

	protected Rectangle gridLocation;
	protected boolean isDestroyed;
	//protected GameBoard board; 
	protected Image sprite;
	protected final int pictureSize=32;
	abstract void updateStatus();
	
	public GameObject(Rectangle location){
		gridLocation=location;
	}
	
	public void draw(Graphics g){
		
		g.drawImage(sprite, gridLocation.x,gridLocation.y,null);	
	}
	//Using rectangle method as it contains the intersect method
	public Rectangle getCollisionBoundaries(){
		return new Rectangle(this.gridLocation.x, this.gridLocation.y, pictureSize,pictureSize);
	}
	
	
	public boolean hasCollided(GameObject obj){
		if(gridLocation.intersects(obj.getCollisionBoundaries())){
			return true;
		}
		return false; 
	}
	
	
	public void setXCoordinate(int newXCoord){
		gridLocation.x=newXCoord;
	}
	
	public void setYCoordinate(int newYCoord){
		gridLocation.y=newYCoord;
	}
	
	public int getWidth(){
	
		return gridLocation.x;
	
	}
	
	public int getHeight(){
		return gridLocation.y;
	}
	
	
	
	
	
	public boolean checkIfBombed (){
		
		return true; //TOFIX	
	}
	
	
}
