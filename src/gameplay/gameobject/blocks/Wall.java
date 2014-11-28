package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Implementation of the Wall GameObject.
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
