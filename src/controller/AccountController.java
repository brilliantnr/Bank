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
				
				break;
		
			case MINUSACCOUNT:
			
				break;
			case LIST:
			
				break;
			case MINUS_LIST:
				
				break;
			case FIND_BY_ID:
				
				break;
			case FIND_BY_NAME:
				
				break;
			case CHANGE_PW:	
			
			case DELETE_ACCOUNT:
				
			break;
			default:
				break;
			}
		}
	}
}
