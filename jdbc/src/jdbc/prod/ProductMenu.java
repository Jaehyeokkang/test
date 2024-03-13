package jdbc.prod;

import java.util.Scanner;

import jdbc.mem.MemService;

public class ProductMenu {
	private MemService mservice;
	private ProdService pservice;
	public ProductMenu() {
		mservice = new MemService();
		pservice = new ProdService();
	}
	
	//high menu
	public void run(Scanner sc) {
		while(true) {
		System.out.println("종료는 0: ");
		int m = sc.nextInt();
		if (m==0) {
			break;
		}
		if(MemService.loginId==null) {
			runMemLogOut(sc);
		}else {
			runMemLogin(sc);
		}
		
		}
	}
	public void runMemLogOut(Scanner sc) {
		boolean flag = true;
		while (flag) {
			System.out.println("1.로그인 2.회원가입 3.종료");
			int m = sc.nextInt();
			switch(m) {
			case 1:
				flag = !mservice.login(sc);
				break;
			case 2:
				mservice.addMem(sc);
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}
	public void runMemLogin(Scanner sc) {
		boolean flag = true;
		while(flag) {
			System.out.println("1.내정보확인 2.내정보수정 3.로그아웃 4.탈퇴 5.상품 6.종료");
			int m = sc.nextInt();
			switch(m) {
			case 1:
				mservice.printMem(sc);
				break;
			case 2:
				mservice.editMem(sc);
				break;
			case 3:
				mservice.logout();
				break;
			case 4:
				mservice.delMem();
				break;
			case 5:
				runProud(sc);
				break;
			case 6:
				flag = false;
				break;
			}
			
		}
	}
	public void runProud(Scanner sc) {
		boolean flag = true;
		while(flag) {
			System.out.println("1.상품등록 2.번호로검색 3.상품명으로검색 4.가격대검색 5.전체목록 6.종료");
			int m = sc.nextInt();
			switch(m) {
			case 1:
				pservice.addBoard(sc);
				break;
			case 2:
				pservice.getByNum(sc);
				break;
			case 3:
				pservice.getByName(sc);
				break;
			case 4:
				pservice.getByPrice(sc);
				break;
			case 5:
				pservice.getAll();
				break;
			case 6:
				flag = false;
			}
		}
	}
}
