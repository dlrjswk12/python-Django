package ch04_mock1_direct_create;

public class RealTest {

	public static void main(String[] args) {
		new RealTest().realTest();
	}
	
	public void realTest() {
		// 실제 활용할 때에는
		AccountManager realManager = new RealAccountManager();
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);
		realManager.addAccount("1", senderAccount);
		realManager.addAccount("2", beneficiaryAccount);
		AccountService accountService = new AccountService();
		accountService.setAccountManager(realManager);
		// 테스트 수행
		accountService.transfer("1", "2", 50);
	}
}
