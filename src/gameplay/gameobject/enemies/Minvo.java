package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.ai.Speed;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

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
	inputManager = new CommandManager(this, new DumbAI(this, Speed.FAST));
    }

    public Minvo(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }

}
