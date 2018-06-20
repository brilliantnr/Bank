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
			
				break;

			case ADD_STAFF_ONLY:
				break;
			case LIST:
				
				break;
			case COUNT:
			
				break;
			case FIND_BY_ID:
				
				break;
			case FIND_BY_NAME:
	
				break;
			case UPDATE:
			
				break;
			case WITHDRAWAL:
				
				break;
			default:
				break;
			}
		}
	}
}
