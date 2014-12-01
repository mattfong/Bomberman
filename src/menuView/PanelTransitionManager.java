package menuView;

import javax.swing.JFrame;

public class PanelTransitionManager {
	
	private static PanelTransitionManager singleton = null;
	private JFrame frame;
	
	private PanelTransitionManager() {
		frame = new JFrame();
		initUI();
	}
	
	public static PanelTransitionManager getInstance() {
		if(singleton == null) {
			singleton = new PanelTransitionManager();
		}
		return singleton;
	}
	
	private void initUI(){
		frame.setSize(480, 440);
		frame.setTitle("Bomberman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void displayLoginMenu(){
		LoginMenuPanel loginMenu = new LoginMenuPanel();
		frame.setContentPane(loginMenu);
		frame.invalidate();
		frame.validate();
	}
	
	public void displayPlayGameMenu(){
		PlayGamePanel playMenu = new PlayGamePanel();
		frame.setContentPane(playMenu);
		frame.invalidate();
		frame.validate();
	}
	
}
