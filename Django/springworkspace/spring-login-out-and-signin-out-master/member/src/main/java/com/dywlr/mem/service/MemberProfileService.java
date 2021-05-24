package com.dywlr.mem.service;

import com.dywlr.mem.dao.MemberDao;
import com.dywlr.mem.model.MemberProfile;
import com.dywlr.mem.model.MemberProfileDb;

public class MemberProfileService {
	
	private MemberDao memberMybatisDao;
	
	public void setMemberMybatisDao(MemberDao memberMybatisDao) {
		this.memberMybatisDao = memberMybatisDao;
	}
	
	public boolean checkProfile(String email) {
		return memberMybatisDao.checkProfile(email);
	}
	
	public void insertService(MemberProfile mem) {
		memberMybatisDao.insertProfile(mem);
	}
	
	public String realPath(String email) {
		String realPath = memberMybatisDao.selectImgData(email);
		return realPath;
	}
	
	public int updateProfile(MemberProfile mem) {
		return memberMybatisDao.updateProfile(mem);
	}
	
	public MemberProfileDb selectProfile(String email) {
		MemberProfileDb mem = memberMybatisDao.selectProfile(email);
		if(mem==null) {
		return mem;	
		}else {
			System.out.println(mem.getCategories()+"aaaa");
			System.out.println(mem.getClas());
			System.out.println(mem.getCareer());
			System.out.println(mem.getTeacher());
			
		String a = mem.getCategories().trim();
		String[] b=a.split(",");
		mem.setCategory(b);
		
		String c = mem.getLocales().trim();
		String[] d = c.split(",");
		mem.setLocale(d);
		for(String i: b) {
			System.out.println(i);
		}
		for(String i: d) {
			System.out.println(i);
		}
		return mem;
		}
	}
	
}
