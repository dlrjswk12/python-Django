package com.a.b.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.a.b.dao.BDao;
import com.a.b.dto.Ebook;


public class AdminWrite implements IBoarderService {
	private SqlSession sqlSession=Constant.sqlSession;
	@Override
	public void execute(Model model) {
		
		
		
		
		
		
		
		Map<String, Object> map = model.asMap();
		
		 MultipartHttpServletRequest multi = (MultipartHttpServletRequest) map.get("multi");	
		 
		 
		 
//			MultipartFile mf = multi.getFile("uploadfile");
//			
//			String path = "C:/upload/temp/";
//			
//		String originFileName = mf.getOriginalFilename(); // 원본 파일명
//		
//		long filesize = mf.getSize();
//		
//			System.out.println("originFileName:" +originFileName);	
//			System.out.println("fileSize :" + filesize );
//			
//			String safeFile = path + System.currentTimeMillis() + originFileName;
//			
//			try {
//				mf.transferTo(new File(safeFile));
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//			e.printStackTrace();
//		};
		 
		 
		 
		 
		String bBookname = multi.getParameter("bBookname");

		String bUrl = multi.getParameter("uploadfile");
		
		String bContent = multi.getParameter("bContent");
		
		long bPrice =Long.parseLong(multi.getParameter("bPrice"));
		
		String bWriter =multi.getParameter("bWriter");
		
		String bPublisher = multi.getParameter("bPublisher");
		
		String bCategory = multi.getParameter("bCategory");
		
	

		
		
		
		
		
		
		
		BDao dao = sqlSession.getMapper(BDao.class);
		
		
		System.out.println(bUrl);
		
		System.out.println(bContent);
		
		
		dao.write(bBookname, bUrl ,bContent, bPrice, bWriter, bPublisher, bCategory);
		
	}

}
