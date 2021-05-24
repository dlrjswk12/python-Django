package ch04_mock2_easymock2;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountManagerTest2 {//extends TestCase {
	AccountManager mock;
	RunAccountManager runner;
	Account x = new Account("sjw",1_500_000);

	@Before
	public void setUp() throws Exception {
		mock = createMock(AccountManager.class); // create Mock Object
		runner = new RunAccountManager();
		runner.setManager(mock);
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
		replay(mock); 
	}
	@After
	public void tearDown(){
		System.out.println("아싸~");
	}
}
