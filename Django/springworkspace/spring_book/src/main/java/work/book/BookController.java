package work.book;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import work.code.CodeBean;
import work.code.CodeService;

@Controller
public class BookController {
	@Resource(name = "bookService")
	private BookService bookService;

	@Resource(name = "codeService")
	private CodeService codeService;

	@RequestMapping(value="/work/book/createBook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createBook(@ModelAttribute BookBean book, HttpServletRequest request){
		List<CodeBean> dsCode1 = null; //장르

		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> bookParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); //장르

		mv.addObject("dsCode1", dsCode1);

		String flag = book.getBookName(); //BookBean 존재여부

		if(flag == null){
			mv.setViewName("/bookmanage/bookRegisterC");
		}else if(flag != null){
			//도서 생성
			bookService.createBook(book);

			mv.addObject("dsBookList", bookService.retrieveBookList(bookParam));
			mv.setViewName("redirect:/work/book/retrieveBookListRForManage.do");
		}

		return mv;
	}

	@RequestMapping(value="/work/book/updateBook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateBook(@ModelAttribute BookBean book, HttpServletRequest request){
		String bookCode = null;
		BookBean dsBook = null;
		List<CodeBean> dsCode1 = null; //장르

		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> bookParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); //장르

		mv.addObject("dsCode1", dsCode1);

		String flag = book.getBookName(); //BookBean 존재여부

		if(flag == null){
			bookCode = request.getParameter("bookCode");

			bookParam.put("bookCode", bookCode);
			dsBook = bookService.retrieveBook(bookParam);

			mv.addObject("dsBook", dsBook);

			mv.setViewName("/bookmanage/bookRegisterU");
		}else if(flag != null){
			//도서 수정
			bookService.updateBook(book);

			mv.addObject("dsBookList", bookService.retrieveBookList(bookParam));
			mv.setViewName("redirect:/work/book/retrieveBookListRForManage.do");
		}

		return mv;
	}
	@RequestMapping(value="/work/book/retrieveBookListRForManage.do", method = RequestMethod.GET)
	public ModelAndView retrieveBookListRForManage(@ModelAttribute BookBean book, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map<String, String> bookParam = new HashMap<String, String>();

		bookParam.put("manageParam", "true");

		mv.addObject("dsBookList", bookService.retrieveBookList(bookParam));
		mv.setViewName("/bookmanage/bookListRForManage");

		return mv;
	}

	@RequestMapping(value="/work/book/goMain.do", method=RequestMethod.GET)
	public ModelAndView goMain(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/book/main");
		return mv;
	}

	@RequestMapping(value="/work/book/retrieveBookList.do", method=RequestMethod.GET)
	public ModelAndView retrieveBookList(){
		ModelAndView mv = new ModelAndView();

		Map<String, String> rentParam = new HashMap<String, String>();

		List<Map<String, String>> dsBookList = bookService.retrieveBookList(rentParam);

		mv.addObject("dsBookList", dsBookList);
		mv.setViewName("/book/bookListR");
		return mv;
	}

	@RequestMapping(value="/work/book/retrieveBookListForRent.do", method=RequestMethod.GET)
	public ModelAndView retrieveBookListForRent(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		String grade = (String)session.getAttribute("grade");

		Map<String, String> rentParam = new HashMap<String, String>();
		rentParam.put("grade", grade);

		List<Map<String, String>> dsBookList = bookService.retrieveBookList(rentParam);

		mv.addObject("dsBookList", dsBookList);
		mv.setViewName("/bookmanage/bookListRForRent");
		return mv;
	}

	@RequestMapping(value="/work/book/saveFile.do", method=RequestMethod.POST)
	@ResponseBody
	public String saveFile(HttpServletRequest request ) throws IOException {
		String imgFolder ="\\bookImage\\"; //저장할 경로
		String realFolder = request.getRealPath("/") + imgFolder; //web-inf바로전 까지 저장할 경로
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest)request;
		MultipartFile file = multipartRequest.getFile("imageFile"); //단일 파일 업로드
		String filename = file.getOriginalFilename();

		File ufile = new File(realFolder + file.getOriginalFilename());
		file.transferTo((ufile));

		return filename;
	}


	@RequestMapping(value="/work/book/retrieveStatisticsForGenre.do",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForGenre(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");

		System.out.println("sort:"+sort);
		
		JSONArray jsonDonutArr = new JSONArray();
		JSONArray jsonBarArr = new JSONArray();

		List<Map<String, String>> dsGenre = bookService.retrieveStatisticsForGenre();
		JSONObject jsonObj = null;

		for(int i = 0; i < dsGenre.size(); i++){
			jsonObj = new JSONObject();
			String bookGenreCdNm = dsGenre.get(i).get("BOOK_GENRE_CD_NM");
			String bookGenreCount = String.valueOf(dsGenre.get(i).get("BOOK_GENRE_COUNT"));

			jsonObj.put("label", bookGenreCdNm);
			jsonObj.put("value", bookGenreCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JSONObject();

			jsonObj.put("y", bookGenreCdNm);
			jsonObj.put("a", bookGenreCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsR");

		return mv;
	}

	@RequestMapping(value="/work/book/retrieveStatisticsForBookStatus.do",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForBookStatus(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");

		System.out.println("sort:"+sort);
		
		JSONArray jsonDonutArr = new JSONArray();
		JSONArray jsonBarArr = new JSONArray();

		List<Map<String, String>> dsBookStatus = bookService.retrieveStatisticsForBookStatus();
		JSONObject jsonObj = null;

		for(int i = 0; i < dsBookStatus.size(); i++){
			jsonObj = new JSONObject();
			String bookStatusNm = dsBookStatus.get(i).get("BOOK_STATUS_NM");
			String bookStatusCount = String.valueOf(dsBookStatus.get(i).get("BOOK_STATUS_COUNT"));

			jsonObj.put("label", bookStatusNm);
			jsonObj.put("value", bookStatusCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JSONObject();

			jsonObj.put("y", bookStatusNm);
			jsonObj.put("a", bookStatusCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsR");

		return mv;
	}

	@RequestMapping(value="/work/book/retrieveStatisticsForBookPublisher.do",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForBookPublisher(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");
		
		System.out.println("sort:"+sort);

		JSONArray jsonDonutArr = new JSONArray();
		JSONArray jsonBarArr = new JSONArray();

		List<Map<String, String>> dsBookPublisher = bookService.retrieveStatisticsForBookPublisher();
		JSONObject jsonObj = null;

		for(int i = 0; i < dsBookPublisher.size(); i++){
			jsonObj = new JSONObject();
			String bookPublisher = dsBookPublisher.get(i).get("BOOK_PUBLISHER");
			String bookPublisherCount = String.valueOf(dsBookPublisher.get(i).get("BOOK_PUBLISHER_COUNT"));

			jsonObj.put("label", bookPublisher);
			jsonObj.put("value", bookPublisherCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JSONObject();

			jsonObj.put("y", bookPublisher);
			jsonObj.put("a", bookPublisherCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsR");

		return mv;
	}

	@RequestMapping(value="/work/book/retrieveStatisticsForAuthor.do",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForAuthor(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");
		
		System.out.println("sort:"+sort);

		JSONArray jsonDonutArr = new JSONArray();
		JSONArray jsonBarArr = new JSONArray();

		List<Map<String, String>> dsAuthor = bookService.retrieveStatisticsForAuthor();
		JSONObject jsonObj = null;

		for(int i = 0; i < dsAuthor.size(); i++){
			jsonObj = new JSONObject();
			String bookAuthor = dsAuthor.get(i).get("BOOK_AUTHOR");
			String bookAuthorCount = String.valueOf(dsAuthor.get(i).get("BOOK_AUTHOR_COUNT"));

			jsonObj.put("label", bookAuthor);
			jsonObj.put("value", bookAuthorCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JSONObject();

			jsonObj.put("y", bookAuthor);
			jsonObj.put("a", bookAuthorCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsR");

		return mv;
	}



}
