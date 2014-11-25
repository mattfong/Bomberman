package gameplay.pauseMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelManager {

    private static PanelManager singleton = null;
    private JFrame currentFrame;
    private JPanel parentPanel;

    public PanelManager() {
    }

    public static PanelManager getInstance() {
	if (singleton == null) {
	    singleton = new PanelManager();
	}
	return singleton;
    }

    public JPanel getParentPanel() {
	return parentPanel;
    }

    public void setParentPanel(JPanel parentPanel) {
	this.parentPanel = parentPanel;
    }

}
