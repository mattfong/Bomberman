package gameplay.powerups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import gameplay.World;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;

public class DetonatorPowerup extends GameObject implements Powerup {

	public DetonatorPowerup(Rectangle location, World world) {
		super(location,world);
		sprite=new ImageIcon(DetonatorPowerup.class.getResource("/PowerupDetonator.png")).getImage();
		
		destroyable=true;
		solid = false;
		conductsExplosions=false;
		
	}

	@Override
	public void applyPowerup(GameActor actor) {
		actor.setDetonator(true);
	}

}
