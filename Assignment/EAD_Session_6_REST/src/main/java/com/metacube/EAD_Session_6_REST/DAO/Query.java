package com.metacube.EAD_Session_6_REST.DAO;

public class Query {

	public String getAllBooks() {		
		return "Select * FROM Book ";
	}

	public String RetrieveBookByTitle() {
		
		return "Select * FROM Book WHERE title = ?";
	}

	public String createBook() {
		
		return "INSERT INTO Book Values(?,?,?,?,?) ";	
	}

	public String deleteBookById() {
		
		return "DELETE FROM Book WHERE book_id = ?";
	}

	public String deleteAllBook() {
		
		return "DELETE FROM Book ";
	}

	public String updatebook() {
		
		return "UPDATE Book SET book_id = ?, writer = ?, publisher = ? WHERE title = ? AND published_year = ? ";
	}



	
}
