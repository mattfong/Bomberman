package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Oneal extends GameActor {

    public Oneal(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Oneal.class.getResource("/Oneal.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

    }

}
