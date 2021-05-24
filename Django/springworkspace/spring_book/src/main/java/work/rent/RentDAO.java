package work.rent;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void createRent(Map<String, String> rent){
		sqlSession.insert("rent.createRent", rent);
	}

	public void updateConfirmRent(Map<String, String> rentParam){
		sqlSession.update("rent.updateConfirmRent", rentParam);
	}

	public void deleteReturn(Map<String, String> rentParam){
		sqlSession.delete("rent.deleteReturn", rentParam);
	}

	public void updateExtend(Map<String, String> rentParam){
		sqlSession.update("rent.updateExtend", rentParam);
	}


}
