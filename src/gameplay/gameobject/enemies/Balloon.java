package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.ai.Speed;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author MF Implementation of the Balloon enemy requirements.
 */
public class Balloon extends GameActor {

    public Balloon(Rectangle location, World world) {
	super(location, world);

	sprite = new ImageIcon(Balloon.class.getResource("/Balloon.jpg"));
	inputManager = new CommandManager(this, null);
	score = 100;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this, Speed.SLOW));
    }

    public Balloon(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
