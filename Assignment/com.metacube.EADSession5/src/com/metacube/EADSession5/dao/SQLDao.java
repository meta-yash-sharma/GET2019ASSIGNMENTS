package com.metacube.EADSession5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.EADSession5.enums.Status;
import com.metacube.EADSession5.model.Product;
import com.metacube.EADSession5.model.ShoppingCart;

public class SQLDao implements BaseDao<Product> {

	Connection connection;
	
	public SQLDao() throws ClassNotFoundException, SQLException {
		connection = SQLConnector.makeConnection();
	}
	
	@Override
	public List<Product> getAllProduct(String query) {
		List<Product> productList = new ArrayList<>();
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while(resultSet.next())
			{
				productList.add(new Product(resultSet.getInt(1),  resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return productList;
	}

	@Override
	public Status addProductToCart(String query) {
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(statement.executeUpdate() > 0)
			{
				connection.commit();
				return Status.ADDED;
			}
			else
			{
				return Status.INVALID;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Product name not Correct.");
			return Status.ERROR;
		}
	}

	@Override
	public List<ShoppingCart> getCart(String query) {
		List<ShoppingCart> cartList = new ArrayList<>();
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while(resultSet.next())
			{
				cartList.add(new ShoppingCart(resultSet.getInt(1),  resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4)));
			}
		}
		catch (SQLException e)
		{
			System.out.println("Cart can be shown due to an Error.");
			//System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return cartList;
	}

	@Override
	public Status updateProductsInCart(String query) {
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(statement.executeUpdate() > 0)
			{
				connection.commit();
				return Status.UPDATED;
			}
			else
			{
				return Status.INVALID;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Product can't be updated as product name not correct or Product not in Cart. hence Error Occur.");
			return Status.ERROR;
		}
	}

	@Override
	public int findProductIdByName(String query) {
		int productId;
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			productId = resultSet.getInt(1);
		}
		catch (SQLException e)
		{
			System.out.println("Their is no product of such name hence no product id.");
			return -1;
		}
		return productId;
	}

	@Override
	public String getProductNameById(String query) {
		String productName;
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			productName = resultSet.getString(1);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		return productName;
	}

	@Override
	public Status deleteProductFromCart(String query) {
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			if(statement.executeUpdate() > 0)
			{
				connection.commit();
				return Status.UPDATED;
			}
			else
			{
				return Status.INVALID;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return Status.ERROR;
		}
	}

	@Override
	public int findUserIdByEmailId(String query) {
		int userId;
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			userId = resultSet.getInt(1);
		}
		catch (SQLException e)
		{
//			System.out.println(e.getMessage());
			return -1;
		}
		return userId;
	}

	@Override
	public boolean authenticateUser(String query) {
		try
		{
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			int resultSetSize = 0;
			while(resultSet.next())
			{
				resultSetSize++;
			}
			if(resultSetSize > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
//			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

}
