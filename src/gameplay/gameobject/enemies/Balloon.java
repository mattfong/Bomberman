package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.ai.DumbAI;
import gameplay.input.ai.Speed;
import gameplay.input.commandobjects.CommandManager;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Balloon enemy requirements.
 * 
 * @author MF
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
