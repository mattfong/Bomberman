package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.gameobject.GameActor;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Balloon extends GameActor {

    public Balloon(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Balloon.class.getResource("/Balloon.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 100;
	wallPass = false;

    }
}
