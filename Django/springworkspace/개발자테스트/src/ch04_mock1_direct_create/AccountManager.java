package ch04_mock1_direct_create;
// 설제 매니져와 가짜 매니져를 만들어야 하기 때문에 인터페이스로 규격을 선언

public interface AccountManager {
	/**
	 * 아이디로 계좌 계정찾기
	 * @param userId
	 * @return 통장장보
	 * 
	 */
	public Account findAccountForUser(String userId);

	/**
	 * 계좌 (계정) 업데이트
	 * 
	 * @param account
	 */
	void updateAccount(Account account);
	/**
	 * 통장개설
	 * @param userId
	 * @param account
	 */
	void addAccount(String userId, Account account);
}