package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pontan extends GameActor {

    public Pontan(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Pontan.class.getResource("/Pontan.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

    }

}
