package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;
import gameplay.input.ai.AverageAI;
import gameplay.input.ai.Speed;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Pontan enemy requirement.
 * 
 * @author MF
 */
public class Pontan extends GameActor {

    public Pontan(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Pontan.class.getResource("/Pontan.jpg"));
	score = 8000;
	wallPass = true;
	inputManager = new CommandManager(this, new AverageAI(this, Speed.FAST));
    }

    public Pontan(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
