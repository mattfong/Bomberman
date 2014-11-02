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
		playerRect=new Rectangle(0,0,20,20);
	
	
	
		
	}
	
	public void update(){
		move();
		checkForCollision();
		
		
	}
	private void move(){
		playerRect.x+=xDirection;
		playerRect.y+=yDirection;
		
	}
	private void checkForCollision(){
		
	}
	
	public void draw(Graphics g){
		g.drawImage(playerImg, playerRect.x, playerRect.y, null);
	}
	
	private void setXDirection (int d){
		xDirection=d;
	}
	private void setYDirection(int d){
		yDirection=d;
	}
}
