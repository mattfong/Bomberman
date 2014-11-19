package gameplay.powerups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import gameplay.World;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;

public class FlamePowerup extends GameObject implements Powerup{

	public FlamePowerup(Rectangle location, World world) {
		super(location,world);
		sprite=new ImageIcon(FlamePowerup.class.getResource("/PowerupFlamepass.png")).getImage();
		
		destroyable=true;
		solid = false;
		conductsExplosions=false;
		
	}

	@Override
	public void applyPowerup(GameActor actor) {
		actor.increaseExplosionRadius();
	}

}
