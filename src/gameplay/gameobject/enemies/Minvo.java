package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Minvo extends GameActor {

    public Minvo(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Minvo.class.getResource("/Minvo.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

	score = 800;
	wallPass = false;
    }

}
