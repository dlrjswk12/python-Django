package com.a.b.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.a.b.dao.BDao;
import com.a.b.dto.Ebook;

public class AdminBListService implements IBoarderService {

	private SqlSession sqlSession=Constant.sqlSession;
	private static final int MESSAGE_COUNT_PER_PAGE = 10;
	public AdminBListService(){}
	
	
	
	
	@Override
	public void execute(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		ArrayList<Ebook> dtos = dao.list();
		model.addAttribute("BookList",dtos);
		
		
	}

}
