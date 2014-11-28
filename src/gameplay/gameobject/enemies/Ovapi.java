package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ovapi extends GameActor {

    public Ovapi(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Ovapi.class.getResource("/EvilSprite.png"));
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 2000;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

    public Ovapi(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
