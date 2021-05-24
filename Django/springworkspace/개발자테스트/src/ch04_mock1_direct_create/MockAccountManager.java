package ch04_mock1_direct_create;

import java.util.Map;
import java.util.HashMap;


/**
 * 가짜 통장 관리자를 AccountManager를 구현하여 만든다.
 * @author pc353
 *
 */

public class MockAccountManager implements AccountManager {
	// 통장을 모아놓은 금고
	private Map<String, Account> accounts = new HashMap<String, Account>(); // 해쉬멥을 금고를 만들어둠

	/**
	 * 아이디와 account 객체를 HashMap객체에 put
	 * 개설된 통장을 금고에 넣는 작업
	 * @param userId
	 * @param account
	 */
	public void addAccount(String userId, Account account) {
		this.accounts.put(userId, account);
	}

	/**
	 * 아이디로 HashMap객체에서 account 객체를 찾아 리턴
	 */
	public Account findAccountForUser(String userId) {
		return this.accounts.get(userId);
	}

	/**
	 * 계정 정보를 갱신하며 반환값은 없다.
	 */
	public void updateAccount(Account account) {
		// do nothing
	}
}