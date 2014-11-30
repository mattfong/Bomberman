package gameplay.input;

import gameplay.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author MF InputListener listens to the keyboard and caches input and holds
 *         it until another system poll's the InputListener for the last command
 *         issued by the user. Implemented via the singleton pattern to allow
 *         access throughout the entire system. To implement speed, getCommand()
 *         only returns a command on every n-th call, calling
 *         increaseQuerySpeed() decreases the number of polls necessary to
 *         generate a new command.
 */
public class InputListener extends KeyAdapter implements CommandIssuer {

    private static InputListener singleton = null;
    private static KeyEvent bufferedKey;
    private static GamePanel gamePanel;
    private static int queryDelay;
    private static int pollCounter;

    protected InputListener() {
	pollCounter = 0;
	queryDelay = 4;
    }

    public static InputListener getInstance() {
	if (singleton == null) {
	    singleton = new InputListener();
	}
	return singleton;
    }

    public static void setGamePanel(GamePanel panel) {
	gamePanel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	    gamePanel.openPauseMenu();
	}
	bufferedKey = e;

    }

    /**
     * Increases the speed at which the listener responds to polls.
     */
    public void increaseQuerySpeed() {
	queryDelay--;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public Command getCommand() {

	pollCounter++;
	if ((pollCounter % queryDelay) == 0) {
	    if (bufferedKey != null) {
		if (bufferedKey.getKeyCode() == KeyEvent.VK_LEFT) {
		    bufferedKey = null;
		    return new CommandLeft();
		}
		if (bufferedKey.getKeyCode() == KeyEvent.VK_RIGHT) {
		    bufferedKey = null;
		    return new CommandRight();
		}
		if (bufferedKey.getKeyCode() == KeyEvent.VK_UP) {
		    bufferedKey = null;
		    return new CommandUp();
		}
		if (bufferedKey.getKeyCode() == KeyEvent.VK_DOWN) {
		    bufferedKey = null;
		    return new CommandDown();
		}
		if (bufferedKey.getKeyCode() == KeyEvent.VK_SPACE) {
		    bufferedKey = null;
		    return new CommandPlaceBomb();
		}
		if (bufferedKey.getKeyCode() == KeyEvent.VK_X) {
		    bufferedKey = null;
		    return new CommandDetonateBomb();
		}
	    }
	}
	return null;
    }
}
