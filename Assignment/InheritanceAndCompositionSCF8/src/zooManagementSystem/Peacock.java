package zooManagementSystem;

public class Peacock extends Birds {
	

	Peacock(String name,int age,float weight){
		this.aid=++(super.id);
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	public String getSound(){
		
		return "peaaaauuuu";
	}

}
