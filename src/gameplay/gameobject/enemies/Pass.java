package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;
import gameplay.input.ai.AverageAI;
import gameplay.input.ai.Speed;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Pass enemy requirement.
 * 
 * @author MF
 */
public class Pass extends GameActor {

    public Pass(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Pass.class.getResource("/Pass.jpg"));
	score = 4000;
	wallPass = false;
	inputManager = new CommandManager(this, new AverageAI(this, Speed.FAST));
    }

    public Pass(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
