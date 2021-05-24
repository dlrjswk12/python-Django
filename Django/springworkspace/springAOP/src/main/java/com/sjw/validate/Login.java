package com.sjw.validate;

public class Login implements Confirm {

	@Override
	public void confirm(String id, String pwd) {
		if(id.equals("admin") && pwd.equals("1234")) {
			disp();
		}else {
			dispNg();
		}
	}
	public void disp() {
		System.out.println("당신은 로그인 되었습니다.");
	}
	public void dispNg() {
		System.out.println("당신은 로그인 될 수 없습니다.");
	}
	
}