package work.reserve;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void createReserve(Map<String, String> reserve){
		sqlSession.insert("reserve.createReserve", reserve);
	}

	public void deleteReserve(Map<String, String> reserveParam){
		sqlSession.delete("reserve.deleteReserve", reserveParam);
	}

	public ReserveBean retrieveReserve(Map<String, String> reserveParam){
		return sqlSession.selectOne("reserve.retrieveReserve", reserveParam);
	}

}
