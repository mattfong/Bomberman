package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author mfong8 Class which represents the background for the entire game.
 */
public class Background extends GameObject {

    public Background(Rectangle location, World world) {
	super(location, world);
	solid = false;
	sprite = new ImageIcon(Background.class.getResource("/Background.png")).getImage();
	destroyable = false;
	conductsExplosions = true;
    }

}
