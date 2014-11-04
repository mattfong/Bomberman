package gameplay;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public abstract class GameObject {

	protected Rectangle gridLocation;
	protected boolean isDestroyed;
	//protected GameBoard board; 
	protected Image sprite;
	
	abstract void updateStatus();
	
	public GameObject(Rectangle location){
		gridLocation=location;
	}
	
	
	//Using rectangle method as it contains the intersect method
	public Rectangle getCollisionBoundaries(int width, int height){
		return new Rectangle(this.gridLocation.x, this.gridLocation.y, width, height);
	}
	
	
	//This takes a list of other objects as input and loops through them. If it collides, it returns true.  
	public boolean hasCollided(LinkedList <GameObject> listOfGameObjects){
		
		for (int i = 0; i < listOfGameObjects.size(); i++){
			
			if(this.Object.getCollisionBoundaries(this.Object.getWidth(), this.Object.getHeight()).intersects(listOfGameObjects.get(i).getCollisionBoundaries(getWidth(), getHeight()))){
				return true;
			}
			
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
