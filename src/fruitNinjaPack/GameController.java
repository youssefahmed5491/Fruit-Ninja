package fruitNinjaPack;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameController {

	@FXML
	private ImageView apple1;
	@FXML
	private ImageView apple2;
	
	private ImageView image;
	
	public void onClick(Event evt)
	{
		  image = (ImageView) evt.getSource();
		  image.setVisible(false);
	
	}
	
	public void initialize() 
	{
		TranslateTransition appleTransition=new TranslateTransition();
		appleTransition.setNode(apple1);
		appleTransition.setDuration(Duration.seconds(5));
		appleTransition.setToY(500);
	    appleTransition.play();
	    TranslateTransition apple2Transition=new TranslateTransition();
		apple2Transition.setNode(apple2);
		apple2Transition.setDuration(Duration.seconds(5));
		apple2Transition.setToY(500);
	    apple2Transition.play();
	}
}
