package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt {
	// JOIN은 일반유저 추가, ADD는 직원 추가
	EXIT, 
	JOIN, ADD_STAFF_ONLY, 
	LIST, FIND_BY_ID, FIND_BY_NAME, COUNT,
	UPDATE, 
	WITHDRAWAL,
};

public class MemberController {
	public static void main(String[] args) {
		MemberButt[] buttons = { MemberButt.EXIT, 
				MemberButt.JOIN, MemberButt.ADD_STAFF_ONLY, 
				MemberButt.LIST,MemberButt.COUNT, MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME, 
				MemberButt.UPDATE,
				MemberButt.WITHDRAWAL };

		MemberBean member = null;
		MemberService service = new MemberServiceImpl();

		while (true) {
			MemberButt select = (MemberButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, buttons, null);
			switch (select) {
			case EXIT:
				return;
			case JOIN:
				// uid, pw, name, ssn, phone, addr,email;
				member = new UserBean();
				member.setName(JOptionPane.showInputDialog("이름 입력"));
				member.setUid(JOptionPane.showInputDialog("ID 입력"));
				member.setPw(JOptionPane.showInputDialog("비밀번호 입력"));
				member.setName(JOptionPane.showInputDialog("주민번호 입력"));
				member.setName(JOptionPane.showInputDialog("전화번호 입력"));
				member.setName(JOptionPane.showInputDialog("주소 입력"));
				member.setName(JOptionPane.showInputDialog("이메일 입력"));
				service.createUser((UserBean) member);
				break;

			case ADD_STAFF_ONLY:
				member = new StaffBean();
				member.setName(JOptionPane.showInputDialog("이름 입력"));
				member.setUid(JOptionPane.showInputDialog("ID 입력"));
				member.setPw(JOptionPane.showInputDialog("비밀번호 입력"));
				member.setName(JOptionPane.showInputDialog("주민번호 입력"));
				member.setName(JOptionPane.showInputDialog("전화번호 입력"));
				member.setName(JOptionPane.showInputDialog("주소 입력"));
				member.setName(JOptionPane.showInputDialog("이메일 입력"));
				service.createStaff((StaffBean) member);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.readCount());
				break;
			case FIND_BY_ID:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID 입력"));
				member.setPw(JOptionPane.showInputDialog("비밀번호 입력"));
				JOptionPane.showMessageDialog(null, service.findById(member));
				break;
			case FIND_BY_NAME:
				member.setName(JOptionPane.showInputDialog("이름 입력"));
				JOptionPane.showMessageDialog(null, service.findByName(member));
				break;
			case UPDATE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID 입력"));
				member.setPw(JOptionPane.showInputDialog("비밀번호 입력") 
						+ "/" + 
						JOptionPane.showInputDialog("새로운 비밀번호 입력"));
				service.updateMember(member);

			case WITHDRAWAL:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("ID 입력"));
				member.setPw(JOptionPane.showInputDialog("비밀번호 입력")
						+ "/" + 
						JOptionPane.showInputDialog("비밀번호 재확인"));
				JOptionPane.showMessageDialog(null, service.deleteMember(member));
				break;
			default:
				break;
			}
		}
	}
}
