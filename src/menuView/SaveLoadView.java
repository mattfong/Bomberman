package menuView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaveLoadView extends JPanel {

	public SaveLoadView() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(4,1,5,10));
		JLabel saveLoadMenuLabel = new JLabel("Save Load Menu");
		saveLoadMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
	    JButton saveGameButton = new JButton("Save Game");
		JButton loadGameButton = new JButton("Load Game");
	    JButton goBackButton = new JButton("goBack");
	    
		saveGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});

		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});
		
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				f.dispose();
			}
		});		
	    add(saveLoadMenuLabel);
	    add(saveGameButton);
	    add(loadGameButton);
	    add(goBackButton);
	}
}
