package com.sjw.mybatisboard.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class MDto {
	private long no;
	private String id;
	private Timestamp joindate;
	private String password; 
	private String phone; 
	private String iswithrew;
	
	
	public MDto() {	}
	
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
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
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
	public String getIswithrew() {
		return iswithrew;
	}
	public void setIswithrew(String iswithrew) {
		this.iswithrew = iswithrew;
	}
	public MDto(long no, String id, Timestamp joindate, String password, String phone, String iswithrew) {
		super();
		this.no = no;
		this.id = id;
		this.joindate = joindate;
		this.password = password;
		this.phone = phone;
		this.iswithrew = iswithrew;
	}
	
	
}
