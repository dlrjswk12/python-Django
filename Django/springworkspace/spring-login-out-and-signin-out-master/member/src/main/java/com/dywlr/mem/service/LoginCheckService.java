package com.dywlr.mem.service;

import org.springframework.transaction.annotation.Transactional;

import com.dywlr.mem.dao.MemberDao;
import com.dywlr.mem.model.Login;

public class LoginCheckService {
	
	private MemberDao memberMybatisDao;
	
	public void setMemberMybatisDao(MemberDao memberMybatisDao) {
		this.memberMybatisDao = memberMybatisDao;
	}
	@Transactional
	public boolean emailPwCheck(Login log) {
	if(memberMybatisDao.checkEmail(log)) {
		return memberMybatisDao.checkPassword(log);
	}else {
		return false;
	}
	}
	
}
