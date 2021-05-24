package com.sjw.mybatisboard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.sjw.mybatisboard.dao.MDao;
import com.sjw.mybatisboard.dto.MDto;



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
		MDto mdto = dao.memberView(id);
		long no = mdto.getNo();
		
		
		if (mdto.getPassword().equals(password)) {
			System.out.println("로그인 성공");
			session.setAttribute("no", no);
			session.setAttribute("id", id);
			session.setAttribute("pw",password);// 혹 필요할지 몰라서 추가
			session.setAttribute("loginOk","ok");//혹 필요할지 몰라서 추가
			session.setAttribute("joinVo",mdto);
			
			model.addAttribute("session",session);
			
		}else {
			System.out.println("로그인 실패");
		}
		

	}

}
