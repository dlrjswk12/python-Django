package com.dywlr.mem.model;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberInfo {
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String sexual;
	@NotEmpty
	private String birth;
	@NotEmpty
	private String teloff;
	@NotEmpty
	private String phone;
	
	public void setEmail(String email) {
		this.email= email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return name;
	}
	
	public void setSexual(String sexual) {
		this.sexual= sexual;
	}
	public String getSexual() {
		return sexual;
	}
	
	public void setBirth(String birth) {
		this.birth= birth;
	}
	public String getBirth() {
		return birth;
	}
	
	public void setTeloff(String teloff) {
		this.teloff= teloff;
	}
	public String getTeloff() {
		return teloff;
	}
	
	public void setPhone(String phone) {
		this.phone= phone;
	}
	public String getPhone() {
		return phone;
	}
	
}
