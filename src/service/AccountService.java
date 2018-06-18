package service;

import domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean ac);   // 
	public void addList(AccountBean ac);
	public AccountBean[] list();  //고객리스트
	public int deposit(int restmoney,String money);  //
	public int withdraw(int restmoney,String money);
	public String createAccountNo(String random);
	public String createRandom(int start,int end);
	public String createDate();
	public AccountBean findById(AccountBean ac);
	public AccountBean[] findByName(String showInputDialog);
	public int countSameWord(String word);
	
}
