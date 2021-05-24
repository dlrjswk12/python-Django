package work.book;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource(name = "bookDAO")
	private BookDAO bookDAO;

	public List<Map<String, String>> retrieveBookList(Map<String, String> rentParam){
		return bookDAO.retrieveBookList(rentParam);
	}

	public BookBean retrieveBook(Map<String, String> bookParam){
		return bookDAO.retrieveBook(bookParam);
	}

	public void createBook(BookBean book){
		bookDAO.createBook(book);
	}

	public void updateBook(BookBean book){
		bookDAO.updateBook(book);
	}

	public List<Map<String, String>> retrieveStatisticsForGenre(){
		return bookDAO.retrieveStatisticsForGenre();
	}

	public List<Map<String, String>> retrieveStatisticsForBookPublisher(){
		return bookDAO.retrieveStatisticsForBookPublisher();
	}

	public List<Map<String, String>> retrieveStatisticsForAuthor(){
		return bookDAO.retrieveStatisticsForAuthor();
	}

	public List<Map<String, String>> retrieveStatisticsForBookStatus(){
		return bookDAO.retrieveStatisticsForBookStatus();
	}
}
