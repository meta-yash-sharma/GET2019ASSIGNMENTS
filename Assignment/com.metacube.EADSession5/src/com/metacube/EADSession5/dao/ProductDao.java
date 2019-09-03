package com.metacube.EADSession5.dao;

import java.sql.SQLException;
import java.util.List;

import com.metacube.EADSession5.enums.DBType;
import com.metacube.EADSession5.enums.Status;
import com.metacube.EADSession5.model.Product;
import com.metacube.EADSession5.model.ShoppingCart;

public class ProductDao implements BaseDao<Product> {
	
	BaseDao<Product> baseDaoObj;
	
	public ProductDao(DBType dbType) throws ClassNotFoundException, SQLException
	{
		
		baseDaoObj = new SQLDao();
		
	}

	@Override
	public List<Product> getAllProduct(String query) {
		return baseDaoObj.getAllProduct(query);
	}

	@Override
	public Status addProductToCart(String query) {
		return baseDaoObj.addProductToCart(query);
	}

	@Override
	public List<ShoppingCart> getCart(String query) {
		return baseDaoObj.getCart(query);
	}

	@Override
	public Status updateProductsInCart(String query) {
		return baseDaoObj.updateProductsInCart(query);
	}

	@Override
	public int findProductIdByName(String query) {
		return baseDaoObj.findProductIdByName(query);
	}

	@Override
	public String getProductNameById(String query) {
		return baseDaoObj.getProductNameById(query);
	}

	@Override
	public Status deleteProductFromCart(String query) {
		return baseDaoObj.deleteProductFromCart(query);
	}

	@Override
	public int findUserIdByEmailId(String query) {
		return baseDaoObj.findUserIdByEmailId(query);
	}

	@Override
	public boolean authenticateUser(String query) {
		return baseDaoObj.authenticateUser(query);
	}

}
