package work.book;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Map<String, String>> retrieveBookList(Map<String, String> rentParam){
		return sqlSession.selectList("book.retrieveBookList", rentParam);
	}

	public BookBean retrieveBook(Map<String, String> bookParam){
		return sqlSession.selectOne("book.retrieveBook", bookParam);
	}

	public void createBook(BookBean book){
		sqlSession.insert("book.createBook", book);
	}

	public void updateBook(BookBean book){
		sqlSession.update("book.updateBook", book);
	}

	public List<Map<String, String>> retrieveStatisticsForGenre(){
		return sqlSession.selectList("book.retrieveStatisticsForGenre");
	}

	public List<Map<String, String>> retrieveStatisticsForBookPublisher(){
		return sqlSession.selectList("book.retrieveStatisticsForBookPublisher");
	}

	public List<Map<String, String>> retrieveStatisticsForAuthor(){
		return sqlSession.selectList("book.retrieveStatisticsForAuthor");
	}

	public List<Map<String, String>> retrieveStatisticsForBookStatus(){
		return sqlSession.selectList("book.retrieveStatisticsForBookStatus");
	}
}
