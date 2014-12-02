package menuView.menuLogic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import menuView.PanelTransitionManager;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class LevelSelectPanelLogic {
    private static JFrame controllingFrame;
    private PanelTransitionManager manager = PanelTransitionManager.getInstance();

    /**
     * This is sent the numbers of levels unlocked and the currentl level. If
     * this level is "unlocked", or is less that/equal to the levels unlocked it
     * returns true. Other wise it returns false
     * 
     * @param levelsUnlocked
     * @param thisLevel
     * @return
     */

    public boolean visable(int levelsUnlocked, int thisLevel) {
	if (thisLevel > levelsUnlocked)
	    return false;
	return true;
    }

    /**
     * When sent a int that is the level number this will start the game at that
     * level
     * 
     * @param level
     */
    public void play(int level) {
	System.out.println(level);
	manager.displayGamePanel(level);
    }

    /**
     * This displays a controlling frame to tell the user that the level is
     * locked
     */
    public void locked() {
	JOptionPane.showMessageDialog(controllingFrame, "This level is locked");
    }

}
