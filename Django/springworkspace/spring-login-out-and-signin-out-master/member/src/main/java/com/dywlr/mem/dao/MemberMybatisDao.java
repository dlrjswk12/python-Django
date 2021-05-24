package com.dywlr.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dywlr.mem.model.ImgItem;
import com.dywlr.mem.model.Login;
import com.dywlr.mem.model.MemberInfo;
import com.dywlr.mem.model.MemberProfile;
import com.dywlr.mem.model.MemberProfileDb;

@Repository
public class MemberMybatisDao implements MemberDao{
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public int insert(MemberInfo mem) {
		return sqlSession.insert("com.dywlr.mem.dao.MemberDao.insert", mem);
	}
	@Override
	public int insertProfile(MemberProfile mem) {
		return sqlSession.insert("com.dywlr.mem.dao.MemberDao.insertProfile", mem);

	}
	@Override
	public int insertImg(ImgItem imgitem) {
		int insertedCount = sqlSession.insert("com.dywlr.mem.dao.MemberDao.insertImg", imgitem);
		return insertedCount;
	}
	
	@Override
	public int imgId() {
		List<Integer> list = sqlSession.selectList("com.dywlr.mem.dao.MemberDao.imgId");
		return list.get(0);
	}
	
	@Override
	public String selectImgData(String email) {
		String realPath;
		try {
		realPath = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.selectImgData",email);
		return realPath;
		}catch(Exception ex) {
			realPath = null;
			return realPath;
		}	
	}
	@Override
	public boolean checkEmail(Login log) {
		try {
		String emailDb = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.checkEmail", log.getEmail());
		if(emailDb.equals("") || emailDb==null)
			return false;
		else
			return true;
		}catch(NullPointerException ex){
			return false;
		}
		
	}
	@Override
	public boolean checkPassword(Login log) {
		String passwordDb = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.checkPassword", log.getEmail());
		if(passwordDb.equals(log.getPassword()))
			return true;
		else
			return false;
	}
	
	@Override 
	public boolean checkProfile(String email) {
		try {
		String profileEmail = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.checkProfile", email);
		if(profileEmail==null)
			return false;
		else
			return true;
		}catch(NullPointerException ex){
			return false;
		}
	}
	
	@Override
	public int updateProfile(MemberProfile mem) {
		return sqlSession.update("com.dywlr.mem.dao.MemberDao.updateProfile", mem);
	}
	
	@Override
	public boolean imgCheck(String email) {
		try {
		String imgEmail = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.imgCheck", email);
		if(imgEmail==null)
			return false;
		else
			return true;
		}catch(NullPointerException ex){
			return false;
		}
	}
	
	@Override
	public void imgUpdate(ImgItem item) {
		 sqlSession.update("com.dywlr.mem.dao.MemberDao.imgUpdate", item);
	}
	@Override
	public MemberProfileDb selectProfile(String email) {
		try {
		MemberProfileDb mem = sqlSession.selectOne("com.dywlr.mem.dao.MemberDao.selectProfile", email);
		return mem;
		}catch(NullPointerException ex) {
			MemberProfileDb mem2 = null;
		return mem2;
		}
	}
}
