package zooManagementSystem;

import java.util.*;
public class Driver {
	public static void main(String[] args) {
		Driver d = new Driver();
		d.input();
	}
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		ZooOperations z=new ZooOperations();
		int choice1,choice2;
		String name;
		try{
			do{
				System.out.println("Available operations..\n1.add animal\n2.remove animal\n3.add Zone\n4.display Zoo Data");
				System.out.println("enter your choice..");
				choice1=sc.nextInt();
				switch(choice1){
					case 1:
						System.out.println("enter the type of animal you want to add : \n1.Lion\n2.Crocodile\n3.Peacock");
					    choice2=sc.nextInt();
					    switch(choice2){
					    case 1: z.addAnimal("mammals","lion");
					    		break;
					    case 2: z.addAnimal("reptiles","crocodile");
					            break;
					    case 3: z.addAnimal("birds","peacock");
					    		break;
					    default : System.out.println("wrong choice , pls try again.. ");
					    }
					    break;
					case 2:
						System.out.println("enter the name of animal you want to remove");
					    name=sc.next();
						z.removeAnimal(name);
					   break;
					case 3: 
						z.addZone();
						break;
					case 4 :
						z.display();
				}
			}while(true);			
		}
		catch(InputMismatchException e) {
			System.out.println("Input Mismatch.....");
			sc.nextLine();
			input();
		}
	}
}
