package work.reserve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import work.book.BookService;
import work.user.UserService;

@Controller
public class ReserveController {
	@Resource(name = "reserveService")
	private ReserveService reserveService;

	@Resource(name = "bookService")
	private BookService bookService;

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value="/work/reserve/retrieveMyReserveList.do", method=RequestMethod.GET)
	public ModelAndView retrieveMyReserveList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> reserveParam = new HashMap<String, String>();

		reserveParam.put("userCode", userCode);
		reserveParam.put("reserveParam", "true");

		List<Map<String, String>> dsBookList = bookService.retrieveBookList(reserveParam);

		mv.addObject("dsBookList", dsBookList);
		mv.setViewName("/bookreserve/bookListRForReserve");
		return mv;
	}

	@RequestMapping(value="/work/reserve/createReserve.do", method=RequestMethod.GET)
	public ModelAndView createReserve(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");
		String bookCode = request.getParameter("bookCode");
		String rentNo   = request.getParameter("rentNo");

		Map<String, String> reserveParam = new HashMap<String, String>();
		Map<String, String> userParam = new HashMap<String, String>();

		reserveParam.put("userCode", userCode);
		reserveParam.put("bookCode", bookCode);
		reserveParam.put("rentNo", rentNo);

		userParam.put("userCode", userCode);

		//예약정보 추가
		reserveService.createReserve(reserveParam);

		//예약책수 증가
		userService.updatePlusReserveBookCnt(userParam);

		mv.setViewName("redirect:/work/reserve/retrieveMyReserveList.do");
		return mv;
	}

	@RequestMapping(value="/work/reserve/deleteReserve.do", method=RequestMethod.GET)
	public ModelAndView updateReserve(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");
		String reserveNo = request.getParameter("reserveNo");

		Map<String, String> reserveParam = new HashMap<String, String>();
		Map<String, String> userParam = new HashMap<String, String>();

		reserveParam.put("reserveNo", reserveNo);

		userParam.put("userCode", userCode);

		//예약취소
		reserveService.deleteReserve(reserveParam);

		//예약책수 감소
		userService.updateMinusReserveBookCnt(userParam);

		mv.setViewName("redirect:/work/reserve/retrieveMyReserveList.do");
		return mv;
	}

}
