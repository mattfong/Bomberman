package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ovapi extends GameActor {

    public Ovapi(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Ovapi.class.getResource("/Ovapi.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

    }

}
