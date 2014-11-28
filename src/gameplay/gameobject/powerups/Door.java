package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.powerups.Powerup;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Door extends GameObject implements Powerup {

    public Door(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Door.class.getResource("/OpenedDoor.jpg"));

	destroyable = true;
	solid = false;
	conductsExplosions = false;

    }

    @Override
    public void applyPowerup(BombermanInterface bomberman) {
	bomberman.moveToNextLevel();
    }

}
