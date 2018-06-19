package domain;

public class MemberBean {
	protected String uid, pw, name, ssn, phone, addr,email;
		
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
				+ "]";
	}

	
	
	
	
}
