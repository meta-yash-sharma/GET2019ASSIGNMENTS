package shop;

import java.util.*;
import java.io.*;
import java.lang.String;

public class item
	{
		public String name;
		public double price;
		public int quantity;
		
		public item(String itemName, double itemPrice, int itemQuantity)
		{
			name = itemName;
			price = itemPrice;
			quantity = itemQuantity;
		}
		
	}