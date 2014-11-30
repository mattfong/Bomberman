package menuView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuDisplay {
	
	public String LM = "loginMenu";
	public String DM = "deleteMenu";
	public String NM = "newMenu";
	DeleteAccountPanel dPanel = new DeleteAccountPanel();
	LoginMenuView lPanel = new LoginMenuView();

	
	MenuFrame frame = new MenuFrame("Bomberman");
	
	public void loginMenu(){
		
		frame.add(lPanel);
	}
	
	public void DeleteAccountPanel(){
		
		frame.add(dPanel);
	}
	
	
	public void display(){
		//JFrame frame = new JFrame("this is a frame");
		
		//JPanel BackgroundPanel = new JPanel();
		BackgroundPanel panel = new BackgroundPanel();
		frame.add(panel);
		
		
	}
	
	public void goTo(String goTo){
		//frame.removeAll();
		frame.revalidate();
		frame.repaint();
		if(goTo.equals(LM)){
			loginMenu();
		}
		
		else if(goTo.equals(DM)){
			DeleteAccountPanel();
		}
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				MenuDisplay md = new MenuDisplay();
				//md.display();
				//md.loginMenu();
				md.DeleteAccountPanel();
			}
		});
	}
}
