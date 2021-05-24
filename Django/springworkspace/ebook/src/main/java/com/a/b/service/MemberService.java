package com.a.b.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.a.b.dao.MDao;
import com.a.b.dto.Member;

public class MemberService implements IBoarderService {
	
	private SqlSession sqlSession=Constant.sqlSession;
	private String id;
	public MemberService() {}
	public MemberService(String id) {
		this.id = id;
	}

	@Override
	public void execute(Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		Member dtos = dao.memberView(id);
		model.addAttribute("memView", dtos);
	}

}
