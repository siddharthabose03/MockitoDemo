package org.sid.MockitoDemo;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class BookDALTest extends TestCase {

	private BookDAL bookDal;
	private Book book1;
	private Book book2;

	@BeforeClass
	protected void setUp() throws Exception {
		// Create Mock object of BookDAL
		bookDal = Mockito.mock(BookDAL.class);

		// Create few instances of BookDAL class
		book1 = new Book("8131721019", "Compilers Principles", Arrays.asList(
				"D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho",
				"Monica S. Lam"), "Pearson Education Singapore Pte Ltd", 2008,
				1009, "BOOK_IMAGE");

		book2 = new Book("9788183331630", "Let Us C 13th Edition",
				Arrays.asList("Yashavant Kanetkar"), "BPB PUBLICATIONS", 2012,
				675, "BOOK_IMAGE");

		// Stubbing the methods of bookDal with mocked data
		Mockito.when(bookDal.getAllBooks()).thenReturn(
				Arrays.asList(book1, book2));
		Mockito.when(bookDal.getBook("8131721019")).thenReturn(book1);
		Mockito.when(bookDal.addBook(book1)).thenReturn(book1.getIsbn());
		Mockito.when(bookDal.updateBook(book1)).thenReturn(book1.getIsbn());

	}

	@Test
	public void testGetAllBooks() {

		List<Book> allBooks = bookDal.getAllBooks();
		assertEquals(2, allBooks.size());
		Book mybook = allBooks.get(0);
		assertEquals("8131721019", mybook.getIsbn());

	}

	@Test
	public void testGetBook() {
		String isbn = "8131721019";
		Book mybook = bookDal.getBook(isbn);
		assertNotNull(mybook);
		assertEquals(isbn, book1.getIsbn());
	}

	@Test
	public void testAddBook() {
		String isbn = bookDal.addBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}

	@Test
	public void testUpdateBook() {
		String isbn = bookDal.updateBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}

}
