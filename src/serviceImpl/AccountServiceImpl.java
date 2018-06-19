package serviceImpl;

import domain.AccountBean;
import service.AccountService;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountServiceImpl implements AccountService {
	// 메인
	AccountBean[] list;
	int count;
 
	public AccountServiceImpl() {
		list = new AccountBean[10];
		count = 0; 	 //생성자의 역할이 초기화
	}
	@Override
	public void createAccount(AccountBean ac) {
		ac.setAccountNo(createAccountNo());
		ac.setCreateDate(createDate());
		addList(ac);
	}
	@Override
	public void addList(AccountBean ac) {
		list[count++] = ac;
	}
	@Override
	public AccountBean[] list() {
		
		System.out.println("배열의 카운드"+count);
		String res = "";
		for(int i=0;i<count;i++) {
			res +=list[i]+"\n";
		}
		System.out.println("배열내부 \n"+res);
		
		return list;
	}
	@Override
	public int deposit(int restmoney, String money) {
		//
		return 0;
	}
	@Override
	public int withdraw(int restmoney, String money) {
		//
		return 0;
	}
	@Override
	public String createAccountNo() {
		return String.format("%s-%s-%s",
				createRandom(0,999),
				createRandom(0,999),
				createRandom(0,999));
	}
	@Override
	public String createRandom(int start, int end) {
		return String.format("%03d",(int)(Math.random()*end) +start);
	}
	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
	}

	@Override
	public AccountBean findById(AccountBean ac) {
		AccountBean acc = new AccountBean();

		// 배열 list 를 looping 하면서
		// ID가 일치하고 비번이 일치한 값을 찾아서
		// 그 객체를 리턴한다.
		// 일단 일치하는 값이 없는 상황은 나중에 처리

		// 검색엔진 : for(){ if(){} }
		for (int i = 0; i < count; i++) { // list.length로 쓰면 안됨. 쓸데없이 많이 돈다new AccountBean[10];
			if (ac.getUid().equals(list[i].getUid()) && ac.getPw().equals(list[i].getPw())) {
				acc = list[i];
				break;  		//엔진내 loop를 멈춰야함
			}
		}
		return acc;
	}
	
	@Override
	public AccountBean[] findByName(String name) {
		int temp = countSameWord(name);
		AccountBean[] arr = new AccountBean[temp];
		int j=0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				arr[j]=list[i];
				j++;
				if(j==temp) {
					break;
				}
			}
		}
		return arr;
	}

	@Override
	public int countSameWord(String word) {
		int temp =0; // 동명이인의 숫자. 
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				temp++;
			}
		} 
		return temp;
	}
	@Override
	public AccountBean[] minusList() {
		AccountBean[] arr = new AccountBean[0]; 
		
		return arr;
	}
	@Override
	public String changePw(AccountBean ac) {
		//  성공: 변경완료
		// 실패 : 변경실패( pw 와newpw 같으면 실패)
		String msg ="";
		String pw = ac.getPw().split("/")[0];
		String newPw = ac.getPw().split("/")[1];
		ac.setPw(pw);
		ac = findById(ac);
		
		if(ac.getUid()==null) {
			msg = "ID 존재무, 혹은 비번 틀림";
		}else {
			if(pw.equals(newPw)){
				msg = "비밀번호 변경 실패";
			}else {
				ac.setPw(newPw);
				msg = "변경완료";
			}
		}
		
		/*if(findById(ac).getPw().equals(newPw)) {
			msg = "변경실패";
		}else {
			msg = "변경완료";
		}*/
		return msg;
	}
	@Override
	public String deleteAccount(AccountBean ac) {
		String msg = "ID 존재무, 혹은 비번 틀림";
		String pw =ac.getPw().split("/")[0];
		String confirmPw =ac.getPw().split("/")[1];
	
		for(int i=0;i<count;i++){
			if(ac.getUid().equals(list[i].getUid())
					&&
					pw.equals(list[i].getPw())
					&&
					confirmPw.equals(list[i].getPw())) {
				list[i]=list[--count];
				list[count]=null;	
				//list[i]=list[count-1];
				//list[count-1]=null;
					count--;
					msg = "삭제성공";
					break;
				}else {
					msg = "삭제실패";
			}
		}
	
		return msg;
	}
}


/*String op="";
for(int i=0;i<3;i++) {
	if(i==2){
		op="-";
	}
	accountNo+= String.format("%03d", (int)(Math.random()*1000))+op;
}*/
