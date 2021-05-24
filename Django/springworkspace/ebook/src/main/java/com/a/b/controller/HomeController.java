package com.a.b.controller;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.a.b.service.IBoarderService;
import com.a.b.service.LoginService;
import com.a.b.service.MModifyService;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


import com.a.b.service.BListService;
import com.a.b.service.Constant;
import com.a.b.dao.MDao;
import com.a.b.dto.Ebook;

import com.a.b.dto.Member;
import com.a.b.service.AdminBListService;
import com.a.b.service.AdminContentService;
import com.a.b.service.AdminDeleteService;
import com.a.b.service.AdminModifyService;
import com.a.b.service.AdminWrite;

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
		String bId = request.getParameter("mid");
		Member vo = dao.memberView(bId);
		
		if (!(vo == null)) {
			System.out.println(bId + "회원가입 실패");
			return "main";
		} else {
			String bName = request.getParameter("name");
			String bPw = request.getParameter("password");
			String bGender = request.getParameter("gender");
			Date bBirthday = Date.valueOf(request.getParameter("birthday"));
			Timestamp bJoindate = new Timestamp(System.currentTimeMillis());
			
			if (!bPw.equals(request.getParameter("password2"))) {
				System.out.println(bId + "패스워드가 다릅니다.");
			} else {

				try {
					dao.memberJoin(bId, bPw, bName, bGender, bBirthday, bJoindate);
					System.out.println(bId + " 회원 가입완료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(bId + " 회원 가입 되지 않았습니다.");
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
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		session.removeAttribute("mainpage");
		session.removeAttribute("joinVo");
		return "redirect:main";
	}
//	@RequestMapping(value="/user/idCheck", method=RequestMethod.GET)
//	@ResponseBody
//	public int idCheck(@RequestParam("mid") String mid) {
//		MDao dao = sqlSession.getMapper(MDao.class);
//		
//		return dao.idcheck(mid);
//	}
	@RequestMapping("/memdata")
	public String memdata(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		MDao dao = sqlSession.getMapper(MDao.class);
		Member info = dao.memberView(id);
		model.addAttribute("memView", info);
		
		return "memdata";
	}
//	@RequestMapping("/membermodify")
//	public String memmodify(Model model, HttpServletRequest request) {
//		String id = request.getParameter("id");
//		model.addAttribute("request", request);
//		MModifyService service = new MModifyService();
//		return "membermodify";
//	}
//	@RequestMapping("/memmodifydo")
//	public String memmodifydo(HttpServletRequest request, Model model) {
//		MDao dao = sqlSession.getMapper(MDao.class);
//		HttpSession session = request.getSession();
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		
//		dao.memberModify(id, password, name);
//		
//		return "redirect:memdata";
//	}
	
	
	@RequestMapping("/adminpage")
	public String adminpage(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("locale", locale);
		return "./admin/adminpage";
	}
	
	
	@RequestMapping("/BookList")
	public String BookList(Model model) {
		service = new BListService();
		service.execute(model);
		return "book/BookList";
		
		
	}
	
	

	@RequestMapping("/AdminBookList")
	public String AdminBookList(Model model) {
		service = new AdminBListService();
		service.execute(model);
		
		return "admin/AdminBookList";
	
	
	
	}
	
	@RequestMapping("/Adminmodify")
	public String AdminModify(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
			
		service = new AdminModifyService();
		service.execute(model);
		
		return "redirect:AdminBookList";
	}
	
	
	@RequestMapping("/AdminDelete")
	public String delete(HttpServletRequest request, Model model) {
		

		model.addAttribute("request", request);
		service = new AdminDeleteService();
		service.execute(model);
		return "redirect:AdminBookList";
	}
	
	//책 추가
	
	@RequestMapping(value = "/Adminwrite", produces ="text/plain; charset=UTF-8",method=RequestMethod.POST)
	public String AdminWrite(HttpServletRequest request, Model model , MultipartFile bUrl , Ebook eb){
		eb.setbUrl(bUrl.getOriginalFilename());
		
		
	model.addAttribute("request",request);
	model.addAttribute("bUrl",bUrl);	
	
	//HttpServletRequest
	//MultipartFile 
		//model.addAttribute("request",request);
		
	service = new AdminWrite();
	service.execute(model);
		System.out.println("bUrl:"+((ServletRequest) request).getParameter("bUrl"));
		System.out.println("책이름:"+((ServletRequest) request).getParameter("bBookname"));
		
		
		return "redirect:AdminBookList";		
	}
	
	
	// 글 추가 화면
	
	@RequestMapping("/Adminwrite_view")
	public String write_view(Model model) {
		return "./admin/Adminwrite_view";
	}
	
	
	@RequestMapping("/AdminContent")
	public String AdminContent(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = new AdminContentService();
		service.execute(model);
		return "./admin/Admincontent_view";
	}
	
	

	/*
	 * @RequestMapping("uploadAction") public ResponseEntity<byte[]> uploadAction()
	 * { Map<String, Object> map = dao. }
	 */

	
// 파일 업로드 대한 처리 메서드
	//파일을  올릴수 있는 입력 창으로 이동
	
	
	/*
	 * @RequestMapping("/uploadForm") public String uploadForm() { return
	 * "uploadForm"; }
	 * 
	 * 
	 * // 전송되는 파일을 처리 하는 메서드 - 파일 여러개를 첨부할 수 있는 처리
	 * 
	 * @RequestMapping("/upload") public String upload(ArrayList<MultipartFile>
	 * files, Model model) {
	 * 
	 * 
	 * ArrayList<FileInfo> fileList = new ArrayList<FileInfo>();
	 * 
	 * 
	 * 
	 * //여러개의 파일을 files 라는 이름으로 받는다 for each 람다식을 이용한 처리를 함 //임시로 올렷다가 저장하라는 명령이 없어서
	 * 사라진다.
	 */		
		
		
		/*
		 * files.forEach(file -> { String fileName = file.getOriginalFilename(); long
		 * size = file.getSize();
		 * 
		 * FileInfo fi = new FileInfo(); fi.setFileName(fileName);
		 * 
		 * fi.setSize(size); fileList.add(fi);
		 * 
		 * 
		 * System.out.println(fileName); System.out.println(size);
		 * 
		 * 
		 * 
		 * });
		 */
		
		/*//첨부된 파일의 정보를 jsp에 보내기 위해서 model에 담아야 한다
		model.addAttribute("list",fileList);
		
		return "upload";
	}*/

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

