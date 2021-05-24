package ch01_fundamental;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("aaa", "bbbb");
		map.put("aaa", "cccc");
		System.out.println(100/0);
	}
}
