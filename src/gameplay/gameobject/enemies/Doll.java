package gameplay.gameobject.enemies;

import gameplay.gameobject.GameActor;
import gameplay.input.ai.DumbAI;
import gameplay.input.ai.Speed;
import gameplay.input.commandobjects.CommandManager;
import gameplay.world.World;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Implementation of the Doll enemy requirements.
 * 
 * @author MF
 */
public class Doll extends GameActor implements Cloneable {

    public Doll(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Doll.class.getResource("/Doll.jpg"));
	score = 400;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this, Speed.NORMAL));
    }

    public Doll(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
