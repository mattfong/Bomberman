package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;
import gameplay.input.ai.AverageAI;
import gameplay.input.ai.Speed;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Ovapi enemy requirement.
 * 
 * @author MF
 */
public class Ovapi extends GameActor {

    public Ovapi(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Ovapi.class.getResource("/EvilSprite.png"));
	score = 2000;
	wallPass = false;
	inputManager = new CommandManager(this, new AverageAI(this, Speed.SLOW));
    }

    public Ovapi(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
