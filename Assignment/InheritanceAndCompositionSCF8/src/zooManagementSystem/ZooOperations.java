package zooManagementSystem;

import java.util.*;

public class ZooOperations {
	
	Scanner sc=new Scanner(System.in);
	
	ArrayList<Zone> zoneList=new ArrayList<Zone>();
	
	String name,park,canteen;
	int age;
	float weight;
	int capacity;
	int choice;
	String category;
	int noOfCages;
	
	/**
	 * Add A Zone of particular Category (such as mammals, reptiles, birds) in the Zoo.
	 * @return true if zone is added in zoo or false.
	 */
	public boolean addZone(){
		boolean flag =false;// whether the Zone is added or not.
		try {
			
			System.out.println("Enter the category of zone.\n1)Mammals\n2)Reptiles\n3)Birds ");
			choice=sc.nextInt();
			if(choice < 4 && choice > 0) {
				System.out.println("enter the number of cages in zone : ");
				noOfCages=sc.nextInt();
				System.out.println("want to add park in zone [yes/no]: ");
				park=sc.next();
				System.out.println("want to add canteen in zone [yes/no]: ");
				canteen=sc.next();			
			}
			
			if(choice == 1)
			{
				zoneList.add(new Zone("mammals",noOfCages,park,canteen));
				flag = true;
				}
			else if(choice == 2){
				zoneList.add(new Zone("reptiles",noOfCages,park,canteen));
				flag = true;
				}
			else if(choice == 3){
				zoneList.add(new Zone("birds",noOfCages,park,canteen));
				flag = true;
				}
			if(flag) {
				System.out.println("zone added successfully.. ");			
				}
			else {
				System.out.println("Zone Can't be added as Invalid Category.");
				}
			}
		catch( InputMismatchException e) {
			System.out.println("Input Mismatch.....");
			sc.nextLine();
			addZone();
		}
		return flag;
	}
	
	
	/**
	 * Display the Structure of Zoo, that is the different Zones present in Zoo the cages
	 * present in these zones and the Animals present in these cages.
	 */
	public void display(){
		
		for(int i=0;i<zoneList.size();i++){
			System.out.println("zone number : "+(i+1)+"\t"+"  Zone Category : "+zoneList.get(i).category+
					" \t"+ "hasPark : "+zoneList.get(i).hasPark()+"\t"+ " "
							+ "hascanteen : "+zoneList.get(i).hasCanteen()+"\n");
				for(int j=0;j<zoneList.get(i).cages.size();j++){
					System.out.println("cage number : "+(j+1)+"\t"+""
							+ "cage type : "+zoneList.get(i).cages.get(j).type);
					for(int k=0;k<zoneList.get(i).cages.get(j).animals.size();k++)
					System.out.println(" id : "+zoneList.get(i).cages.get(j).animals.get(k).aid+"\t"+" "
							+ "name : "+zoneList.get(i).cages.get(j).animals.get(k).name+"\t"
							+" sound : "+zoneList.get(i).cages.get(j).animals.get(k).getSound());
					
				}
				System.out.println("\n\n");
			}
	}
	
	
	/**
	 * Add the Animal of paricular Category(such as mammals, reptiles, birds), 
	 * particular type(i.e. lion, peacock, crocodile )
	 * @param category	Which animal family it belongs.
	 * @param type		Which type of animal it is.
	 * @return			True if Animal is Added else False.
	 */
	public boolean addAnimal(String category, String type){
		try{
			for(int index1=0;index1<zoneList.size();index1++){
				int index2=0;
				if(zoneList.get(index1).category.equals(category)){
					
					System.out.println("enter the name ");
					name=sc.next();
					System.out.println("enter the age ");
					age=sc.nextInt();
					System.out.println("enter the weight ");
					weight=sc.nextFloat();
					
					for(index2=0;index2<zoneList.get(index1).cages.size();index2++){
						if(zoneList.get(index1).cages.get(index2).type.equals(type)
								&& zoneList.get(index1).cages.get(index2).animals.size() < zoneList.get(index1).cages.get(index2).capacity){
							if(type.equals("lion"))
								zoneList.get(index1).cages.get(index2).animals.add(new Lion(name,age,weight));
							if(type.equals("crocodile"))
								zoneList.get(index1).cages.get(index2).animals.add(new Crocodile(name,age,weight));
							if(type.equals("peacock"))
								zoneList.get(index1).cages.get(index2).animals.add(new Peacock(name,age,weight));
							System.out.println("animal added successfully.. ");
							return true;
							}
						}
				if(zoneList.get(index1).cages.size() < zoneList.get(index1).noOfCages){
					System.out.println("Creating new cage .. \nenter the capacity of cage : ");
					capacity=sc.nextInt();
					zoneList.get(index1).cages.add(new Cage(type,capacity));
					if(type.equals("lion"))
						zoneList.get(index1).cages.get(index2).animals.add(new Lion(name,age,weight));
						if(type.equals("crocodile"))
							zoneList.get(index1).cages.get(index2).animals.add(new Crocodile(name,age,weight));
						if(type.equals("peacock"))
							zoneList.get(index1).cages.get(index2).animals.add(new Peacock(name,age,weight));
					System.out.println("animal added successfully.. ");
					return true;
					}
				}
			}
			System.out.println("No space available in any zone.. pls create a new zone.. ");
		}
		catch(InputMismatchException e) {
			System.out.println("Input Mismatch.....");
			sc.nextLine();
			addAnimal(category, type);
		}
		return false;
	}
	
	
	
	public boolean removeAnimal(String name){
		
		for(int index1=0;index1<zoneList.size();index1++){
				for(int index2=0;index2<zoneList.get(index1).cages.size();index2++){
					for(int index3=0;index3<zoneList.get(index1).cages.get(index2).animals.size();index3++)
						if(zoneList.get(index1).cages.get(index2).animals.get(index3).name.equals(name)){
							zoneList.get(index1).cages.get(index2).animals.remove(index3);
							System.out.println("animal removed successfully.. ");
							return true;
						}
					
				}
			}
		System.out.println("animal is not present.. ");
		return false;		
	}
}

