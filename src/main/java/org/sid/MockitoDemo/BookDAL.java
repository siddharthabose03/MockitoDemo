package org.sid.MockitoDemo;

import java.util.Collections;
import java.util.List;

public class BookDAL {

	private static BookDAL bookDal = new BookDAL();

	public List<Book> getAllBooks() {
		return Collections.emptyList();
	}

	public Book getBook(String isbn) {
		return null;
	}

	public String addBook(Book book) {
		return book.getIsbn();
	}

	public String updateBook(Book book) {
		return book.getIsbn();
	}

	public static BookDAL getInstance() {
		return bookDal;
	}
}
