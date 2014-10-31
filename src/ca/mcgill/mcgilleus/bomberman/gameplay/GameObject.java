package ca.mcgill.mcgilleus.bomberman.gameplay;

import javax.swing.ImageIcon;

public abstract class GameObject {

	protected int xCoordinate;
	protected int yCoordinate;
	protected boolean isDestroyed;
	protected GameBoard board; 
	protected ImageIcon objectImage;
	
	

	
	public boolean hasCollided(GameObject otherObject){
		return true; //TO-FIX
	}
	
	abstract void updateStatus();
	
	public boolean checkIfBombed (){
		
		return true; //TOFIX	
	}
	
	
}
