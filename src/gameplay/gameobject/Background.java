package gameplay.gameobject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import gameplay.World;

public class Background extends GameObject {

    public Background(Rectangle location, World world) {
	super(location, world);
	solid = false;
	sprite = new ImageIcon(Background.class.getResource("/Background.png")).getImage();
	destroyable = false;
	conductsExplosions = false;
    }

}
