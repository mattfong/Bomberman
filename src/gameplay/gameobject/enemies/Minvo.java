package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;
import gameplay.input.ai.AverageAI;
import gameplay.input.ai.Speed;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Minvor requirements.
 * 
 * @author MF
 */
public class Minvo extends GameActor {

    public Minvo(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Minvo.class.getResource("/Minvo.jpg"));
	score = 800;
	wallPass = false;
	inputManager = new CommandManager(this, new AverageAI(this, Speed.FAST));
    }

    public Minvo(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }

}
