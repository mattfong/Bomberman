package gameplay.powerups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import gameplay.World;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;

public class WallPassPowerup extends GameObject implements Powerup{

	public WallPassPowerup(Rectangle location, World world) {
		super(location,world);
		sprite=new ImageIcon(WallPassPowerup.class.getResource("/PowerupWallpass.png")).getImage();
		
		destroyable=true;
		solid = false;
		conductsExplosions=false;
		
	}

	@Override
	public void applyPowerup(GameActor actor) {
		actor.setWallPass(true);
	}

}
