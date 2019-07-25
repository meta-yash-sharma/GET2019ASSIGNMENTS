package zooManagementSystem;
import java.util.*;

public class Zone {
	
	String category;
	int noOfCages;
	boolean park;
	boolean canteen;
	ArrayList<Cage> cages;
	
	Zone(String category,int noOfCages,String park,String canteen){
		
		cages=new ArrayList<Cage>();
		this.category=category;
		this.noOfCages=noOfCages;
		if(park.equals("yes"))
		this.park=true;
		else 
			this.park=false;
		if(canteen.equals("yes"))
			this.canteen=true;
		else
			this.canteen=false;
		
		
	}
	
	boolean hasPark(){
		return park;
	}
	
	boolean hasCanteen(){
		return canteen;
	}
}
