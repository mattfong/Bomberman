package loginSystem;
import gameplay.engine.GamePanel;

import javax.swing.JFrame;

public class LoginFrame extends JFrame{
	public LoginFrame(){
		initUI();
		
	}	
	public JFrame frame(){
		initUI();
		return null;
	}
	private void initUI(){
		//add(new GamePanel());
		setSize(480, 440);
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main (String[] args){
		
		LoginFrame loginFrame=new LoginFrame();
		
		
	}
}
