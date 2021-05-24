package ch04_mock1_direct_create;
/**
 * 
 *
 * @author pc353
 *
 */


public class Account {
	/**
	 * 계좌 아이디
	 */
	private String accountId;

	/**
	 * 계좌 잔고
	 */
	private long balance;

	/**
	 * 초기화
	 * 
	 * @param accountId
	 * @param initialBalance
	 */
	public Account(String accountId, long initialBalance) {
		this.accountId = accountId;
		this.balance = initialBalance;
	}

	/**
	 * 출금
	 * 
	 * @param amount
	 */
	public void debit(long amount) {
		this.balance -= amount;
	}

	/**
	 * 입금
	 * 
	 * @param amount 입금액
	 */
	public void credit(long amount) {
		this.balance += amount;
	}

	/**
	 * 현재 잔고 를 조회할 수 있다.
	 * 
	 * @return - 현재 잔고
	 */
	public long getBalance() {
		return this.balance;
	}
}