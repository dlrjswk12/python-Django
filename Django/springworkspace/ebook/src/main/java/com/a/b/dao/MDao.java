package com.a.b.dao;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.a.b.dto.Member;
public interface MDao {
	public Member memberView(String bid);//회원 상세 정보보기 
	public void memberJoin( // 회원가입하기
			final String bId,
			final String bPw,
			final String bName,
			final String bGender,
			final Date bBirthday,
			final Timestamp bJoindate
	);
	public ArrayList<Member> memberList(); // 회원명단 출력 
	public void memberModify( // 회원정보 수정 
			final String bId,
			final String bPw,
			//final Timestamp joindate, 
			final String bName
	);
	public void memberRemove(final String bid); // 회원 삭제 
	public void memberExit(final String bid); // 회원 탈퇴 
	public int idcheck(final String bid);
	public void cashupdown(
			final String bid,
			final long bcash);
	
	public void idsearch(
			final String bname);
	
	public void passwordsearch(
			final String bid,
			final String bname);
	
	
}

