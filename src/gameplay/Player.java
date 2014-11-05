package gameplay;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player extends GameObject{

	private World world;
	
	protected int xDirection, yDirection;
	
	public Player (World world, Rectangle location){
		super(location);
		this.world=world;
		sprite=new ImageIcon("./src/gameplay/Sprite.png").getImage();
		 
	}
	
	public void update(){
	
		move();
		
		if(checkForCollision()){
			imove();
		}
		
		
		
		
	}
	private void move(){
		gridLocation.x+=xDirection;
		gridLocation.y+=yDirection;
		
	}
	private void imove(){
		gridLocation.x-=xDirection;
		gridLocation.y-=yDirection;
		
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
	

	
	public void setXDirection (int d){
		xDirection=d;
	}
	public void setYDirection(int d){
		yDirection=d;
	}

	@Override
	void updateStatus() {
		// TODO Auto-generated method stub
		
	}
}
