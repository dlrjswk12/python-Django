package com.sjw.validate;

public class LookPay implements Confirm {

	@Override
	public void confirm(String id, String pwd) {
		if(id.equals("admin") && pwd.equals("1234")) {
			dispPayList();
		}else {
			dispNg();
		}
	}
	public void dispPayList() {
		System.out.println("갑돌이: 300만원");
		System.out.println("진숙이: 450만원");
		System.out.println("육갑이: 420만원");
	}
	public void dispNg() {
		System.out.println("당신은 직원들의 급료를 볼 수 없습니다.");

	}
}
