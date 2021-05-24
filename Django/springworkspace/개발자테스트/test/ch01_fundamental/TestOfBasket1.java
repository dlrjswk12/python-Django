package ch01_fundamental;

import static org.junit.Assert.*;

import org.junit.Test;
//JUnit을 통한 테스트 
// (1) 테스트클래스는 public 이다.
// (2) 기본생성자가 있어야 한다. (여기서는 생성자가 코딩되어 있지 않아 기본생성자가 묵시적으로 생성되었다)
// (3) 테스트 메소드 앞에 @Test 에너테이션을 붙여야 한다.
// (4) 테스트 메소드는 반환값이 없는 void형이다.
// (5) 테스트 메소드는 매개변수를 받지 않아야 한다.

import ch01_fundamental.Basket;
import ch01_fundamental.EntryVO;

public class TestOfBasket1 {
	private final Basket catalog = new Basket();

	@Test
	public void 어떤추가된엔트리객체를포함하고있는가() {

		EntryVO entry = new EntryVO("물고기", "비늘을가지고있다.");
		try {
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
		// System.out.println(catalog.add2(entry));
		assertTrue(catalog.contains(entry));
	}

	@Test
	public void 없는자료를인식하는가() {
		EntryVO entry = new EntryVO("물고기", "비늘을가지고있다.");
		try {
			catalog.add(entry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(entry, catalog.entryFor("물고기"));

		assertNull(catalog.entryFor("잠자리"));
	}

	@Test//(expected = Exception.class)
	public void 동일한이름으로등록할수있는가() {
		try {
			EntryVO x = new EntryVO("물고기", "비늘을가지고있다.");
			catalog.add(x);
			EntryVO y = new EntryVO("물고기", "다리가있다.");
			catalog.add(y);
			//values.contains("one") || values.contains("two")
			assertFalse(
					(catalog.map.values().contains("비늘을가지고있다.") && catalog.map.values().contains("다리가있다." ))
			);
			//assertThat(catalog.map.values(),hasItem(anyOf(equalTo("비늘을가지고있다."),equalTo("다리가있다."))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
