package com.metacube.EAD_Session_6_REST.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





import com.metacube.EAD_Session_6_REST.model.Books;



public class DataOperations {

	public static ConnectionToDbms obj = new ConnectionToDbms();
	public static Connection connObj = obj.connectionObject();
	
	
	
	public static List<Books> getAllBooks() {
		List<Books> bookList = new ArrayList<Books>();
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			ResultSet rs =stmt.executeQuery(query.getAllBooks());
			
			while(rs.next()){
				
				bookList.add(new Books(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+ rs.getInt(5));
				
			}
			
			rs.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return bookList;
	}



	public static List<Books> RetrieveBookByTitle(String title) {
		List<Books> bookListByTitle = new ArrayList<Books>();
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			PreparedStatement pstmt = connObj.prepareStatement(query.RetrieveBookByTitle());
			
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				bookListByTitle.add(new Books(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+ rs.getInt(5));
			}
			
			rs.close();
			pstmt.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return bookListByTitle;
	}



	public static int deleteBookById(int id) {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			PreparedStatement pstmt = connObj.prepareStatement(query.deleteBookById());
			
			pstmt.setInt(1, id);						
			
			a = pstmt.executeUpdate();			
			
			System.out.println(a);
			pstmt.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return a;
	}



	public static int deleteAllBook() {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			PreparedStatement pstmt = connObj.prepareStatement(query.deleteAllBook());					
			
			a = pstmt.executeUpdate();			
			
			System.out.println(a);
			pstmt.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return a;
	}



	public static int createBook(Books book) {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			PreparedStatement pstmt = connObj.prepareStatement(query.createBook());					
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getWriter());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getPublishedYear());			
			
			a = pstmt.executeUpdate();			
			
			System.out.println(a);
			pstmt.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return a;
	}



	public static int updatebook(String title, int publishedyear, Books book) {
		int a = Integer.MIN_VALUE;
		try {

			Statement stmt = connObj.createStatement();

			Query query = new Query();
			
			PreparedStatement pstmt = connObj.prepareStatement(query.updatebook());					
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4, title);
			pstmt.setInt(5, publishedyear);
			
			a = pstmt.executeUpdate();			
			
			System.out.println(a);
			pstmt.close();
			stmt.close();


		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return a;
	}
	
}