package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
 
public class AccountController {
	enum AccountButt { 
		BASIC, MINUSACCOUNT, LIST, MINUS_LIST, FIND_BY_ID, FIND_BY_NAME,CHANGE_PW,DELETE_ACCOUNT, EXIT
	};
 
	public static void main(String[] args) {
		AccountButt[] buttons = { AccountButt.BASIC, AccountButt.MINUSACCOUNT, AccountButt.LIST, AccountButt.MINUS_LIST,
				AccountButt.FIND_BY_ID, AccountButt.FIND_BY_NAME, AccountButt.CHANGE_PW,
				AccountButt.DELETE_ACCOUNT,AccountButt.EXIT };

		AccountBean ac = null;
		AccountService service = new AccountServiceImpl();

		while (true) {
			AccountButt select = (AccountButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, buttons, null);

			switch (select) {
			case EXIT:
				return;
			case BASIC: 
				ac = new AccountBean();
				ac.setName(JOptionPane.showInputDialog("이름?"));
				ac.setUid(JOptionPane.showInputDialog("ID?"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호?"));
				service.createAccount(ac);
				break;
			/*
			 * ac=service.createAccount( JOptionPane.showInputDialog("이름?"),
			 * JOptionPane.showInputDialog("ID?"), JOptionPane.showInputDialog("비밀번호?"));
			 */
			case MINUSACCOUNT:
				ac = new MinusAccountBean();
				ac.setName(JOptionPane.showInputDialog("이름?"));
				ac.setUid(JOptionPane.showInputDialog("ID?"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호?"));
				((MinusAccountBean) ac).setLimit(JOptionPane.showInputDialog("대출한도?"));
				service.createAccount(ac);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case MINUS_LIST:
				//AccountBean[] arr = service.minusList();
				break;
			case FIND_BY_ID:
				// ID와 PW 받아서 일치하면 계좌내역을 보여줘.(단,비번은 ***로 처리해)
 
				ac = new AccountBean();
				ac.setUid(JOptionPane.showInputDialog("ID?"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호?"));
				JOptionPane.showMessageDialog(null, service.findById(ac));
				// 비번 있으니까 보안 필수
				break;
			case FIND_BY_NAME:
				// AccountBean[] arr = service.findByName(JOptionPane.showInputDialog("NAME"));
				// 이름하나 입력받지만 여러 명에 대한 배열
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("NAME")));
				break;
			case CHANGE_PW:	
				ac= new AccountBean();  //ID, PW, NEWPW
				
				ac.setUid(JOptionPane.showInputDialog("ID?"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호?")
						+"/"+
						JOptionPane.showInputDialog("새로운 비밀번호?")
						);
				String msg = service.changePw(ac);
				
				JOptionPane.showMessageDialog(null,msg);
				
			case DELETE_ACCOUNT:
				ac = new AccountBean();
				
				ac.setUid(JOptionPane.showInputDialog("ID?"));
				ac.setPw(JOptionPane.showInputDialog("비밀번호?")
						+"/"+
						JOptionPane.showInputDialog("비밀번호확인")
						);
				String ms = service.deleteAccount(ac);
				
				JOptionPane.showMessageDialog(null,ms);
				
				
				
			break;
			default:
				break;
			}
		}
	}
}
