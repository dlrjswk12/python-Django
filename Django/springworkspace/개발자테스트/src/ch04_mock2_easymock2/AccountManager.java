package ch04_mock2_easymock2;

public interface AccountManager {
	Account findAccountForUser(String userId);
	void updateAccount(Account account);
	void addAccount(String userId, Account account);
}