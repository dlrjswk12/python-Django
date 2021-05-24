package com.pjt.teampjt.dto;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;


@Component
public class MyMember {
	private long no; //회원등록번호:자동넘버링
	private String id; //회원아이디 혹 별명
	private String name;
	private Date birthday; // 가입일자
	private String password; // 패스워드
	private String phone; // 전화번호
	private String adress;
	private String iswithrew; // 가입상태 - JOINED, UNJOINED
	private long cash;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIswithrew() {
		return iswithrew;
	}
	public void setIswithrew(String iswithrew) {
		this.iswithrew = iswithrew;
	}
	public long getCash() {
		return cash;
	}
	public void setCash(long cash) {
		this.cash = cash;
	}
	@Override
	public String toString() {
		return "MyMember [no=" + no + ", id=" + id + ", name=" + name + ", birthday=" + birthday + ", password="
				+ password + ", phone=" + phone + ", adress=" + adress + ", iswithrew=" + iswithrew + ", cash=" + cash
				+ "]";
	}
	

}
