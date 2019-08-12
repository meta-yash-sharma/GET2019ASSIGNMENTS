package viratMatch;

public class Bowler {
	private String bowlerName;
	private int ballLeft;
	
	public Bowler(String bowlerName, int ballLeft){
		this.bowlerName = bowlerName;
		this.ballLeft = ballLeft;
	}
	
	
	
	public String getBowlerName() {
		return bowlerName;
	}

	public int getBallLeft() {
		return ballLeft;
	}

	public String toString(){
		return "Bowler Name : "+bowlerName+ " Bowl Left : "+ballLeft;
	}

}
