package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Class which represents the background for the entire game.
 * 
 * @author mfong8
 */
public class Background extends GameObject {

    public Background(Rectangle location, World world) {
	super(location, world);
	solid = false;
	sprite = new ImageIcon(Background.class.getResource("/Background.png"));
	destroyable = false;
	conductsExplosions = true;
    }

}
