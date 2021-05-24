package com.sjw.mybatisboard;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sjw.mybatisboard.dao.HDao;
import com.sjw.mybatisboard.dao.MDao;
import com.sjw.mybatisboard.dto.MDto;
import com.sjw.mybatisboard.service.BContentService;
import com.sjw.mybatisboard.service.BDeleteService;
import com.sjw.mybatisboard.service.BListService;
import com.sjw.mybatisboard.service.BModifyService;
import com.sjw.mybatisboard.service.BReplyService;
import com.sjw.mybatisboard.service.BReplyViewService;
import com.sjw.mybatisboard.service.BUpHitService;
import com.sjw.mybatisboard.service.BWriteService;
import com.sjw.mybatisboard.service.Constant;
import com.sjw.mybatisboard.service.HomeBookModifyService;
import com.sjw.mybatisboard.service.IBoarderService;
import com.sjw.mybatisboard.service.LoginService;
import com.sjw.mybatisboard.service.MemberListService;


@Controller // DispatcherServlet Context 가 사용할 컨트롤러임을 알림
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	IBoarderService service;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		// 혹 다른쪽에서 필요하면 사용하려고 임의의 클래스에 템플릿을 지정했음
		Constant.sqlSession = this.sqlSession;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("locale", locale);
		return "main";
	}
	
	@RequestMapping(value = "/main")
	public String main(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("locale",locale);
		return "main";
	}
	
	
	
	// 로그인 및 회원가입
	
	
	//로그인창으로
	@RequestMapping(value = "/formLogin")
	public String formLogin(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		return "./login/formLogin";
	}
	
	
	@RequestMapping(value = "/logindo") 
		public String logindo(Model model ,HttpServletRequest request , HttpSession session ) {
		System.out.println("로그인서비스실행중");
		model.addAttribute("request",request);
		model.addAttribute("session",session);
		service = new LoginService();
		service.execute(model);
		
		return "main";
	}
	
	
	
	
	
	// 회원가입창
	@RequestMapping(value = "/memberJoin")
		public String memberJoin(HttpServletRequest request ,Model model ) {
		return "./member/memberJoin";
	}

	
	//회원가입
	@RequestMapping(value = "/memberJoinDo")
		public String memberJoinDo(Model model , HttpServletRequest request , HttpSession session ) {
		MDao dao = sqlSession.getMapper(MDao.class);
		String id  = request.getParameter("mid");
		MDto dto = dao.memberView(id);
		
		if (!(dto == null)) {
			System.out.println(id + "님 회원 가입 되지 않았습니다. 아이디가 중복되었을 수 있습니다!");
			return "main";
			
		} else {
			Timestamp joindate = new Timestamp(System.currentTimeMillis());
			String password = request.getParameter("mpassword");
			String phone = request.getParameter("mphone");
			if (!password.equals(request.getParameter("mpassword2"))) {
				System.out.println( "패스워드중복 불일치");
			} else {
				
				try {
					dao.memberJoin(id, joindate, password, phone);
					System.out.println(id + "님 회원 가입완료!");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(id + "님 회원 가입 되지 않았습니다 !");
				}
				
			}
			
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/memberInforDo")
	public String memberInforDo(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "./member/memberInfor";
	}
	
	
	
	@RequestMapping(value = "/logout") 
	public String logout(Model model, HttpServletRequest request , HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		session.removeAttribute("loginOk");
		session.removeAttribute("joinVo");
		
		
		return "main";
	}
	
	
	@RequestMapping("/memberlist")
	public String memberlist(Model model) {
		System.out.println("memberlist()");
		service = new MemberListService();
		service.execute(model);
		return "./member/allMemberList";
	}
	
	
	
	///////////////////////////////////////////////////////
	
	

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		service = new BListService();
		service.execute(model);
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}

	@RequestMapping(value = "/write",produces="text/plain; charset=UTF-8")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");

		model.addAttribute("request", request);
		service = new BWriteService();
		service.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");

		model.addAttribute("request", request);
		service = new BContentService();
		service.execute(model);

		return "content_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");

		model.addAttribute("request", request);
		service = new BReplyViewService();
		service.execute(model);

		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");

		model.addAttribute("request", request);
		service = new BReplyService();
		service.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");

		model.addAttribute("request", request);
		service = new BDeleteService();
		service.execute(model);
		return "redirect:list";
	}
	@RequestMapping("/upHit")
	public void upHit(HttpServletRequest request,Model model) {
		System.out.println("upHit()");

		model.addAttribute("request", request);
		service = new BUpHitService();
		service.execute(model);
		//return "redirect:content_view";
	}
	

	////////////////////////////////////// 가계부 작업
	
	@RequestMapping(value = "/fHomebook")
	public String fHomeBook(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		return "./homebook/form_homebook";
	}
	
	@RequestMapping(value = "/homebookDo")
	public String homebookDo (Model model, HttpServletRequest request, HttpSession session) {
		HDao dao = sqlSession.getMapper(HDao.class);
		// 여기는 공부해야한다
		String timeFormat = request.getParameter("day");
		LocalDateTime ldt = LocalDateTime.parse(timeFormat);//, "yyyy-mm-dd xx tt:MM");
		Timestamp day = Timestamp.valueOf(ldt);
		String section = request.getParameter("section");
		String accounttitle = request.getParameter("accountTitle");
		String remark = request.getParameter("remark");
		int revenue = Integer.parseInt(request.getParameter("revenue"));
		int expense = Integer.parseInt(request.getParameter("expense"));
		String mid = request.getParameter("userId");
		
		dao.bookWrite(day, section, accounttitle, remark, revenue, expense, mid);
		return "redirect:homelist";
		
	
	}
	
	@RequestMapping("/homelist")
	public String booklist(Model model) {
		System.out.println("homelist()");
		//service = new HomeBookListService(???);// homelist에서 실행 
		//service.execute(model);// homelist에서 실행 
		return "./homebook/homelist";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/homebookAdjustDo")
	public String homebookAdjustDo(HttpServletRequest request, Model model) {
		long serialNo = Long.parseLong(request.getParameter("no"));
		System.out.println("homebookAdjustDo()===>("+serialNo+")");
		model.addAttribute("request", request);
		HomeBookModifyService service = new HomeBookModifyService();// 인터페이스에 없는 추가메소드 수행을 위해 인터페이스로 선언하지 않았음 
		service.setSerialNo(serialNo);
		service.execute(model);
		return "./homebook/form_homebookAdjust";
	}
	
}
