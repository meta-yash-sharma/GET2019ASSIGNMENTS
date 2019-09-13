package com.metacube.EAD_Session_6_REST.Repository;

import java.util.List;

import com.metacube.EAD_Session_6_REST.DAO.DataOperations;
import com.metacube.EAD_Session_6_REST.model.Books;



public class BooksRepository {
	
	List<Books> bookList;

	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		
		bookList = DataOperations.getAllBooks();
		
		return bookList;
	}

	public List<Books> RetrieveBookByTitle(String title) {
		// TODO Auto-generated method stub
		
		bookList = DataOperations.RetrieveBookByTitle(title);
		
		return bookList;
	}


	public int deleteBookById(int id) {
		
		int result = DataOperations.deleteBookById(id);
		
		return result;
	}

	public int deleteAllBook() {
		
		int result = DataOperations.deleteAllBook();
		return result;
	}

	public int createBook(Books book) {
		
		int result = DataOperations.createBook(book);
		return result;
	}

	
	public int updatebook(String title, int publishedyear, Books book) {
		
		int result = DataOperations.updatebook(title, publishedyear, book);
		return result;
	}


}
