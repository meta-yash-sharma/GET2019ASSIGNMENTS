package zooManagementSystem;

public class Lion extends Mammals {
	Lion(String name,int age,float weight){
		this.aid=++(super.id);
		this.name=name;
		this.age=age;
		this.weight=weight;
	}

	public String getSound(){
		return "roar";
	}
	
}
