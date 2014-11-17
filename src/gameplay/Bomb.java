package gameplay;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bomb extends GameObject{
	private boolean isSolid;
	private int explosionRadius;

	private int bombCountdown;
	private final int countdownTimer = 3000;// in miliseconds

	public Bomb(Rectangle location, World world,int radius) {
		super(location,world);
		isSolid = true;
		sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();
		bombCountdown=40;
		destroyable=false;
		explosionRadius=radius;
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
