package com.dywlr.mem.dao;

import org.springframework.stereotype.Repository;

import com.dywlr.mem.model.ImgItem;
import com.dywlr.mem.model.Login;
import com.dywlr.mem.model.MemberInfo;
import com.dywlr.mem.model.MemberProfile;
import com.dywlr.mem.model.MemberProfileDb;
@Repository
public interface MemberDao {
	int insert(MemberInfo mem);
	
	int insertProfile(MemberProfile mem);
	
	int insertImg(ImgItem imgitem);
	
	public int imgId();
	
	public String selectImgData(String email);
	
	public boolean checkEmail(Login log);
	
	public boolean checkPassword(Login log);
	
	public boolean checkProfile(String email);
	
	public int updateProfile(MemberProfile mem);
	
	public boolean imgCheck(String email); 
	
	public void imgUpdate(ImgItem item);
	
	public MemberProfileDb selectProfile(String email);
}
