package com.a.b.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.a.b.dao.BoardDao;
import com.a.b.dto.Board;

public class BoardContentService implements IBoarderService{
	private SqlSession sqlSession=Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bBid = request.getParameter("bBid");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		Board board = dao.boardContent_view(bBid);
		
		model.addAttribute("board", board);
		
	}

}
