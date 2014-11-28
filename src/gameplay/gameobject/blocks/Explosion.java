package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explosion extends GameObject {

	private int frameDelay;
	
	public Explosion(Rectangle location, World world, int frameDelay ) {
		super(location,world);
		sprite = new ImageIcon(Explosion.class.getResource("/explosion.png"));
		this.frameDelay=frameDelay;
		solid = false;
		destroyable = false;
		conductsExplosions = true;
		
	}
	
	@Override
	public void update(){
		if(frameDelay==0){
			this.destroy();
		}
		
		frameDelay--;
		
	}

}
