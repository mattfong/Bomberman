package gameplay.gameobject;

import gameplay.Direction;
import gameplay.World;

import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Bomb extends GameObject{
	
	private int explosionRadius;

	private int bombCountdown;

	public Bomb(Rectangle location, World world,int radius) {
		super(location,world);
		sprite = new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();
		
		destroyable=false;
		solid = true;
		conductsExplosions=false;
		
		bombCountdown=40;
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
		this.destroy();
		world.detonateLine(gridLocation.x, gridLocation.y, Direction.UP, explosionRadius);
		world.detonateLine(gridLocation.x, gridLocation.y, Direction.DOWN, explosionRadius);
		world.detonateLine(gridLocation.x, gridLocation.y, Direction.LEFT, explosionRadius);
		world.detonateLine(gridLocation.x, gridLocation.y, Direction.RIGHT, explosionRadius);
	}
	
	private boolean checkBombTimer(){
		if (bombCountdown == 0){
			return true;
		}
		return false;
	}


}
