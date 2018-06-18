package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE="마이너스통장";
	public String debt, limit; // 대출금
	
	
	public void setLimit(String limit) {
		this.limit=limit;
	}
	public String getLimit() {
		return limit;
	}
	
	public String toString() {
		return String.format("%s \n %s \n 계좌번호 : %s \n 이름 : %s \n 생성일 : %s \n 대출한도 : %d \n 잔액 : %d", BANK_NAME, ACCOUNT_TYPE,
				getAccountNo(), getName(), getCreateDate(),getLimit(), getMoney());
	}
	
	
	
}
