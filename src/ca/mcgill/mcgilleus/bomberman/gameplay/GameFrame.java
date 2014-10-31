package ca.mcgill.mcgilleus.bomberman.gameplay;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	public GameFrame(){
		initUI();
		
	}
	
	private void initUI(){
		add(new GameBoard());
		setSize(800,800);
		
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main (String[] args){
		
		GameFrame gameFrame=new GameFrame();
		gameFrame.setVisible(true);
		
	}

}
