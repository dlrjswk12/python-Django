package com.a.b.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.a.b.dao.BDao;
import com.a.b.dto.Ebook;


public class BListService implements IBoarderService {
	
	
	private SqlSession sqlSession=Constant.sqlSession;
	private static final int MESSAGE_COUNT_PER_PAGE = 10;
	public BListService(){}
	
	
	
	
	@Override
	public void execute(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		ArrayList<Ebook> dtos1 = dao.list();
		model.addAttribute("BookList",dtos1);
		
	}
	
	
	
	
}
