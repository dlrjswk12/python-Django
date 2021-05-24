package com.dywlr.mem.service;

import org.springframework.transaction.annotation.Transactional;

import com.dywlr.mem.dao.MemberDao;
import com.dywlr.mem.model.ImgItem;
import com.dywlr.mem.model.MemberInfo;

public class MemberService {
	
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public boolean imgCheck(String email) {
		return dao.imgCheck(email);
	}
	
	public void imgUpdate(ImgItem img) {
		dao.imgUpdate(img);
	}
	
	public void insertService(MemberInfo mem) {
		dao.insert(mem);
	}
	//트랜잭션 처리하기
	@Transactional
	public ImgItem add(ImgItem img) {
		int id = dao.insertImg(img);
		if(id>0) {
			int id1 = dao.imgId();
			img.setImg_id(id1);
		}	
		else {
			img.setImg_id(-1);
		}
		
		return img;
		
	}
}
