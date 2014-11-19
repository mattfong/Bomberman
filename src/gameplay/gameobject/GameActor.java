package gameplay.gameobject;

import gameplay.World;

import java.awt.Rectangle;

public class GameActor extends GameObject {

	protected int moveSpeed=32;
	

	protected int bombLimit;
	protected boolean wallPass;
	protected boolean bombPass;
	protected boolean flamePass;
	protected boolean detonator;
	protected int explosionRadius;
	public GameActor(Rectangle location, World world){
		super(location, world);
		
		conductsExplosions=true;
		wallPass=false;
		bombPass=false;
		flamePass=false;
		detonator=false;
		explosionRadius=1;
	}
	
	public void update(){
		
	}
	
	private boolean hasCollided(){

		return world.checkForCollision(this);

	}
	
	public boolean canDetonateBomb(){
		return detonator;
		
	}
	
	public boolean canWallPass(){
		return wallPass;
	}
	
	public boolean canBombPass(){
		return bombPass;
	}
	
	public void increaseExplosionRadius(){
		this.explosionRadius++;
	}
	
	public void increaseBombLimit(){
		this.bombLimit++;
	}
	/**
	 * Fun method name
	 * @return
	 */
	public boolean canTakeTheHeat(){
		return flamePass;
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
	
	
	public void setWallPass(boolean wallPass) {
		this.wallPass = wallPass;
	}

	public void setBombPass(boolean bombPass) {
		this.bombPass = bombPass;
	}

	public void setFlamePass(boolean flamePass) {
		this.flamePass = flamePass;
	}

	public void setDetonator(boolean detonator) {
		this.detonator = detonator;
	}
}
	