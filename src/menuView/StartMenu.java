package menuView;

import javax.swing.SwingUtilities;

public class StartMenu {
	//static boolean a = true;
	
	public static void main(String[] args){
		
		//MenuDisplay.main(null);
		PanelTransitionManager manager = PanelTransitionManager.getInstance();
		manager.displayLoginMenu();
	}
	
}
