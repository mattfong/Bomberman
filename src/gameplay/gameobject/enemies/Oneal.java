package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Oneal extends GameActor {

    public Oneal(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Oneal.class.getResource("/Oneal.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 200;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

}
