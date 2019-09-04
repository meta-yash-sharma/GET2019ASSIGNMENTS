package com.metacube.EADSession5.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.metacube.EADSession5.controller.ProductController;
import com.metacube.EADSession5.enums.Status;
import com.metacube.EADSession5.model.Product;
import com.metacube.EADSession5.model.ShoppingCart;


public class Main {

	static Scanner sc = new Scanner(System.in);
	static ProductController productController = new ProductController();
	
	public static void main(String[] args) {
		
		int userId = showAutenticationPage();
		if(userId > 0)
		{
			String choice;
			Status status = null;
			String productName, productQuantity;
			int productId;
			List<ShoppingCart> cartItems = new ArrayList<>();
			whileLoop : do
			{
				showMenu();
				choice = sc.nextLine();
				switch(choice)
				{
					case "1" : 
						showProducts();
						System.out.print("\nEnter product name : ");
						productName = sc.nextLine();
						System.out.print("Enter product quantity : ");
						productQuantity = sc.nextLine();
						productId = productController.findProductIdByName(productName);
						try
						{
							status = productController.addProductToCart(userId, productId, Integer.parseInt(productQuantity));
						}
						catch (NumberFormatException e) {
							System.out.println("\nEnter the quantity in number only.");
							continue whileLoop;
						}
						if(status == Status.ADDED)
						{
							System.out.println("Product added to the cart");
						}
						else
						{
							System.out.println("There was an error while adding the product to the cart");
						}
						break;
						
					case "2" : 
						cartItems = productController.getCartItems(userId);
						if(cartItems.size() > 0)
						{
							int i = 0;
							System.out.println("\nYou have following products in the cart : ");
							for(ShoppingCart item : cartItems)
							{
								System.out.println("Product " + (++i));
								String product = productController.getProductNameById(item.getProductId());
								System.out.println("\tProduct Name : " + product);
								System.out.println("\tProduct Quantity : " + item.getProductQuantity());
							}
						}
						else
						{
							System.out.println("\nYour cart is Empty");
						}
						break;
						
					case "3" :
						System.out.print("\nEnter product name whose quantity is to be updated : ");
						productName = sc.nextLine();
						System.out.print("Enter the new quantity : ");
						productQuantity = sc.nextLine();
						productId = productController.findProductIdByName(productName);
						if(Integer.parseInt(productQuantity) == 0)
						{
							status = productController.deleteProductFromCart(userId, productId);
						}
						else
						{
							status = productController.updateCartItems(userId, productId, Integer.parseInt(productQuantity));
						}
						if(status == Status.UPDATED)
						{
							System.out.println("Product Updated in the cart");
						}
						else
						{
							System.out.println("There was an error while updating the product to the cart");
						}
						break;
						
					case "4" :
						System.out.print("\nEnter product name which is to be deleted : ");
						productName = sc.nextLine();
						productId = productController.findProductIdByName(productName);
						status = productController.deleteProductFromCart(userId, productId);
						if(status == Status.UPDATED)
						{
							System.out.println("Product Deleted from the cart");
						}
						else
						{
							System.out.println("There was an error while Deleting the product to the cart");
						}
						break;
					case "5" :
						System.out.println("\nThank You For Shopping");
						break;
						
						default : 
							System.out.println("Please Enter a valid choice");
				}
			}while(!"5".equals(choice));
			
			
		}
		else
		{
			System.out.println("Incorrect Email Id or Password. Please Enter Again");
			main(args);
		}
	}
	
	/**
	 * This method is used to authenticate the user
	 * @return int user id of the authenticated user
	 */
	public static int showAutenticationPage() {
		System.out.print("\nEnter Email Id : ");
		String emailId = sc.nextLine();
		System.out.print("Enter Password : ");
		String password = sc.nextLine();
		int userId = productController.findUserIdByEmailId(emailId);
		boolean isUserAuthenticated = productController.authenticateUser(userId, password);
		if(isUserAuthenticated)
		{
			return userId;
		}
		else
		{
			return -1;
		}
	}

	/**
	 * This method displays the products in the database
	 */
	public static void showProducts() {
		List<Product> productList = new ArrayList<>();
		productList = productController.getProducts();
		int i = 0;
		System.out.println("\nYou can add following products in the cart : ");
		for(Product product : productList)
		{
			System.out.println("Product " + (++i));
			System.out.println("\tProduct Name : " + product.getProductName());
			System.out.println("\tProduct Type : " + product.getProductType());
			System.out.println("\tProduct Price : " + product.getProductPrice());
		}
	}

	/**
	 * This method displays the menu
	 */
	static void showMenu()
	{
		System.out.println("\n1. Add Product to the cart");
		System.out.println("2. Display the cart.");
		System.out.println("3. Update an Item's quantity in the cart");
		System.out.println("4. Delete Product from Cart");
		System.out.println("5. Logout");
		System.out.print("\nEnter your choice : ");
	}
}
