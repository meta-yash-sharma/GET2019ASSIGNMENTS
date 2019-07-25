package zooManagementSystem;

public class Crocodile extends Reptiles {


	Crocodile(String name,int age,float weight){
		this.aid=++(super.id);
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	public String getSound(){
		
		return "ghrrr";
	}
}
