package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Doll extends GameActor {

    public Doll(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Doll.class.getResource("/Doll.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());
    }

}
