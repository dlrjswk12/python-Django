package com.dywlr.mem.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dywlr.mem.form.FormUtil;
import com.dywlr.mem.model.ImgItem;
import com.dywlr.mem.model.Login;
import com.dywlr.mem.model.MemberInfo;
import com.dywlr.mem.model.MemberProfile;
import com.dywlr.mem.model.MemberProfileDb;
import com.dywlr.mem.service.LoginCheckService;
import com.dywlr.mem.service.MemberProfileService;
import com.dywlr.mem.service.MemberService;

@Controller
public class MemberController {

	@RequestMapping("main")
	public String main() {
		return "main";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login2(Login log, Model model, HttpSession session) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		LoginCheckService loginService = ctx.getBean(LoginCheckService.class);
		if(loginService.emailPwCheck(log)) {
			session.setAttribute("log",log.getEmail());
			ctx.close();
			String url = "redirect:main";
			return new ModelAndView(url);
		}else {
			ctx.close();
			model.addAttribute("ex","wrong");
			String url = "redirect:login";
			return new ModelAndView(url);
		}
	}
	
	@RequestMapping(value="/sign/permit", method=RequestMethod.GET)
	public String memberForm(@ModelAttribute("memberInfo")MemberInfo mem, Model model) {
		List<String> listSex = new ArrayList<>();
		listSex.add("남");
		listSex.add("여");
		model.addAttribute("listSex", listSex);
		
		List<String> listTel = new ArrayList<>();
		listTel.add("kt");
		listTel.add("skt");
		listTel.add("lg");
		model.addAttribute("listTel", listTel);
		
		return "registrationForm";
	}
	
	@RequestMapping(value="/sign/permit", method=RequestMethod.POST)
	public String memberForm2(@Valid @ModelAttribute("memberInfo") MemberInfo member,Errors error, Model model, HttpSession session) {
		if(error.hasErrors()) {
			model.addAttribute("listSex", FormUtil.sexual());
			model.addAttribute("listTel", FormUtil.tel());
			return "registrationForm";
		}
			try {
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
			MemberService dao = ctx.getBean(MemberService.class);
			dao.insertService(member);
			ctx.close();
			model.addAttribute("member", member);
			session.setAttribute("email", member.getEmail());
			return "registered"; 
			}catch(Exception ex) {
				model.addAttribute("listSex", FormUtil.sexual());
				model.addAttribute("listTel", FormUtil.tel());
				model.addAttribute("ex", "exception");
				return "registrationForm";
			}
	}
	@Transactional
	@RequestMapping(value="sign/profile", method=RequestMethod.GET)
	public String profile(@ModelAttribute("profile")MemberProfile mem, Model model, HttpSession session) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		MemberProfileService profileService = ctx.getBean(MemberProfileService.class);
		String realPath = profileService.realPath(session.getAttribute("log").toString());
				if(realPath==null)
			model.addAttribute("realPath", "../images/pro.PNG");
		else
			model.addAttribute("realPath",realPath);
		
		MemberProfileDb member = profileService.selectProfile(session.getAttribute("log").toString());
		ctx.close();

		model.addAttribute("member", member);
		model.addAttribute("email", (String)session.getAttribute("log"));
		model.addAttribute("serviceCategory",FormUtil.category());
		model.addAttribute("serviceLocale",FormUtil.locale());
		model.addAttribute("attendingList",FormUtil.attend());
		return "profileForm";
		
	}
	@Transactional
	@RequestMapping(value="sign/profile", method=RequestMethod.POST)
	public String profile1(@ModelAttribute("profile")MemberProfile mem, Model model) {
		System.out.println(mem.getEmail());
		model.addAttribute("serviceCategory",FormUtil.category());
		model.addAttribute("serviceLocale",FormUtil.locale());
		model.addAttribute("attendingList",FormUtil.attend());
		mem.setCategories(mem.getCategory());
		mem.setLocales(mem.getLocale());
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		MemberProfileService profileService = ctx.getBean(MemberProfileService.class);
		if(profileService.checkProfile(mem.getEmail())) {
			profileService.updateProfile(mem);
		}else {
			profileService.insertService(mem);
		}
		ctx.close();
		return "profileRegistered";
	}
	@Transactional
	@RequestMapping("sign/sign/upload")
	public ModelAndView uploadImage(@RequestParam("email") String email,
			@RequestParam(value="file") MultipartFile multi , Model model) throws IllegalStateException, IOException {
		
		if(!multi.isEmpty()) {
			Random random = new Random();
			long currentTime = System.currentTimeMillis();
			int randomValue = random.nextInt(50);
			String fileName = Long.toString(currentTime) + "_"+randomValue+"_"+multi.getOriginalFilename();
			
			File file = new File("C:\\Users\\dywlr\\Desktop\\member\\src\\main\\webapp\\WEB-INF\\resources", fileName );
			multi.transferTo(file);
			ImgItem img = new ImgItem();
			img.setEmail(email);
			img.setFilename(file.getName());
			img.setRealpath(file.getAbsolutePath());
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
			MemberService memService = ctx.getBean(MemberService.class);
			if(memService.imgCheck(email)) {
				memService.imgUpdate(img);
				System.out.println("이미지 업데이트 성공");
				ctx.close();
			}else {
				memService.add(img);
				ctx.close();
			}
			
		}
		
		model.addAttribute("serviceCategory",FormUtil.category());
		model.addAttribute("serviceLocale",FormUtil.locale());
		model.addAttribute("attendingList",FormUtil.attend());
		
		String url = "redirect:/sign/profile";
		return new ModelAndView(url);
	}
	
}
