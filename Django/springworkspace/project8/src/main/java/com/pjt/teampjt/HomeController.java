package com.pjt.teampjt;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjt.teampjt.service.IBoarderService;
import com.pjt.teampjt.service.LoginService;
import com.pjt.teampjt.service.Constant;
import com.pjt.teampjt.dao.MDao;
import com.pjt.teampjt.dto.MyMember;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	IBoarderService service;
	SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("locale", locale);
		return "main";
	}
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Locale locale, Model model, HttpServletRequest request) {
		return "main";
	}
	
	
	
	
	
	@RequestMapping(value = "/memberjoin")
	public String memberJoin(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "/memberjoin";
	}
	@RequestMapping(value = "/login")
	public String flogin(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		return "login";
	}
	@RequestMapping("/memberdo")
	public String memberok(HttpServletRequest request, Model model, HttpSession session) {
		MDao dao = sqlSession.getMapper(MDao.class);
		String id = request.getParameter("mid");
		MyMember vo = dao.memberView(id);
		
		if (!(vo == null)) {
			System.out.println(id + "회원가입 실패");
			return "main";
		} else {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			String phone1 = request.getParameter("phone");
			String phone2 = request.getParameter("phone2");
			String phone3 = request.getParameter("phone3");
			String phone = phone1+"-"+phone2+"-"+phone3;
			String adress = request.getParameter("adress");
			if (!password.equals(request.getParameter("password2"))) {
				System.out.println(id + "패스워드가 다릅니다.");
			} else {

				try {
					dao.memberJoin(id, name, birthday, password, phone, adress);
					System.out.println(id + " 회원 가입완료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(id + " 회원 가입 되지 않았습니다.");
				}
			}

		}
		return "redirect:main";
	}
	@RequestMapping("/logindo")
	public String logindo(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		service = new LoginService();
		service.execute(model);
		return "redirect:main";
	}
	
	@RequestMapping("/adminpage")
	
	public String adminpage(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		
		
		
		return "adminhome";
	}
	
	
	
}
