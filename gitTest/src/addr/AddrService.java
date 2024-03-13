package addr;

import java.util.ArrayList;
import java.util.Scanner;

public class AddrService {
	private AddrDao Dao;
	public AddrService() {
		Dao = new AddrDao();
	}
	public void addAddr(Scanner sc) {
		System.out.println("등록");
		System.out.println("name: ");
		String name = sc.next();
		System.out.println("tel: ");
		String tel = sc.next();
		System.out.println("addr: ");
		sc.nextLine(); //버퍼에 남은 엔터 삭제
		String addr = sc.next();
		Dao.insert(new Addr(0,name,tel,addr));
	}
	public void editAddr(Scanner sc) {
		System.out.println("edit id: ");
		int id = sc.nextInt();
		System.out.println("new tel: ");
		String tel = sc.next();
		System.out.println("new address: ");
		sc.nextLine();
		String address = sc.next();
		int cnt = Dao.update(new Addr(id,"",tel,address));
		if (cnt>0) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
	}
	public void delete(Scanner sc) {
		System.out.println("delete id: ");
		int id = sc.nextInt();
		int cnt  = Dao.delete(id);
		if(cnt>0) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
	}
	public void myInfo(Scanner sc) {
		System.out.println("id: ");
		int id = sc.nextInt();
		Addr a = Dao.findById(id);
		if(a==null) {
			System.out.println("not found");
		}else {
			System.out.println(a);
		}
	}
	public void printAll() {
		ArrayList<Addr> list = Dao.findAll();
		for (Addr addr : list) {
			System.out.println(addr);
		}
	}
	public void findName(Scanner sc) {
		System.out.println("find name: ");
		String name = sc.next();
		ArrayList<Addr> list =  Dao.findByName(name);
		if(list.size()==0) {
			System.out.println("not found");
		}else {
			for (Addr addr : list) {
				System.out.println(addr);
			}
		}
	}
	public void findTel(Scanner sc) {
		System.out.println("find tel: ");
		String tel = sc.next();
		ArrayList<Addr> list =  Dao.findByTel(tel);
		if(list.size()==0) {
			System.out.println("not found");
		}else {
			for (Addr addr : list) {
				System.out.println(addr);
			}
		}
	}
}

















