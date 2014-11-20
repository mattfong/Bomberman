package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Kondoria extends GameActor {

    public Kondoria(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Kondoria.class.getResource("/Kondogira.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

    }
}
