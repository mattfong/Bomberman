package gameplay.gameobject.blocks;

import gameplay.gameobject.GameObject;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Wall GameObject.
 * 
 * @author mfong8
 */
public class Wall extends GameObject {

    public Wall(Rectangle location, World world) {
	super(location, world);

	sprite = new ImageIcon(Wall.class.getResource("/HardBlock.png"));

	destroyable = false;
	solid = true;
	conductsExplosions = false;

    }

}
