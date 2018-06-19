package domain;

public class StaffBean extends MemberBean {
//acess 권한 
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
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
				+ ", \n 번호: " + accessNum
				+ "]";
	}
	
	
	
	
}
