package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.ai.DumbAI;
import gameplay.input.ai.Speed;
import gameplay.input.commandobjects.CommandManager;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Oneal enemy class implementation.
 * 
 * @author MF
 */
public class Oneal extends GameActor {

    public Oneal(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Oneal.class.getResource("/Oneal.jpg"));
	score = 200;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this, Speed.NORMAL));
    }

    public Oneal(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
