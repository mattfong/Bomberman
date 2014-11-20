package gameplay.gameobject.blocks;

import gameplay.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Implementation of the Brick game block which represent
 *         destroyable walls.
 */
public class Brick extends GameObject {

    public Brick(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Brick.class.getResource("/SoftBlock.png")).getImage();

	solid = true;
	destroyable = true;
	conductsExplosions = false;

    }

}
