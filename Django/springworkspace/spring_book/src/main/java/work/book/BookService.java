package work.book;

import java.util.List;
import java.util.Map;

public interface BookService {
	public List<Map<String, String>> retrieveBookList(Map<String, String> rentParam);
	public BookBean retrieveBook(Map<String, String> bookParam);

	public void createBook(BookBean book);
	public void updateBook(BookBean book);

	public List<Map<String, String>> retrieveStatisticsForGenre();
	public List<Map<String, String>> retrieveStatisticsForBookStatus();
	public List<Map<String, String>> retrieveStatisticsForBookPublisher();
	public List<Map<String, String>> retrieveStatisticsForAuthor();

}
