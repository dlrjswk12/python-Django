package com.dywlr.mem.model;

public class ImgItem {
	
	private int img_id;
	private String email;
	private String filename;
	private String realpath;

	public void setImg_id(int img_id) {
		this.img_id=img_id;
	}
	public int getImg_id() {
		return img_id;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}

	public void setFilename(String filename) {
		this.filename=filename;
	}
	public String getFilename() {
		return filename;
	}

	public void setRealpath(String realpath) {
		this.realpath=realpath;
	}
	public String getRealpath() {
		return realpath;
	}

}

