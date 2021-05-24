package com.pjt.teampjt.dao;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.pjt.teampjt.dto.MyMember;
public interface MDao {
	public MyMember memberView(String id);//회원 상세 정보보기 
	public void memberJoin( // 회원가입하기
			final String id,
			final String name,
			final Date birthday, 
			final String password,
			final String phone,
			final String adress
	);
	public ArrayList<MyMember> memberList(); // 회원명단 출력 
	public void memberModify( // 회원정보 수정 
			final String id,
			final String name,
			//final Timestamp joindate, 
			final String password,
			final String phone,
			final String adress,
			final String iswithrew
	);
	public void memberRemove(final String id); // 회원 삭제 
	public void memberExit(final String id); // 회원 탈퇴 
	public String idcheck(final String id);
	public void cashupdown(
			final String id,
			final long cash);
	
	public void idsearch(
			final String name,
			final String phone);
	
	public void passwordsearch(
			final String id,
			final String name);
	
	
}

