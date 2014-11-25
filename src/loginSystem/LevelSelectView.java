package loginSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LevelSelectView {
	JTextField jt= new JTextField(30);
	
	public int intoInt(String number){
		return Integer.parseInt(number);
	}
	public void levelSelectMenu(){
		jt.setText(null);
		final JFrame f = new JFrame("Enter Level");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1,5,10));
		
		
		JButton goToLevel = new JButton("Enter your desired level and click here. Only enter numbers.");
		goToLevel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String toInt;
				int levelSelected = 0;
				toInt=jt.getText();		
				levelSelected=intoInt(toInt);
				System.out.println(levelSelected);
				f.dispose();
			
			}
		});	
		panel.add(jt);
		panel.add(goToLevel);
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(480, 440);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);

	}
	
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				LevelSelectView PMV = new LevelSelectView();
				
				
				PMV.levelSelectMenu();
			}
		});
	}
}
