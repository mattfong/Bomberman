package menuView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SaveLoadPanel extends JPanel {

	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public SaveLoadPanel() {
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
				
			}
		});

		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		add(saveLoadMenuLabel);
	    add(saveGameButton);
	    add(loadGameButton);
	    add(goBackButton);
	    
		saveLoadMenuLabel.setBounds(70, 30, 163, 40);
		saveGameButton.setBounds(85, 180, 134, 25);
		loadGameButton.setBounds(85, 180, 134, 25);
		goBackButton.setBounds(85, 180, 134, 25);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
}
