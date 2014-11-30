package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.ai.Speed;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * @author MF Implementation of the Ovapi enemy requirement.
 */
public class Ovapi extends GameActor {

    public Ovapi(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Ovapi.class.getResource("/EvilSprite.png"));
	score = 2000;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this, Speed.SLOW));
    }

    public Ovapi(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
