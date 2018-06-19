package service;

import domain.*;

public interface MemberService {

	public void createUser(UserBean member);
	public void createStaff(StaffBean member);
	public MemberBean[] list();
	public MemberBean findById(MemberBean member);
	public MemberBean[] findByName(MemberBean member);
	public int readCount();
	public void updateMember(MemberBean member);
	public String deleteMember(MemberBean member);
	
	
}
