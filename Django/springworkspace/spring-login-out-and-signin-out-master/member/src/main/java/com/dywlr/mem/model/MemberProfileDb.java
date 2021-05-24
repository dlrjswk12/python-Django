package com.dywlr.mem.model;

public class MemberProfileDb {
	private String email;
	private String[] category;
	private String[] locale;
	private String universe;
	private String attending;
	private String title;
	private String career;
	private String teacher;
	private String clas;
	
	private String categories;
	private String locales;
	
	public void setCategories(String categories) {
		this.categories=categories;
	}
	
	public String getCategories() {
		return categories;
	}
	
	public void setLocales(String locales) {
		this.locales=locales;
	}
	public String getLocales() {
		return locales;
	}
	
	
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setCategory(String[] category) {
		this.category=category;
	}
	public String[] getCategory() {
		return category;
	}
	
	public void setLocale(String[] locale) {
		this.locale=locale;
	}
	public String[] getLocale() {
		return locale;
	}
	
	public void setUniverse(String universe) {
		this.universe=universe;
	}
	public String getUniverse() {
		return universe;
	}
	
	public void setAttending(String attending) {
		this.attending=attending;
	}
	public String getAttending() {
		return attending;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return title;
	}
	
	public void setCareer(String career) {
		this.career=career;
	}
	public String getCareer() {
		return career;
	}
	
	public void setTeacher(String teacher) {
		this.teacher=teacher;
	}
	public String getTeacher() {
		return teacher;
	}
	
	public void setClas(String clas) {
		this.clas=clas;
	}
	public String getClas() {
		return clas;
	}
}
