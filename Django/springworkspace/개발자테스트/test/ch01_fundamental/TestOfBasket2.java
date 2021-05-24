package ch01_fundamental;

import static org.junit.Assert.*;

import org.junit.After; // 각각의 케이스를 종료할 때 수행 
import org.junit.AfterClass; // 이 클래스가 종료될때 한번만 수행
import org.junit.Before; // 각 케이스를 테스트하기전에 반드시 수행 
import org.junit.BeforeClass; // 이클래스에서 시작시 한번만 수행
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
//JUnit을 통한 테스트 
// (1) 테스트클래스는 public 이다.
// (2) 기본생성자가 있어야 한다. (여기서는 생성자가 코딩되어 있지 않아 기본생성자가 묵시적으로 생성되었다)
// (3) 테스트 메소드 앞에 @Test 에너테이션을 붙여야 한다.
// (4) 테스트 메소드는 반환값이 없는 void형이다.
// (5) 테스트 메소드는 매개변수를 받지 않아야 한다.

import ch01_fundamental.Basket;
import ch01_fundamental.EntryVO;

public class TestOfBasket2 {
	static Basket catalog;// = new Catalog();
	static EntryVO entry;// = new Entry("물고기", "비늘을가지고있다.");
	
	@BeforeClass
	public static void 곤이찌와(){
		System.out.println("곤이찌와");
		catalog = new Basket();
		entry = new EntryVO("물고기", "비늘을가지고있다.");
	}
	@Before public void fillTheCatalog(){
		try {
			catalog.add(entry);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	@Test
	public void 어떤추가된엔트리객체를포함하고있는가() {
		assertTrue(catalog.contains(entry));
	}

	@Test
	public void 없는자료를인식하는가() {
		assertEquals(entry, catalog.entryFor("물고기"));
		assertNull(catalog.entryFor("잠자리"));
	}
	
	@Test//(expected = Exception.class)
	public void 동일한이름으로등록할수있는가() {
		try {
			catalog.add(new EntryVO("물고기", "다리가있다."));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void 작업종료(){
		System.out.println("테스트를 마쳤습니다.");
	}
	@AfterClass
	public static void 사요나라(){
		System.out.println("사요나라~~");
	}
}
