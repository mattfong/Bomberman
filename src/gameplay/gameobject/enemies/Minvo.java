package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Minvo extends GameActor {

    public Minvo(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Minvo.class.getResource("/Minvo.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());

	score = 800;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

    public Minvo(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }

}
