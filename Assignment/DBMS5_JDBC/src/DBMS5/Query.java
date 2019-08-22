package DBMS5;

public class Query {
	
	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) 
	 * of that user which are in shipped state. Orders should be sorted by 
	 * order date column in chronological order.
	 * 
	 * @return	An String type object containing query of Above problem. 
	 */
	public String orders(){
		return "SELECT o.order_id, o.date, SUM(o.price) AS total_price "
				+"FROM order_details o "
				+"INNER JOIN shopper s ON s.shopper_id = o.cart_id "
				+"WHERE s.shopper_id = 3 AND o.status = 'shipped' ";
	}
	
	
	
	/**
	 * Insert five or more images of a product using batch insert technique.
	 * 
	 * @return	An String type object containing query of Above problem. 
	 */
	public String image(){
		return "INSERT INTO images VALUES(105,?) ";
	}
	
	
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 0
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_0(){
		return "SET FOREIGN_KEY_CHECKS = 0 ";
	}
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 1
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_1(){
		return "SET FOREIGN_KEY_CHECKS = 1 ";
	}
	
	
	
	/**
	 * Show The Data from table where product is is 105.
	 * 
	 * @return An String type object containing query of Above problem.
	 */
	public String select_Image(){
		return "SELECT * "
				+"FROM images "
				+"WHERE product_id = 105 ";
	}
	
	
	
	/**
	 * Select and display the category title of all top parent categories sorted 
	 * alphabetically and the count of their child categories.
	 * @return	An String type object containing query of Above problem.
	 */
	public String parent_Child(){
		return "SELECT parent.category_name, COUNT(child.category_id) AS numberOfChildren "
				+"FROM product_category parent " 
				+"LEFT JOIN product_category child " 
				+"ON parent.category_id = child.parent_id "
				+"WHERE parent.parent_id IS NULL " 
				+"GROUP BY parent.category_id " 
				+"ORDER BY parent.category_name ";
	}
	
	
	
	/**
	 * Delete all those products which were not ordered by any Shopper in last 1 year. 
	 * Return the number of products deleted.
	 * @return	An String type object containing query of Above problem.
	 */
	public String product_Not_order(){
		return "DELETE FROM product "
				+"WHERE product.product_id NOT IN(SELECT o.product_id "
				+"FROM order_details o " 
				+"LEFT JOIN cart c " 
				+"ON c.cart_id = o.cart_id "
				+"WHERE o.product_id = c.product_id AND DATEDIFF(CURDATE(),o.date) <= 365) ";
	}
}
