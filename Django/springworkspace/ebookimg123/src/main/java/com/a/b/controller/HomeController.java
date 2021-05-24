package com.a.b.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.a.b.service.IBoarderService;
import com.a.b.service.LoginService;
import com.a.b.service.MDeleteService;
import com.a.b.service.MModifyService;
import com.a.b.service.MemberService;
import com.a.b.service.RentalListService;
import com.a.b.service.AdminBListService;
import com.a.b.service.AdminContentService;
import com.a.b.service.AdminDeleteService;
import com.a.b.service.AdminMemberListService;
import com.a.b.service.AdminModifyService;
import com.a.b.service.AdminWrite;
import com.a.b.service.BoardContentService;
import com.a.b.service.BoardDeleteService;
import com.a.b.service.BoardListService;
import com.a.b.service.BoardModifyService;
import com.a.b.service.BoardWriteService;
import com.a.b.service.Constant;
import com.a.b.service.EbookListService;
import com.a.b.service.EbookListService2;
import com.a.b.dao.BDao;
import com.a.b.dao.EDao;
import com.a.b.dao.MDao;
import com.a.b.dto.Ebook;
import com.a.b.dto.Member;
import com.a.b.dto.RentalingList;


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
	public String home(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("request", request);
		model.addAttribute("locale", locale);
		return "main";
	}
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Locale locale, Model model, HttpServletRequest request) {
		return "main";
	}
	
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		service = new BoardListService();
		service.execute(model);
		
		return "boardList";
		
	}
	
	@RequestMapping("/boardWrite_view")
	public String boardWrite_view(Model model) {
		
		return "boardWrite_view";
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardWriteService();
		service.execute(model);
		
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardContent_view")
	public String boardContent_view(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new BoardContentService();
		service.execute(model);
		return "boardContent_view";
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new BoardModifyService();
		service.execute(model);
		
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service = new BoardDeleteService();
		service.execute(model);
		
		return "redirect:boardList";
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
	@RequestMapping(value="logindo", method=RequestMethod.POST)
	public void memberLogin(@RequestParam("userId") String userId,
							@RequestParam("userPwd") String userPwd,
							HttpServletResponse response, HttpSession session,
							Model model) throws IOException{
		Member member = new Member() ;
		member.setbId(userId);
		member.setbPw(userPwd);
		MDao dao = sqlSession.getMapper(MDao.class);
		Member loginUser = dao.memberView(userId);
			if(member.getbPw().equals(loginUser.getbPw())) {
				model.addAttribute("request", loginUser);
				session.setAttribute("id", userId);
				session.setAttribute("pw", userPwd);
				session.setAttribute("loginOk","ok");
				session.setAttribute("joinVo", loginUser);
				
				model.addAttribute("session", session);
				response.getWriter().print(true) ;
			} else {
				response.getWriter().print(false) ;
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
//		session.removeAttribute("no");
//		session.removeAttribute("id");
//		session.removeAttribute("pw");
//		session.removeAttribute("loginOk");
//		session.removeAttribute("joinVo");
//		session.removeAttribute("cash");
		session.invalidate();
		System.out.println("로그아웃.세션초기화");
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
		Member member = dao.memberView(bid);
		long bcash = Long.parseLong(request.getParameter("bCash"));
		long brecash = member.getbCash() + bcash;
		dao.cashupdown(bid, brecash);
		
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
	
		@RequestMapping(value = "/Adminwrite",method=RequestMethod.POST)
		public String AdminWrite(MultipartHttpServletRequest multi, Model model){
		//	eb.setbUrl(bUrl.getOriginalFilename());
			
			MultipartFile uploadFile = multi.getFile("file");
			
			
			String name = multi.getParameter("bBookname");
			
			
			System.out.println(uploadFile.getOriginalFilename());	
			
			String fileName = uploadFile.getOriginalFilename();
		
			System.out.println(fileName+"  파일네임이다");
				
			if(!uploadFile.isEmpty()) {
				
				//File file = new File("J:/springworkspace/ebookimg/src/main/webapp/resources/img/", uploadFile.getOriginalFilename());
				
				String Realpath = multi.getSession().getServletContext().getRealPath("/resources/ebook/");
				//String Realpath1 = multi.getSession().getServletContext().getRealPath("/resources/ebook/");
				
				System.out.println("리얼 Path:"+Realpath);
				File file = new File(Realpath, fileName);
				
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
			
			
			 
			String bBookname = multi.getParameter("bBookname");

			String bUrl = fileName;
			
			String bContent = multi.getParameter("bContent");
			
			long bPrice =Long.parseLong(multi.getParameter("bPrice"));
			
			String bWriter =multi.getParameter("bWriter");
			
			String bPublisher = multi.getParameter("bPublisher");
			
			String bCategory = multi.getParameter("bCategory");
			

			
			BDao dao = sqlSession.getMapper(BDao.class);
			
				
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
		
		
		
		@RequestMapping("/AdminMemberList")
		public String AdminMemberList(Model model) {
			
		service = new AdminMemberListService();
		service.execute(model);
		return "./admin/AdminMemberView";
		}
		
		
		
	
	///// ebook 리스트게시판
		
		@RequestMapping("/list")
		public String list(Model model) {
			System.out.println("list()");
			service = new EbookListService();
			service.execute(model);
			service = new EbookListService2();
			service.execute(model);
			
			
			return "./rental/list";
		}
		
		@RequestMapping("/rentallist")
		public String rentallist(Model model, HttpSession session) {
			
			String ok = (String)session.getAttribute("id");
			System.out.println(ok);
//			if (ok==null) { // if(ok.equals(null)) 하면 에러난다...
//				return "./rentallist";
//				}
//				EDao dao = sqlSession.getMapper(EDao.class);
//				ArrayList<RentalList> dtos = dao.ebookRentalList(ok);
//				model.addAttribute("rentallist", dtos);
//				return "./rentallist";
				
			service = new RentalListService();
			service.execute(model);
			return "./rental/rentallist";
		}
		
		@RequestMapping("/rentalinglist")
		public String rentallinglist(Model model, HttpSession session) {
			
			String ok = (String)session.getAttribute("id");
			if(ok==null) {
				return "./rental/rentalinglist";
			}
			System.out.println(ok);
			EDao dao = sqlSession.getMapper(EDao.class);
			dao.ebookRentalOverListDelete(ok); // 렌탈링리스트접근시 기간지난거 삭제하고
			
			
			ArrayList<RentalingList> dtos = dao.ebookRentalingList(ok);
			
			
			model.addAttribute("rentalinglist", dtos); // 기간지난거없어진걸 가져온다
			
			
			return "./rental/rentalinglist";
		}
		
		@RequestMapping("/ebookcontentview")
			public String ebookcontentview(Model model, HttpServletRequest request, HttpSession session) {
			System.out.println("e북세부페이지시작");
			String memberbId = (String)session.getAttribute("id");
			System.out.println(memberbId);
			
			//model.addAttribute("request", request);
			String bBookname = request.getParameter("bId");
			System.out.println(bBookname);
			System.out.println("e북세부페이지-1");
			
			EDao dao = sqlSession.getMapper(EDao.class);
			Ebook dto = dao.ebookView(bBookname);
			int dto2 = dao.ebookHit(bBookname);
			if (memberbId!=null) {
			int dto3 = dao.ebookRentalingCheck(memberbId, bBookname);
			model.addAttribute("ebook_view3", dto3);
			}
			model.addAttribute("ebook_view", dto);
			model.addAttribute("ebook_view2", dto2);
			//service.execute(model);
			
			System.out.println("e북세부페이지-2");
			return "./rental/ebookcontentview";
		}
		
		@RequestMapping("/rentaldo")
			public String rentaldo(Model model, 
					HttpServletRequest request, 
					HttpSession session) 
					throws UnsupportedEncodingException {
			
			MDao dao = sqlSession.getMapper(MDao.class);
			System.out.println("렌탈두내부시작");
			
			long bBookno = Integer.parseInt(request.getParameter("bBookno1"));
			System.out.println(bBookno);
			
			String bId = request.getParameter("bId1");
			System.out.println(bId);
			
			String bBookname = request.getParameter("bBookname1");
			System.out.println(bBookname);
			
			long coin = Integer.parseInt(request.getParameter("cash1"));
			System.out.println(coin);
			
			if(coin >= 3) {
				
				EDao dao2 = sqlSession.getMapper(EDao.class);
				dao2.rentalCashdown(bId);// 캐쉬 3 감소한다...
				session.removeAttribute("cash"); //기존 "cash"세션 삭제
			
				Member member = dao.memberView(bId); // 멤버dao 통해
				int cash = (int) member.getbCash(); // 겟캐쉬 새롭게
				session.setAttribute("cash", cash); // 새션에 새롭게
			System.out.println(cash);
			System.out.println("여까진오나");
				dao2.ebookRental(bId, bBookno);
				bBookname = URLEncoder.encode(bBookname, "UTF-8");
				return "redirect:./ebookcontentview?bId="+bBookname;
				//return "redirect:./ebookcontentview";
			} 
			else
				bBookname = URLEncoder.encode(bBookname, "UTF-8");
				return "redirect:./ebookcontentview?bId="+bBookname;
			}
		}
	
	
	

