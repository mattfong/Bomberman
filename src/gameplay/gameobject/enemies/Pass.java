package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pass extends GameActor {

    public Pass(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Pass.class.getResource("/Pass.jpg"));
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 4000;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

    public Pass(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
