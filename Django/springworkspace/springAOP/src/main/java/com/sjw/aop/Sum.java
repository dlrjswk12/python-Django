package com.sjw.aop;
// 주관심사 
public class Sum implements IProc {

	@Override
	public Long execute(int... args) {
		long sum = 0;
		for (long i = args[0]; i <= args[1]; i++) {
			sum += i;
		}
		return sum;//auto boxing 
	}

}
