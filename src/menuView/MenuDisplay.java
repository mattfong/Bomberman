package menuView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuDisplay {
	
	//JFrame MenuFrame = new JFrame("Try1");
	JFrame MenuFrame = new JFrame();
	//JPanel LoginMenuView = new JPanel();
	JPanel BackgroundPanel = new JPanel();
	
	public void display(){
		//MenuFrame.add(LoadGameMenuView);
		MenuFrame.add(BackgroundPanel);
		//MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MenuFrame.setSize(480, 440);
		//MenuFrame.setLocationRelativeTo(null);
		//MenuFrame.setResizable(false);
		MenuFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				MenuDisplay md = new MenuDisplay();
				md.display();
			}
		});
	}
}
