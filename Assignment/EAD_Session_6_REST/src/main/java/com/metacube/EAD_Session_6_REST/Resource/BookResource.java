package com.metacube.EAD_Session_6_REST.Resource;

import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;






import com.metacube.EAD_Session_6_REST.Repository.BooksRepository;
import com.metacube.EAD_Session_6_REST.model.Books;



@Path("bookResource")
public class BookResource {
	
	BooksRepository repo = new BooksRepository();
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	
	@GET
	@Path("retrivebooks")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Books> RetrieveAllBooks(){
		System.out.println("method RetrieveAllBooks is called............");
		return repo.getAllBooks();
	}
	
	@GET
	@Path("retrieveBookByTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Books> RetrieveBookByTitle(@PathParam("title") String title){
		System.out.println("method RetrieveBookByTitle is called............");
		
		
		return repo.RetrieveBookByTitle(title);
	}	
	
	@DELETE
	@Path("deleteBookById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBookById(@PathParam("id") int id){
		System.out.println("method deleteBookById called with id : "+ id +" ................");
		String status;
		int result = repo.deleteBookById(id);
		if(result == 1){
			System.out.println("Book Deleted by id");
			status = "Deleted";
		}else{
			System.out.println("Book Not Deleted as this book does not exist in your collection.");
			status = "Not Deleted";
		}
		return status;
	}
	
	@GET
	@Path("deleteAllBook")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAllBook(){
		System.out.println("method deleteAllBook called ................");
		String status;
		int result = repo.deleteAllBook();
		if(result != Integer.MIN_VALUE){
			System.out.println("All Book Deleted.");
			status = "Deleted";
		}else{
			System.out.println("Book Not Deleted as this book does not exist in your collection.");
			status = "Not Deleted";
		}
		return status;
	}
	
	
	@POST
	@Path("createbook")
	public Books createBook(Books book){
		System.out.println("method createBook called ................");
		int result = repo.createBook(book);
		if(result != Integer.MIN_VALUE){
			System.out.println("Book Added.");
		}else{
			System.out.println("Book Not Added as their is an error in book id.");
		}
		return book;
	}
	
	
	@PUT
	@Path("updatebook/{title}/{publishedyear}")
	public String updatebook(@PathParam("title") String title, @PathParam("publishedyear") int publishedyear, Books book){
		
		System.out.println("method updatebook called with title ;"+ title +" and published Year : "+ publishedyear +" ................");
		int result = repo.updatebook(title, publishedyear, book);
		String status;
		if(result != Integer.MIN_VALUE){
			System.out.println("Book Added.");
			status = "Updated";
		}else{
			System.out.println("Book Not Added as their is an error in book id.");
			status = "Not Updated";
		}
		return status;
	}
}
