package addr;

import java.util.Scanner;

public class AddrMenu {
	private AddrService as;
	public AddrMenu() {
		as = new AddrService();
	}
	public void run(Scanner sc) {
		boolean flag = true;
		while(flag) {
			System.out.println("1.등록, 2.번호로 검색, 3.이름으로검색, 4.전화로 검색, 5.수정, 6.삭제, 7.전체목록, 8.종료");
			int m = sc.nextInt();
			switch (m) {
			case 1: 
				as.addAddr(sc);
				break;
			case 2:
				as.myInfo(sc);
				break;
			case 3:
				as.findName(sc);
				break;
			case 4:
				as.findTel(sc);
				break;
			case 5:
				as.editAddr(sc);
				break;
			case 6:
				as.delete(sc);
				break;
			case 7:
				as.printAll();
				break;
			case 8:
				flag = false;
				break;
			}
		}
	}
}
