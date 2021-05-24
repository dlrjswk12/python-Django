package ch04_mock2_easymock;

import junit.framework.TestCase;
//import static org.easymock.EasyMock.aryEq;
//import static org.easymock.EasyMock.expectLastCall;
//import static org.easymock.EasyMock.createMock;
//import static org.easymock.EasyMock.expect;
//import static org.easymock.EasyMock.replay;
//import static org.easymock.EasyMock.verify;
import org.easymock.EasyMock;

public class CaculatorTest extends TestCase {
	Calculator mockCalc;
	RunCaculator runner;
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("SetUp");
		mockCalc = EasyMock.createMock(Calculator.class); // create Mock Object
		runner = new RunCaculator();
		runner.setCal(mockCalc);
		super.setUp();
	}
	
	/*
	 * 아래의 예는 일부러 에러를 발생 시킨 경우인데 echo(“Hello”) 메서드가 한번만 호출되기로 되어 있었는데, 
	 * 아래 테스트 케이스를 보면 echo(“Hello”)가 연속으로 두번 호출 된후 echo(“Hello bcho”)가 
	 * 한번 호출되기 때문에 에러가 발생된다.
	 */
	public void testSayHello() {
		mockCalc.echo("Hello");
		EasyMock.replay(mockCalc);
		runner.sayHello("Hello");
//		runner.sayHello("Hello");
//		runner.sayHello("Hello bcho");
		EasyMock.verify(mockCalc);
	}
	
	/*
	 * sum(1,2)가 아닌 다른 인자로 호출이 되면 미리 레코딩 된 행동이 아니기 때문에 에러가 날것이고 
	 * 마찬가지로 sum(1,2)가 호출되더라도 1회 초과로 호출되면 이 역시 예상된 행동이 아니기 때문에 에러가 발생된다.
	 */
	public void testDoSum() {
		EasyMock.expect(mockCalc.sum(1, 2)).andReturn(3); // record mock action
		EasyMock.replay(mockCalc); // replay mock
		//this.assertEquals(3, runner.doSum(1, 2));
		//EasyMock.verify(mock);
	}
	
}