package com.a.b.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.a.b.service.IBoarderService;
import com.a.b.service.LoginService;
import com.a.b.service.MDeleteService;
import com.a.b.service.MModifyService;
import com.a.b.service.MemberService;
import com.a.b.util.UploadFileUtils;
import com.a.b.service.AdminBListService;
import com.a.b.service.AdminContentService;
import com.a.b.service.AdminDeleteService;
import com.a.b.service.AdminModifyService;
import com.a.b.service.AdminWrite;
import com.a.b.service.Constant;
import com.a.b.dao.BDao;
import com.a.b.dao.EDao;
import com.a.b.dao.MDao;
import com.a.b.dto.Ebook;
import com.a.b.dto.Member;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
//	  @Resource(name="uploadPath") private String uploadPath;
	 
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	IBoarderService service;
	SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("request", request);
		model.addAttribute("locale", locale);
		return "main";
	}
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Locale locale, Model model, HttpServletRequest request) {
		return "main";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/ID_Check", produces="text/plane")
	public String ID_Check(@RequestBody String paramData) {
		String bid = paramData.trim();
		MDao dao = sqlSession.getMapper(MDao.class);
		Member dto = dao.Id_Check(bid);
		if(dto != null) {
			return "-1";
		}else {
			return "0";
		}
	}
	@RequestMapping(value = "/login")
	public String flogin(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		return "login/login";
	}
	@RequestMapping("/logindo")
	public String logindo(HttpServletRequest request, Model model, HttpSession session) {
		String bId = request.getParameter("id");
		if(bId == null) {
			return "memberjoin";
		}else {
		model.addAttribute("request", request);
		model.addAttribute("session", session);
		service = new LoginService();
		service.execute(model);
		return "redirect:main";
		}
	}
	@RequestMapping("/idSearch")
	public String idsearch(HttpServletRequest request, Model model) {
		return "login/idsearch";
	}
	@RequestMapping(value="/idsearchdo")
	public String idsearchdo(HttpServletRequest request, Model model, HttpSession session) {
		MDao dao = sqlSession.getMapper(MDao.class);
		String id = request.getParameter("bid");
		String bName = request.getParameter("name");
		Date bBirthday = Date.valueOf(request.getParameter("birthday"));
		if(id != null) {
			String pw = dao.passwordsearch(id, bName, bBirthday);
			session.setAttribute("searchID", pw);
			model.addAttribute("session", session);
		}else {
			String bid = dao.idsearch(bName, bBirthday);			
			session.setAttribute("searchID", bid);
			model.addAttribute("session", session);
		}
		
		return "login/id&pwsearch";
	}
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		session.removeAttribute("joinVo");
		return "redirect:main";
	}

	
	@RequestMapping(value = "/memberjoin")
	public String memberJoin(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "member/memberjoin";
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
	@RequestMapping("/memdata")
	public String memdata(Model model, HttpSession session) {
		return "member/memdata";
	}
	@RequestMapping("/memmodify")
	public String memmodify(Model model, HttpServletRequest request) {
		String bId = request.getParameter("bId");
		model.addAttribute("request", request);
		MModifyService service = new MModifyService();
		service.setbId(bId);
		service.execute(model);
		
		return "member/membermodify";
	}
	@RequestMapping(value="/memmodifydo", method = RequestMethod.POST)
	public String memmodifydo(HttpServletRequest request, Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		HttpSession session = request.getSession();
		String bId = request.getParameter("bId");
		String bPw = request.getParameter("password");
		String bName = request.getParameter("name");
		dao.memberModify(bPw, bName, bId);
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		session.removeAttribute("joinVo");
		
		return "redirect:login";
	}
	@RequestMapping("/memdelete")
	public String memdelete(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("request", request);
		service = new MDeleteService();
		service.execute(model);
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		session.removeAttribute("mainpage");
		session.removeAttribute("joinVo");
		
		return "redirect:main";
	}
	
	
	@RequestMapping("/adminpage")
	public String adminpage(HttpServletRequest request,Model model) {
		return "admin/adminpage";
	}
	
	
	@RequestMapping("/cashup")
	public String cashup(HttpServletRequest request, Model model) {
		return "cashup";
	}
	@RequestMapping("/cashupdo")
	public String cashupdo(HttpServletRequest request, Model model, HttpSession session) {
		MDao dao = sqlSession.getMapper(MDao.class);
		String bid = request.getParameter("bId");
		long bcash = Long.parseLong(request.getParameter("bCash"));
		Member member = dao.memberView(bid);
		session.removeAttribute("joinVo");
		dao.cashupdown(bid, bcash);
		session.setAttribute("joinVo",member);
		model.addAttribute("session", session);
		
		return "redirect:main";
	}
	@RequestMapping(value="/booksearch", method=RequestMethod.POST)
	public String bookSearch(HttpServletRequest request, Model model,HttpSession session) {
		EDao dao = sqlSession.getMapper(EDao.class);
		String searchRe = request.getParameter("searchType");
		String search = request.getParameter("search");
		if(searchRe.equals("Bookname")) {
			ArrayList<Ebook> ebook = dao.namesearch(search);
			session.setAttribute("sear_result", ebook);
			model.addAttribute("session", session);
		}else if(searchRe.equals("Publisher")) {
			ArrayList<Ebook> ebook = dao.publishersearch(search);
			session.setAttribute("sear_result", ebook);
			model.addAttribute("session", session);
		}else if(searchRe.equals("Writer")) {
			ArrayList<Ebook> ebook = dao.writersearch(search);
			session.setAttribute("sear_result", ebook);
			model.addAttribute("session", session);
		}else if(searchRe.equals("Category")) {
			ArrayList<Ebook> ebook = dao.categorysearch(search);
			session.setAttribute("sear_result", ebook);
			model.addAttribute("session", session);
		}else if(searchRe.equals("all")) {
			ArrayList<Ebook> ebook = dao.allsearch(search);
			session.setAttribute("sear_result", ebook);
			model.addAttribute("session", session);
		}
		return "searchlist";
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
	
		@RequestMapping(value = "/Adminwrite", method=RequestMethod.POST)
		public String AdminWrite(MultipartHttpServletRequest multi, Model model){
		
			
			MultipartFile uploadFile = multi.getFile("file");
			
			
			String name = multi.getParameter("bBookname");
			

			System.out.println(uploadFile.getOriginalFilename());
			
			String fileName = uploadFile.getOriginalFilename();
			
			System.out.println(name+"네임이다");
			System.out.println(fileName+"파일네임이다");
				
			if(!uploadFile.isEmpty()) {
				File file = new File("J:/", uploadFile.getOriginalFilename());
				
				try {
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("돌아와그대");
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("돌아와그대2");
				}
			}
			
			
			
			
			
		//	model.addAttribute("multi",multi);
			
			//service = new AdminWrite();
			
			 
			String bBookname = multi.getParameter("bBookname");

			String bUrl = fileName;
			
			String bContent = multi.getParameter("bContent");
			
			long bPrice =Long.parseLong(multi.getParameter("bPrice"));
			
			String bWriter =multi.getParameter("bWriter");
			
			String bPublisher = multi.getParameter("bPublisher");
			
			String bCategory = multi.getParameter("bCategory");
			
		

			
			
			BDao dao = sqlSession.getMapper(BDao.class);
			
			
			System.out.println("아래1"+bUrl);
			
			System.out.println("아래2"+bContent);
			
			
			dao.write(bBookname, bUrl ,bContent, bPrice, bWriter, bPublisher, bCategory);
			
		

			
			
			
			
			
		//	service.execute(model);
			
			return "redirect:AdminBookList";
	
	//	MultipartFile mf = request.getFile("file");
		
	//	String path = "C:/img/";
		

			 
			 
			 
			//model.addAttribute("multipartFile",multipartFile);	
		
		//service.execute(model);
		
		

//			  cmf = (CommonsMultipartFile) files.get("file"); String path
//			  ="J:/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ebook()/resources/img/"
//			  +cmf.getOriginalFilename();	 
//			  File f = new File(path); cmf.transferTo(f);
			 
			
			 

			
		//	Map<String, MultipartFile> files = request.getFileMap();
			//MultipartHttpServletRequest files1 =  (MultipartHttpServletRequest) files.get(file);
			
				//MultipartRequest multi=new MultipartRequest(request,"C:\\upload\\tmp", "utf-8", "MS949",new DefaultFileRenamePolicy());
				
		
				
			
			
		//model.addAttribute("request",request);


			
	//	service = new AdminWrite();
		//service.execute(model);
		
		
			
			
			
					
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
	
	
	
	
	
}
