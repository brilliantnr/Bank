package serviceImpl;

import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;
import service.MemberService;
	
public class MemberServiceImpl implements MemberService {
	MemberBean[] list;
	int count;
	
	public MemberServiceImpl() {
		list = new MemberBean[10];
		count=0;
	}
	
	@Override
	public void createUser(UserBean member) {
		member.setCreditRating("7등급");
		addList(member);
	}
	@Override
	public void createStaff(StaffBean member) {
		member.setAccessNum("1234");
	}
	
	private void addList(MemberBean member) {
		list[count++]=member;
		
	}
	@Override
	public MemberBean[] list() {
		return list;
	}
	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean m = new MemberBean();
		for(int i=0;i<count;i++) {
			if(member.getUid().equals(list[i].getUid())
					&&
					member.getPw().equals(list[i].getPw())) {
				m=list[i];
				break;
			}
		}
		return m;
	}
	@Override
	public MemberBean[] findByName(MemberBean member) {
		int temp=0;
		for(int i=0;i<count;i++) {
			if(member.getName().equals(list[i].getName())) {
				temp++;
			}
		}
		MemberBean[] arr = new MemberBean[temp];
		for(int i=0;i<temp;i++) {
			if(member.getName().equals(list[i].getName())) {
				arr[i]=list[i];
			}
		}
			return arr;
	}
	@Override
	public int readCount() {
		return count;
	}
	@Override
	public void updateMember(MemberBean member) {
		String oldPw = member.getPw().split("/")[0];
		String newPw = member.getPw().split("/")[1];
		member.setPw(oldPw);
		member = findById(member);
		if(member.getPw().equals(member.getPw())) {
			member.setPw(newPw);
		}
	}
	@Override
	public String deleteMember(MemberBean member) {
		String message ="";
		String pw = member.getPw().split("/")[0];
		String confirmPw = member.getPw().split("/")[1];
		for(int i=0;i<count;i++) {
			if(member.getUid().equals(list[i].getUid())
					&&
					pw.equals(list[i].getPw())) {
				
				if(pw.equals(confirmPw)) {
					list[i]=null;
					message="삭제완료";
					break;
				}
			}
		}
		return message;
	}
}
