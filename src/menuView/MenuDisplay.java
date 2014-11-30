package menuView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuDisplay {
	/*
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
	*/
	
	public void display(){
		//JFrame frame = new JFrame("this is a frame");
		MenuFrame frame = new MenuFrame("This is my menu fra,e");
		//JPanel BackgroundPanel = new JPanel();
		BackgroundPanel panel = new BackgroundPanel();
		frame.add(panel);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//	frame.setSize(480, 440);
				//frame.setLocationRelativeTo(null);
				//frame.setResizable(false);
				//frame.setVisible(true);
		
		
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
