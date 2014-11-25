package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Kondoria extends GameActor {

    public Kondoria(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Kondoria.class.getResource("/Kondoria.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 1000;
	wallPass = true;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

    public Kondoria(World world) {
	this(new Rectangle(0, 0, 32, 32), world);

    }
}
