package com.metacube.EAD_Session_6_REST.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Books {

	/**
	 * CREATE TABLE Book( book_id INT PRIMARY KEY AUTO_INCREMENT, title
	 * VARCHAR(45) NOT NULL, writer VARCHAR(45) NOT NULL, publisher VARCHAR(45)
	 * NOT NULL, published_year INT NOT NULL );
	 */

	private int bookId;
	private String title;
	private String writer;
	private String publisher;
	private int publishedYear;
	
	
	public Books(int bookId, String title, String writer, String publisher,
			int publishedYear) {
		this.bookId = bookId;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
	}

	public Books() {
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", writer="
				+ writer + ", publisher=" + publisher + ", publishedYear="
				+ publishedYear + "]";
	}
	
	
}
