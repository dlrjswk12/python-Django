package ch04_mock2_easymock2;

public class Account {
	private String accountId;
	private long balance;
	// 초기계좌 개설
	public Account(String accountId, long initialBalance) {
		this.accountId = accountId;
		this.balance = initialBalance;
	}
	// 인출
	public void debit(long amount) {
		this.balance -= amount;
	}
	// 저축
	public void credit(long amount) {
		this.balance += amount;
	}
	// 잔액
	public long getBalance() {
		return this.balance;
	}
}