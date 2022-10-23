package fruitNinjaPack;


public class Player {
	private static int lives=3;
	private static int score=0;
	private static int highScore=10;
private static Player instance;
	
	private Player(){
		
	}

	public static Player getInstance (){

		if (instance == null)

		instance = new Player();

		return instance;

		}
	public int getLives()
	{
		return lives;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int scr)
	{
		score=scr;
	}
	public void setLives(int liv)
	{
		lives=liv;
	}
	public int getHighScore()
	{
		return highScore;
	}
	public void setHighScore(int highScr)
	{
		highScore=highScr;
	}
}
