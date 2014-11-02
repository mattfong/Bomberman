package gameplay;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public GameFrame(){
		initUI();
		
	}
	
	private void initUI(){
		add(new GamePanel());
		setSize(480,416);
		
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main (String[] args){
		
		GameFrame gameFrame=new GameFrame();
		gameFrame.setVisible(true);
		
		
	}

}
