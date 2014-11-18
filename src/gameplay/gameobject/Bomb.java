package gameplay.gameobject;

import gameplay.Direction;
import gameplay.World;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bomb extends GameObject{
	
	private int explosionRadius;

	private int bombCountdown;

	public Bomb(Rectangle location, World world,int radius) {
		super(location,world);
		solid = true;
		sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();
		bombCountdown=40;
		destroyable=false;
		explosionRadius=radius;
		conductsExplosions=false;
	}

	@Override
	public void update() {
		super.update();
		
		bombCountdown--;
		if(checkBombTimer()){
			this.explode();
		}
		

		
		
	}

	public void explode() {
		this.remove();
		world.detonateSpot(gridLocation.x, gridLocation.y, Direction.UP, explosionRadius);
		world.detonateSpot(gridLocation.x, gridLocation.y, Direction.DOWN, explosionRadius);
		world.detonateSpot(gridLocation.x, gridLocation.y, Direction.LEFT, explosionRadius);
		world.detonateSpot(gridLocation.x, gridLocation.y, Direction.RIGHT, explosionRadius);
	}
	
	private boolean checkBombTimer(){
		if (bombCountdown == 0){
			return true;
		}
		return false;
	}


}
