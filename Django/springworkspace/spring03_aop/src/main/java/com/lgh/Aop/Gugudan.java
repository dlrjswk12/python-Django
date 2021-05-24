package com.lgh.Aop;
// 주 관심사
public class Gugudan implements IProc {

	@Override
	public String execute(int... args) {
		int num = args.length;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i< num; i++) {
			for (int  j= 1 ; j<=9; j++  ) {
				buffer.append(args[i] + "*"+ j+"="+ (args[i]*j)+"\n");
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}

}
