package shop;

import java.util.*;
import java.io.*;
import java.lang.String;


public class ShoppingCart
{
	private ArrayList<item> list = new ArrayList<item>();//ArrayList to store data of shopping material in cart.
	private int count=0;// to store array length.
	private ArrayList<Integer> check = new ArrayList<Integer>();
	/*
	 * Create the an element which store the data Item Name, Item Price, Item Quantity to default value. 
	 */
	void createlist(){
		item football = new item("Football", 200.0, 0);
		list.add(football);
		check.add(0);
		item circketball = new item("circketball", 100.0, 0);
		list.add(circketball);
		check.add(0);
		item circketbat = new item("circketbat", 2000.0, 0);
		list.add(circketbat);
		check.add(0);
		item basketball = new item("Basketball", 400.0, 0);
		list.add(basketball);
		check.add(0);
	}
	/*
	 * Add our Product to Cart.
	 * @param itemcode shown in beginning, Item Name, Item Price and Item Quantity
	 * @return Product Added into the cart with all details. 
	 */
	public void addItemToCart(int index, String itemName, double itemPrice, int itemQuantity)
	{
		if(list.get(index).quantity == 0)
		{	
			item item1 = new item(itemName, itemPrice, itemQuantity );
			list.set(index-1,item1);
			count++;
			check.set(index,1);
		}
	}
	/*
	 * Show our Product in the cart.
	 * @return Show the item code ,Item name ,item price and item quantity added in the cart.
	 */
	public void showCartData()
	{
		int i;
		System.out.println("Item Code\t\t Item Name\t\t Item Price\t\t Item Quantity");
		for(i=0;i<4;i++)
		{
			if(list.get(i).quantity != 0)
			System.out.println((i+1)+"\t\t "+list.get(i).name+"\t\t "+list.get(i).price+"\t\t "+list.get(i).quantity);
		}
	}
	/*
	 * Generate the bill of our shopping.
	 * @return the total price or bill of our shopping.
	 */
	public double generateBill()
	{
		double bill = 0;
		int i;
		for(i=0;i<4;i++)
		{
			bill += (list.get(i).price*list.get(i).quantity);
		}
		
		return bill;
	}
	/*
	 * Update our shopping cart.
	 * @param send the item code and the quantity of the item to be updated.
	 * @return Update the Shopping Cart.
	 */
	public void updateList(int index, int itemQuantity )
	{
		list.get(index-1).quantity = itemQuantity;
	}
	
	/*
	 * To Check whether the given item is in the cart or not 
	 * @param send the item code to see if the item is already present.
	 * @return true or false depending on whether the item is present or not.
	 */
	public boolean checkItem(int index)
	{
		if(check.get(index) == 0)
		{
			return true;
		}
			
		return false;
	}


}
