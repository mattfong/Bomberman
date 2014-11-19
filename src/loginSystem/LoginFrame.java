package loginSystem;

import javax.swing.JFrame;

public class LoginFrame extends JFrame{
	public LoginFrame(){
		initUI();
		
	}	
	
	private void initUI(){
		//add(new LoginPanel());
		setSize(992,448);
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main (String[] args){
		
		LoginFrame loginFrame=new LoginFrame();
		loginFrame.setVisible(true);
		
		
	}
}
