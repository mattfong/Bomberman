package gameplay.engine;

import gameplay.gameobject.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.World;

import javax.swing.JFrame;

/**
 * GameFrame which contains the Bomberman game.
 * 
 * @author MF
 */
public class GameFrame extends JFrame {

    /**
     * Start a game at the level specified within the parameter.
     * 
     * @param level
     *            level enum representing the level to be loaded.
     */
    public GameFrame(Level level) {
	initUI(level);

    }

    /**
     * Starts a game from the world specified.
     * 
     * @param world
     *            world that is to be loaded.
     */
    public GameFrame(World world) {
	initUI(world);
    }

    public GameFrame() {
	initUI(Level.L1);
    }

    private void initUI(World world) {
	add(new GamePanel(world));
	setSize(480, 440);
	setTitle("Bomberman");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
    }

    private void initUI(Level level) {
	add(new GamePanel(level));
	setSize(480, 440);
	setTitle("Bomberman");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
    }

    public static void main(String[] args) {

	GameStateManager manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(100));

	GameFrame gameFrame = new GameFrame(Level.L1);
	gameFrame.setVisible(true);

    }

}
