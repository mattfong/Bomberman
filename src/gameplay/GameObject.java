package gameplay;

import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public abstract class GameObject {

	private Recantgle gridLocation;
	protected boolean isDestroyed;
	protected GameBoard board; 
	protected ImageIcon objectImage;
	protected GameObject Object;
	private final Image blockSprite= new ImageIcon("./src/gameplay/HardBlock.png").getImage();
	
	public GameObject(Rectangle location){
		
	}
	
	public GameObject(){
		//TOFIX: Java complaining here
	}
	
	//Using rectangle method as it contains the intersect method
	public Rectangle getBounds(int width, int height){
		return new Rectangle(this.xCoordinate, this.yCoordinate, width, height);
	}
	
	
	//This takes a list of other objects as input and loops through them. If it collides, it returns true.  
	public boolean hasCollided(LinkedList <GameObject> listOfGameObjects){
		
		for (int i = 0; i < listOfGameObjects.size(); i++){
			
			if(this.Object.getBounds(this.Object.getWidth(), this.Object.getHeight()).intersects(listOfGameObjects.get(i).getBounds(getWidth(), getHeight()))){
				return true;
			}
			
		}
		
		return false; 
	}
	
	
	//To fix
	public int getWidth(){
	
		return 0;
	
	}
	
	
	//To fix
	public int getHeight(){
		return 0;
	}
	
	
	
	abstract void updateStatus();
	
	public boolean checkIfBombed (){
		
		return true; //TOFIX	
	}
	
	
}
