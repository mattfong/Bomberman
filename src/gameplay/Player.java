package gameplay;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {

	private World world;
	
	private Rectangle playerRect;
	private Image playerImg;
	
	protected int xDirection, yDirection;
	
	public Player (World world){
		this.world=world;
		playerImg=new ImageIcon("./src/gameplay/Sprite.png").getImage();
		playerRect=new Rectangle(32,32,20,20);
	
	
	
		 
	}
	
	public void update(){
		//System.out.println(checkForCollision());
		move();
		if(checkForCollision()){
			imove();
		}
		
		
		
		
	}
	private void move(){
		playerRect.x+=xDirection;
		playerRect.y+=yDirection;
		
	}
	private void imove(){
		playerRect.x-=xDirection;
		playerRect.y-=yDirection;
		
	}
	private boolean checkForCollision(){
		for(int i=0;i<world.arrayNum;i++){

			if(world.isSolid[i]&&playerRect.intersects(world.blocks[i])){

				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics g){
		g.drawImage(playerImg, playerRect.x, playerRect.y, null);
	}
	
	public void setXDirection (int d){
		xDirection=d;
	}
	public void setYDirection(int d){
		yDirection=d;
	}
}
