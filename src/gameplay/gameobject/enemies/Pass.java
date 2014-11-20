package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pass extends GameActor {

    public Pass(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Pass.class.getResource("/Pass.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

    }

}
