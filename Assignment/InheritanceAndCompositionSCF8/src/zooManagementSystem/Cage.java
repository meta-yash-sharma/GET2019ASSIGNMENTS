package zooManagementSystem;

import java.util.ArrayList;

public class Cage  {
	
	String type;
	int capacity;
	ArrayList<Animals> animals;
	
	
	Cage(String type,int capacity){
		animals=new ArrayList<Animals>(capacity);
		this.type=type;
		this.capacity=capacity;
	}


	public String getType() {
		return type;
	}


	public int getCapacity() {
		return capacity;
	}


	public ArrayList<Animals> getAnimals() {
		return animals;
	}	
	

}
