package ch04_mock2_easymock2;

import ch04_mock2_easymock.Calculator;

public class RunAccountManager {
	AccountManager manager ;
	public void setManager(AccountManager manager) {
		this.manager = manager;
	}
	public Account doFind(String userId){
		return manager.findAccountForUser(userId);
	}
	public void doUpdate(Account account){
		manager.updateAccount(account);
	}
	public void doAdd(String userId,Account account){
		manager.addAccount(userId, account);
	}
}
