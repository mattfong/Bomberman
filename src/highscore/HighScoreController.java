package highscore;

/**
 * The HighScoreController class takes care of displaying the HighScoreView
 * class or disposing of it.
 * 
 * @author Yahya Azami <yahya.azami@mail.mcgill.ca>
 * @since 2014-11-30
 * 
 */
public class HighScoreController {

    public HighScoreController(){
	
    }

    /**
     * exitHighScore closes the HighScoreView currently displayed.
     * 
     * @param view
     *            view is the HighScoreView which is to be disposed of.
     */
    private void exitHighScore(HighScoreView view) {
	view.f.dispose();
	// view.f.setVisible(false);
    }

    /**
     * displayHighScore displays a HighScoreView.
     * 
     * @return returns the instantiated HighScoreView view.
     */
    private HighScoreView displayHighScore() {

	HighScoreView view = new HighScoreView();
	return view;
    }

}
