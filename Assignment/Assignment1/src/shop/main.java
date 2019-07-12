package shop;
import java.util.*;
import java.io.*;
import java.lang.String;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int checkkey,k;
		int quantity;
		ShoppingCart obj1 = new ShoppingCart();
		obj1.createlist();
		
		System.out.println("Item availabel in Market.");
		System.out.println("FootBall  price 200 Rs.");
		System.out.println("CircketBall  price 100 Rs.");
		System.out.println("CircketBat  price 2000 Rs.");
		System.out.println("BasketBall  price 400 Rs.");
		while(true)
		{
			System.out.println("Preess 1 for adding Item in cart.");
			System.out.println("Preess 2 for Updating Item in cart.");
			System.out.println("Preess 3 for Showing Item in cart.");
			System.out.println("Preess 4 for Getting Bill.");
			checkkey = sc.nextInt();
			switch(checkkey)
			{
			case 1:
				System.out.println("press 1 for Football");
				System.out.println("press 2 for Circketball");
				System.out.println("press 3 for Circketbat");
				System.out.println("press 4 for BasketBall");
				k = sc.nextInt();
				switch(k)
				{
				case 1:
					if(obj1.checkItem(k))
					{
						System.out.println("Enter Quantity of Football");
						quantity = sc.nextInt();
						obj1.addItemToCart(k,"Football", 200.0, quantity);
						break;												 
						
					}
					else
					{
						System.out.println("Item already in Cart use update option.");
						break;
					}												 
					
				case 2:
					if(obj1.checkItem(k))
					{
						System.out.println("Enter Quantity of Football");
						quantity = sc.nextInt();
						obj1.addItemToCart(k,"CircketBall", 100.0, quantity);
						break;												 
						
					}
					else
					{
						System.out.println("Item already in Cart use update option.");
						break;
					}

				case 3:
					if(obj1.checkItem(k))
					{
						System.out.println("Enter Quantity of Football");
						quantity = sc.nextInt();
						obj1.addItemToCart(k,"CircketBat", 2000.0, quantity);
						break;												 
						
					}
					else
					{
						System.out.println("Item already in Cart use update option.");
						break;
					}
				case 4:
					if(obj1.checkItem(k))
					{
						System.out.println("Enter Quantity of Football");
						quantity = sc.nextInt();
						obj1.addItemToCart(k,"BasketBall", 400.0, quantity);
						break;												 
						
					}
					else
					{
						System.out.println("Item already in Cart use update option.");
						break;
					}
				default : System.out.println("Invalid data restart.");
				}
				break;
			case 2:
				obj1.showCartData();
				System.out.println("Enter the index value of item to be updated.");
				int index;
				index = sc.nextInt();
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				obj1.updateList(index, quantity);
				System.out.println("Item updated in the shopping cart.");
				break;
			case 3:
				obj1.showCartData();
				break;
			case 4:
				double totalBill;
				totalBill = obj1.generateBill();
				System.out.println("Total Bill of Shoping : "+totalBill+"Rs.");
				System.exit(0);
			default : System.out.println("Invalid data restart.");
				
			}	
		}

	}

}
