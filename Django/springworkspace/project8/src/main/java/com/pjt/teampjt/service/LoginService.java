package com.pjt.teampjt.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import com.pjt.teampjt.dao.MDao;
import com.pjt.teampjt.dto.MyMember;

public class LoginService implements IBoarderService {
	private SqlSession sqlSession=Constant.sqlSession;
	public LoginService(){}
	@Override
	public void execute(Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = (HttpSession) map.get("session");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MyMember member = dao.memberView(id);
		long no = member.getNo();
		
		if(member.getPassword().equals(password)) {
			System.out.println("login");
			session.setAttribute("no", no);
			session.setAttribute("id", id);
			session.setAttribute("pw",password);
			session.setAttribute("loginOk","ok");
			session.setAttribute("joinVo",member);
			
			model.addAttribute("session", session);
			
		}else {
			System.out.println("login deny");
		}
		

	}
	
}
