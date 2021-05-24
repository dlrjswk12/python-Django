package ch04_mock1_direct_create;

import java.util.Map;
import java.util.HashMap;

public class RealAccountManager implements AccountManager {

	public void addAccount(String userId, Account account) {
		// 실제에 맞게 코딩 
	}
	public Account findAccountForUser(String userId) {
		return null; 
	}
	public void updateAccount(Account account) {
		
	}
}