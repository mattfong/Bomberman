package gameplay.gameobject;

import gameplay.World;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {

	protected Rectangle gridLocation;

	protected Image sprite;
	protected final int pictureSize=32;
	protected World world;
	
	protected boolean solid;
	protected boolean destroyable;
	protected boolean conductsExplosions;
	
	//Constructor
	public GameObject(Rectangle location, World world){
		gridLocation=location;
		this.world=world;
	}
	
	
	//Game Engine Stuff
	public void draw(Graphics g){
		
		g.drawImage(sprite, gridLocation.x,gridLocation.y,null);	
	}
	
	public void update(){
		
	}
	
	
	

	
	//Getters and setters
	
	public boolean isDestroyable(){
		return destroyable;
	}
	
	public boolean isSolid(){
		return solid;
	}
	
	public int getXCoordinate(){
		return gridLocation.x;
	}
	
	public int getYCoordinate(){
		return gridLocation.y;
	}
	
	public void setXCoordinate(int newXCoord){
		gridLocation.x=newXCoord;
	}
	
	public void setYCoordinate(int newYCoord){
		gridLocation.y=newYCoord;
	}
	
	public int getWidth(){
		return pictureSize;
	}
	
	public int getHeight(){
		return pictureSize;
	}
	
	public void destroy(){
		world.removeGameObject(this);
	}
	
	public Rectangle getCollisionBoundaries(){
		return new Rectangle(this.gridLocation.x, this.gridLocation.y, pictureSize,pictureSize);
	}
	//Colision detection stuff

	
	public boolean hasCollided(GameObject obj){
		if(gridLocation.intersects(obj.getCollisionBoundaries())){
			return true;
		}
		return false; 
	}
	
	public boolean conductsExplosions(){
		return conductsExplosions;
	}

	
}
