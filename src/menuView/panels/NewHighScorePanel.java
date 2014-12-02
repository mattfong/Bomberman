package menuView.panels;

import gameplay.world.World;
import highscore.HighScoreManager;
import highscore.Players;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import menuView.PanelTransitionManager;
/**
 * Redesigned Highscore Panel to accommodate with the panel transition manager.  
 * @author Kirththiga Murugupillai
 *
 */
public class NewHighScorePanel extends JPanel{

	HighScoreManager highScoreManager = new HighScoreManager();
    private PanelTransitionManager manager = PanelTransitionManager.getInstance();
    private JList list;
	
	public NewHighScorePanel() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new FlowLayout());
		Players listOfPlayers = highScoreManager.showTopTen();
		
		JLabel highScoreMenuLabel = new JLabel("HighScore Menu");
		highScoreMenuLabel.setFont(new Font("Miriam", Font.BOLD, 24));
		highScoreMenuLabel.setPreferredSize(new Dimension(250, 35));
		
		// Storing the player names and the cumulative scores in an array to use JList for display purposes.
		String[] highScoreList = new String[listOfPlayers.getPlayerNames().size() + 1];
		String[] namesList = new String[listOfPlayers.getPlayerNames().size()];
		String[] scoresList = new String[listOfPlayers.getScores().size()];
		
		highScoreList[0] = "     Player names                                              Total Scores ";  
		for(int i=0; i<listOfPlayers.getPlayerNames().size(); i++){
			namesList[i] = listOfPlayers.getPlayerNames().get(i);
			scoresList[i] = listOfPlayers.getScores().get(i).toString();
			highScoreList[i+1] = "     " + namesList[i] + "                                                                "
					+ "                     " + scoresList[i] + "        ";  
		}
		
		list = new JList(highScoreList);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JButton goBackButton = new JButton("Go Back to Play Game Menu");
		
		goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				manager.displayPlayGameMenu();
			}
		});	
		
		
		goBackButton.setPreferredSize(new Dimension(250, 25));
		
		add(highScoreMenuLabel);
		add(new JScrollPane(list));
		add(goBackButton);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
}
