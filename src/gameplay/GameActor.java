package gameplay;

import java.awt.Rectangle;

public class GameActor extends GameObject {

	protected int moveSpeed=32;
	protected World world;
	

	public GameActor(World world, Rectangle location){
		super(location);
		this.world=world;	
	}
	public void update(){
		
	}
	private boolean checkForCollision(){
		int width=world.getGridWidth();
		int height=world.getGridHeight();
		
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				if(world.grid[i][j]!=null){ //TODO: Implement a way to deal with null cases, unused grid elements are set to null
					if(world.grid[i][j].hasCollided(this)){
						return true;	
					}
				}


			}
		}
		return false;
	}

	
	public void moveLeft(){
		gridLocation.x=gridLocation.x-moveSpeed;
		if(checkForCollision()){
			gridLocation.x=gridLocation.x+moveSpeed;
		}
			
	}
	public void moveRight(){
		gridLocation.x=gridLocation.x+moveSpeed;
		if(checkForCollision()){
			gridLocation.x=gridLocation.x-moveSpeed;
		}
	}
	
	public void moveUp(){
		gridLocation.y=gridLocation.y-moveSpeed;
		if(checkForCollision()){
			gridLocation.y=gridLocation.y+moveSpeed;
		}
	} 
	
	public void moveDown(){
		gridLocation.y=gridLocation.y+this.moveSpeed;
		if(checkForCollision()){
			gridLocation.y=gridLocation.y-moveSpeed;
		}
		
	}
}
