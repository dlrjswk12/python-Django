package work.rent;

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
import work.reserve.ReserveBean;
import work.reserve.ReserveService;
import work.user.UserService;

@Controller
public class RentController {
	@Resource(name = "rentService")
	private RentService rentService;

	@Resource(name = "bookService")
	private BookService bookService;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "reserveService")
	private ReserveService reserveService;

	@RequestMapping(value="/work/rent/createRent.do", method=RequestMethod.GET)
	public ModelAndView createRent(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = null;

		userCode = request.getParameter("userCode");

		if(userCode == null){
			userCode = (String)session.getAttribute("userCode");
			mv.setViewName("redirect:/work/book/retrieveBookList.do");
		}else{
			mv.setViewName("redirect:/work/book/retrieveBookListForRent.do");
		}

		String bookCode = request.getParameter("bookCode");

		Map<String, String> rentParam = new HashMap<String, String>();
		Map<String, String> userParam = new HashMap<String, String>();

		rentParam.put("bookCode", bookCode);
		rentParam.put("userCode", userCode);

		userParam.put("userCode", userCode);

		//대출정보 추가
		rentService.createRent(rentParam);

		//대출책수 증가
		userService.updatePlusRentBookCnt(userParam);

		return mv;
	}

	@RequestMapping(value="/work/rent/retrieveMyExtendList.do", method=RequestMethod.GET)
	public ModelAndView retrieveMyExtendList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> rentParam = new HashMap<String, String>();

		rentParam.put("userCode", userCode);
		rentParam.put("rentParam", "true");

		List<Map<String, String>> dsBookList = bookService.retrieveBookList(rentParam);

		mv.addObject("dsBookList", dsBookList);
		mv.setViewName("/bookextend/extendListR");
		return mv;
	}

	@RequestMapping(value="/work/rent/updateConfirmRent.do", method=RequestMethod.GET)
	public ModelAndView updateConfirmRent(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String rentNo = request.getParameter("rentNo");

		Map<String, String> rentParam = new HashMap<String, String>();

		rentParam.put("rentNo", rentNo);

		rentService.updateConfirmRent(rentParam);

		mv.setViewName("redirect:/work/book/retrieveBookListForRent.do");
		return mv;
	}

	@RequestMapping(value="/work/rent/deleteReturn.do", method=RequestMethod.GET)
	public ModelAndView deleteReturn(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String userCode =  request.getParameter("userCode");
		String rentNo = request.getParameter("rentNo");

		Map<String, String> rentParam = new HashMap<String, String>();
		Map<String, String> userParam = new HashMap<String, String>();
		Map<String, String> reserveParam = new HashMap<String, String>();

		rentParam.put("rentNo", rentNo);
		reserveParam.put("rentNo", rentNo);

		userParam.put("userCode", userCode);

		rentService.deleteReturn(rentParam);

		userService.updateMinusRentBookCnt(userParam);

		//TODO 1. rentNo로 예약테이블 조회, bean 존재하면 userCode, bookCode가지고 createRent.do로 이동
		ReserveBean reserveBean = reserveService.retrieveReserve(reserveParam);

		if(reserveBean == null){
			mv.setViewName("redirect:/work/book/retrieveBookListForRent.do");
		}else{
			String reserveUserCode = reserveBean.getUserCode();
			String reserveBookCode = reserveBean.getBookCode();
			String reserveReserveNo = reserveBean.getReserveNo();

			reserveParam.put("reserveNo", reserveReserveNo);

			reserveService.deleteReserve(reserveParam); //예약정보 삭제
			mv.setViewName("redirect:/work/rent/createRent.do?userCode=" + reserveUserCode + "&bookCode=" + reserveBookCode); //예약한 사람의 정보를 가지고 대출정보 생성
		}

		return mv;
	}

	@RequestMapping(value="/work/rent/updateExtend.do", method=RequestMethod.GET)
	public ModelAndView updateExtend(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String rentNo = request.getParameter("rentNo");

		Map<String, String> rentParam = new HashMap<String, String>();

		rentParam.put("rentNo", rentNo);

		rentService.updateExtend(rentParam);

		mv.setViewName("redirect:/work/rent/retrieveMyExtendList.do");
		return mv;
	}
}
