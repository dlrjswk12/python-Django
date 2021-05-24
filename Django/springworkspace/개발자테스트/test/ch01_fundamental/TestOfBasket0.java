package ch01_fundamental;

import ch01_fundamental.Basket;
import ch01_fundamental.EntryVO;

// 옛날 테스트방식 
public class TestOfBasket0 {
	public static void main(String[] args) {
		final Basket catalog = new Basket();
		EntryVO entry = new EntryVO("물고기","비늘을가지고있다.");
		try {
			catalog.add(entry);
			catalog.add(entry);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(catalog.contains(entry));
	}
}
