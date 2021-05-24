package ch04_mock1_direct_create;
/**
 * 계정 서비스 - 계정관리자 지정, 송금기능을 가지는 서비스 구현
 * @author pc353
 *
 */
public class AccountService {
	/**
	 * AccountManger 인터페이스 선언
	 */
	private AccountManager accountManager;

	/**
	 * 객체 초기화
	 * 
	 * @param manager
	 */
	public void setAccountManager(AccountManager manager) {
		this.accountManager = manager;
	}

	/**
	 * 두 계좌 사이 송금기능
	 * 
	 * @param senderId
	 * @param beneficiaryId
	 * @param amount
	 */
	public void transfer(String senderId, String beneficiaryId, long amount) {
		Account sender = this.accountManager.findAccountForUser(senderId);
		Account beneficiary = this.accountManager.findAccountForUser(beneficiaryId);
		//송금기능
		sender.debit(amount); // 송금자의 통장에서 인출
		beneficiary.credit(amount); // 수신자의 통장에 입금
		this.accountManager.updateAccount(sender);
		this.accountManager.updateAccount(beneficiary);
	}
}