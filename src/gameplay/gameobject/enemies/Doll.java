package gameplay.gameobject.enemies;

import gameplay.World;
import gameplay.ai.DumbAI;
import gameplay.gameobject.GameActor;
import gameplay.input.CommandManager;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Doll extends GameActor implements Cloneable {

    public Doll(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Doll.class.getResource("/Doll.jpg")).getImage();
	// inputManager = new CommandManager(this, InputListener.getInstance());
	score = 400;
	wallPass = false;
	inputManager = new CommandManager(this, new DumbAI(this));
    }

}
