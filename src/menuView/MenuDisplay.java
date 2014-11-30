package menuView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuDisplay {
	
	public String LM = "loginMenu";
	public String DM = "deleteMenu";
	public String NM = "newMenu";
	public String PG = "playMenu";
	DeleteAccountPanel dPanel = new DeleteAccountPanel();
	LoginMenuView lPanel = new LoginMenuView();
	PlayGameView pPanel = new PlayGameView();
	//newAccount
	
	

	MenuFrame frame = new MenuFrame("Bomberman");
	
	
	
	
	
	
	
	
	public void newMenu(){
		//frame.add(nPanel);
	}
	
	public void loginMenu(){
		
		frame.add(lPanel);
	}
	
	public void DeleteAccountPanel(){
		
		frame.add(dPanel);
	}
	
	public void PlayGameMenu(){
		frame.add(pPanel);
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
				md.loginMenu();
			}
		});
	}

}
