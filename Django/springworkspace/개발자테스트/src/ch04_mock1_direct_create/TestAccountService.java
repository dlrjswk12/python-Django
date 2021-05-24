package ch04_mock1_direct_create;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
// junit Test 를 사용햇음   초록색 막대기 

/**
 * 목 테스트 소스 코드 입니다.
 * @author pc353
 *
 */


public class TestAccountService {
	/**
	 * 송금을 테스트 합니다.
	 * API주석
	 * 
	 */
	@Test
	public void testTransferOk() {
		// 테스트를 하기위한 객체 생성 및 준비
		AccountManager mockAccountManager = new MockAccountManager();
		// 통장개설
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);
		// 통장등록 (금고에 보관)
		mockAccountManager.addAccount("1", senderAccount);
		mockAccountManager.addAccount("2", beneficiaryAccount);
		// 계정 서비스 객체에 계정관리자를 지정 (가짜계정관리자를 지정)
		AccountService accountService = new AccountService();
		accountService.setAccountManager(mockAccountManager);
		// 테스트 수행
		accountService.transfer("1", "2", 50);
		// 결과 검증
		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());
	}
}