
package ch01_fundamental;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ch01_fundamental.Calculator;

public class TestOfCalculator {
	// 요걸 테스트 픽스처(test fixture)라 한다.
	//private final Calculator calculator;// = new Calculator();
	private Calculator calculator;
	
	@Before// 픽스쳐 만들기
	public void pixtureMake(){
		main();
		calculator = new Calculator();
	}
	
	@Test
	public void 두수를제대로더하는가(){
		//Calculator calculator = new Calculator();
		double result = calculator.add(10,50);
		// 와 상당히 많게 assertEquals() 메소드가 오버로딩 되어 있네요.
		// 그 중 하나입니다.
		assertEquals(60,result,0);
	
	}
	@Test
	public void 뺄셈을제대로하는가(){
		//Calculator calculator = new Calculator();
		double result = calculator.sub(10,50);
		assertEquals(-40,result,0);
	}
	
	@Test(expected = ArithmeticException.class )
	public void 정수를0으로나누었을때예외처리되는가(){
		//Calculator calculator = new Calculator();
		double result = calculator.div(10,0);
	}
	
	public  void main() {
		System.out.println("테스트 합니다.");
	}
	
	
	
}
