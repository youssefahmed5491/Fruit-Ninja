package fruitNinjaPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class levelController  {
	
	static int counter;
	Player player = Player.getInstance();
	
	Image fruit1Image ;
	@FXML
	ImageView live1;
	
	@FXML
	ImageView live2;
	
	@FXML
	ImageView live3;
	
	@FXML
	ImageView fruitImage1;
	
	@FXML
	ImageView bannanaImage;
	
	@FXML
	ImageView slicedappleImageleft;
	
	@FXML
	ImageView slicedappleImageright;
	
	
	@FXML
	ImageView slicedbannanaImageleft;
	
	@FXML
	ImageView slicedbannanaImageright;
	
	@FXML
	ImageView watermelon;
	
	@FXML
	ImageView slicedWatermelon;
	
	@FXML
	ImageView goldApple;
	
	@FXML
	ImageView goldMango;
	
	@FXML
	ImageView bombImage;
	
    @FXML
	ImageView redBombImage;
	
	@FXML 
	AnchorPane ap;
	
	@FXML
    Label score;
	
	@FXML
	Label highScore;
	
	SwipeAction swipe;
	
	 final Duration SEC_Whole = Duration.millis(4000);
	 final Duration SEC_Sliced_Fall = Duration.millis(1500);
	 final Duration SEC_Slice = Duration.millis(750);


	 Timeline timeline = new Timeline();
     DoubleProperty yValue = new SimpleDoubleProperty();

	
	public void initialize() {
		player.setScore(0);
		player.setLives(3);
     score.setText(player.getScore()+"");
     highScore.setText(player.getHighScore()+"");
     
		click();		
	
	}
	
	
	public void printMouse() {
		

		}

	Objects fruit;
	String s;
	int x;
	Random rand;
	ObjectsFactory object;
	List<String> list;
public void click() {
	 object = new ObjectsFactory();
	 list = new ArrayList<String>();
     list.add("Bannana");
     list.add("Apple");
     list.add("GoldApple");     
     list.add("GoldMango");                                             
     list.add("RedBomb");                                              
     list.add("NormalBomb");                                           
     list.add("Watermelon");                 
     rand = new Random();
     x =rand.nextInt(7);
     s = list.get(x);
  fruit = object.getObjects(s);
     switch (fruit.getImage()) {//
	case "appleImage":
	{
		
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/fullRedApples1.png"));
			fruitImage1.setImage(fruit1Image);
			counter=1;
		
		break;
	}
		case "bannanaImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/fullBannana.png"));
			fruitImage1.setImage(fruit1Image);
			counter=2;
			break;
		}	
		case "watermelonImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/fullWatermelon.png"));
			fruitImage1.setImage(fruit1Image);
			counter=3;
			break;
		}	
		case "goldAppleImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/fullGoldApples.png"));
			fruitImage1.setImage(fruit1Image);
			counter=4;
			break;
		}	
		case "goldMangoImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/fullGoldMango.png"));
			fruitImage1.setImage(fruit1Image);	
			counter=5;
			break;
		}	
		case "bombImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/bomb.png"));
			fruitImage1.setImage(fruit1Image);	
			counter=6;
			break;
		}	
		case "redBombImage":
		{
			fruit1Image = new Image(getClass().getResourceAsStream("/fruitNinjaPack/Images/RedBomb.png"));
			fruitImage1.setImage(fruit1Image);	
			counter=7;
			break;
		}
		default:
		break;
	}
	slicedappleImageleft.setVisible(false);
	slicedappleImageright.setVisible(false);
/*	TranslateTransition appleTransition=new TranslateTransition();
	appleTransition.setNode(appleImage);
	appleTransition.setDuration(Duration.seconds(5));
	appleTransition.setToY(500);
    appleTransition.play();
	*/
	fruitImage1.setY(0);
	fruitImage1.setVisible(true);

	KeyFrame Whole_fall = new KeyFrame(SEC_Whole,
               new KeyValue(fruitImage1.yProperty(), 600));
       

       timeline.getKeyFrames().add(Whole_fall);
       timeline.play();
       
	    yValue.bind(fruitImage1.yProperty());


	  
	  

 yValue.addListener((observable, oldvalue, newvalue) ->{	 
 });
 timeline.setOnFinished(e->click()); 
}

public void SliceObject(Event event) {
	Parent root = FXMLLoader.load(getClass().getResource("/fruitNinjaPack/FXMLFILES/GameMainMenu.fxml"));
	System.out.println(player.getLives());
	//player.setScore(fruit.getScore()+Integer.parseInt(score.getText()));
	player.setLives(player.getLives()+fruit.getDanger());
	System.out.println(player.getLives());
	swipe = new SwipeAction(fruit);
	Label1 labelOb = new Label1(score);
	swipe.register(labelOb);
	swipe.increase();
	if (player.getScore()>player.getHighScore())
	{
		player.setHighScore(player.getScore());
		highScore.setText(player.getScore()+"");
	}
	if(player.getLives()==3)
	{
		live1.setVisible(true);
		live2.setVisible(true);
		live3.setVisible(true);
	}
	else if(player.getLives()==2)
	{

		live1.setVisible(false);
		live2.setVisible(true);
		live3.setVisible(true);
	}
	else if (player.getLives()==1)
	{
		live1.setVisible(false);
		live2.setVisible(false);
		live3.setVisible(true);
	}
	else
	{
		live1.setVisible(false);
		live2.setVisible(false);
		live3.setVisible(false);
		Scene userScene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(userScene);
		window.show();
		System.out.println("you lose");
	}
	//score.setText(player.getScore()+"");
	
	Timeline Slice_time = new Timeline();
	Timeline Slice_fall_time = new Timeline();
    timeline.stop();
    fruitImage1= (ImageView) event.getSource();
    if(counter==1)
    {
    	
    slicedappleImageleft.setY(fruitImage1.getY());
    slicedappleImageright.setY(fruitImage1.getY());
    slicedappleImageleft.setX(fruitImage1.getX()+1);
    slicedappleImageright.setX(fruitImage1.getX()-1);
	slicedappleImageleft.setVisible(true);
	slicedappleImageright.setVisible(true);
    }
    if(counter==2)
    {
    slicedbannanaImageleft.setY(fruitImage1.getY());
    slicedbannanaImageright.setY(fruitImage1.getY());
    slicedbannanaImageleft.setX(fruitImage1.getX()+1);
    slicedbannanaImageright.setX(fruitImage1.getX()-1);
    slicedbannanaImageleft.setVisible(true);
	slicedbannanaImageright.setVisible(true);    	
    }
	fruitImage1.setVisible(false);
       KeyFrame Slice = new KeyFrame(SEC_Slice,
               new KeyValue(slicedappleImageleft.xProperty(), -35),
               new KeyValue(slicedbannanaImageleft.xProperty(), -35),
               new KeyValue(slicedappleImageright.xProperty(), 35),
               new KeyValue(slicedbannanaImageright.xProperty(), 35));
       Slice_time.getKeyFrames().add(Slice);
       Slice_time.play();
	
	KeyFrame Sliced_Fall = new KeyFrame(SEC_Sliced_Fall,
               new KeyValue(slicedappleImageleft.yProperty(), 500),
               new KeyValue(slicedappleImageright.yProperty(), 500),
	new KeyValue(slicedbannanaImageleft.yProperty(), 580),
    new KeyValue(slicedbannanaImageright.yProperty(), 580));
	Slice_fall_time.getKeyFrames().add(Sliced_Fall);
       Slice_fall_time.play();
   
     Slice_fall_time.setOnFinished(e->click());  
} 

		
		
	}	


	
	


