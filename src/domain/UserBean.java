package domain;

public class UserBean extends MemberBean {
	private String creditRating;

	
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	
	@Override
	public String toString() {
		return "******직원정보****** \n"
				+ " [아이디:" + uid+ ", \n "
				+ "비번: " + pw+ ", \n"
				+ "이름:  " + name 
				+ ", \n 주민번호: " + ssn 
				+ ", \n 전화번호: " + phone
				+ ", \n 이메일: " + email
				+ ", \n 주소: " + addr
				+ ", \n 신용등급: " + creditRating
				+ "]";
	}
	
	
	
	
	
}
