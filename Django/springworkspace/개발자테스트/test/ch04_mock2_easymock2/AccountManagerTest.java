package ch04_mock2_easymock2;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import org.junit.Test;
import junit.framework.TestCase;

public class AccountManagerTest extends TestCase {
	AccountManager mock;
	RunAccountManager runner;
	Account x = new Account("sjw",1_500_000);

	//-------- TestCase를 상속받아 요런거 생략가능 @Override@Before
	//Sets up the fixture, for example, open a network connection. 
	//This method is called before a test is executed.
	protected void setUp() throws Exception {
		System.out.println("불리어졌나요?");
		mock = createMock(AccountManager.class); // create Mock Object
		runner = new RunAccountManager();
		runner.setManager(mock);
		super.setUp();
		mock.addAccount("sjw", x);
	}
	
	@Test
	public void  testFindAccountForUser() {
		Account y = mock.findAccountForUser("sjw");
		expect(y).andReturn(x); // record mock action
	}
	@Test
	public void testUpdateAccount(){
		Account account = new Account("sjw",3_500_000);
		mock.updateAccount(account);
		expect(mock.findAccountForUser("sjw")).andReturn(account); // record mock action
	}
	
	@Test
	public void testAddAccount(){
		mock.addAccount("hgd",new Account("hgd", 430_000));
		replay(mock); // replay mock
		//	verify(mock);
	}
	
	//-------- TestCase를 상속받아 요런거 생략가능 @Override@After
	//Tears down the fixture, for example, close a network connection. 
	//This method is called after a test is executed.
	protected void tearDown(){
		// 객체반납, Connection객체 close() 등 작업을 한다. 
		System.out.println("아싸~");
	}

}
