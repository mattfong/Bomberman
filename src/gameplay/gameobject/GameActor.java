package gameplay.gameobject;

import gameplay.World;

import java.awt.Rectangle;

public class GameActor extends GameObject {

	protected int moveSpeed=32;
	protected boolean wallPass;
	protected boolean bombPass;
	protected boolean flamePass;

	public GameActor(Rectangle location, World world){
		super(location, world);
		conductsExplosions=true;
	
	}
	public void update(){
		
	}
	
	private boolean hasCollided(){

		return world.checkForCollision(this);

	}

	
	public void moveLeft(){
		gridLocation.x=gridLocation.x-moveSpeed;
		if(hasCollided()){
			gridLocation.x=gridLocation.x+moveSpeed;
		}
			
	}

	public void moveRight(){
		gridLocation.x=gridLocation.x+moveSpeed;
		if(hasCollided()){
			gridLocation.x=gridLocation.x-moveSpeed;
		}
	}
	 
	public void moveUp(){
		gridLocation.y=gridLocation.y-moveSpeed;
		if(hasCollided()){
			gridLocation.y=gridLocation.y+moveSpeed;
		}
	} 
	
	public void moveDown(){
		gridLocation.y=gridLocation.y+this.moveSpeed;
		if(hasCollided()){
			gridLocation.y=gridLocation.y-moveSpeed;
		}
		
	}
}
