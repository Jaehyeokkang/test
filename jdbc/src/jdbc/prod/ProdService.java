package jdbc.prod;

import java.util.ArrayList;
import java.util.Scanner;

import jdbc.mem.MemService;

public class ProdService {
	private ProdDao dao;
	public ProdService() {
		dao = new ProdDao();
	}
	public void addBoard(Scanner sc) {
		System.out.println("=== add ===");
		System.out.println("name: ");
		String name = sc.next();
		System.out.println("price: ");
		int price = sc.nextInt();
		System.out.println("amount: ");
		int amount = sc.nextInt();
		dao.insert(new Product(0,name,price,amount,MemService.loginId));
	}
	public void getByNum(Scanner sc) {
		System.out.println("=== findByNum ===");
		System.out.println("num: ");
		int num = sc.nextInt();
		Product p = dao.select(num);
		if(p == null) {
			System.out.println("not found");
		}else {
			System.out.println(p);
			if(MemService.loginId.contains(p.getSeller()) ) {
				System.out.println("1.edit 2.delete 3.입출고 4.myinfoexit");
				int x = sc.nextInt();
				switch (x) {
				case 1:
					editProduct(sc, num);
					break;
				case 2:
					delProduct(num);
					break;
				case 3:
					editAmount(sc, num);
					break;
				}
			}
		}
	}
	public void getByName(Scanner sc) {
		System.out.println("=== findByName ===");
		System.out.println("name: ");
		String name = sc.next();
		ArrayList<Product> p = dao.selectByName(name);
		if(p.isEmpty()) {
			System.out.println("not found");
		}else {
			for (Product product : p) {
				System.out.println(product);
			}
		}
	}
	public void getByPrice(Scanner sc) {
		System.out.println("=== findByPrice ===");
		System.out.println("min price: ");
		int min = sc.nextInt();
		System.out.println("max price: ");
		int max = sc.nextInt();
		ArrayList<Product> p = dao.selectByPrice(min, max);
		if(p.isEmpty()) {
			System.out.println("not found");
		}else {
			for (Product product : p) {
				System.out.println(product);
			}
		}
	}
	public void getAll() {
		System.out.println("=== Product List ===");
		if(dao.selectAll().isEmpty()) {
			System.out.println("not found");
		}else {
		for (Product p : dao.selectAll()) {
			System.out.println(p);
		}}
	}
	public void editProduct(Scanner sc, int num) {
		System.out.println("=== Edit Product ===");
		System.out.println("new name: ");
		String name = sc.next();
		System.out.println("new price");
		int price = sc.nextInt();
		dao.update(new Product(num,name,price,0,MemService.loginId));
	}
	public void delProduct(int num) {
		System.out.println("=== delete Prodcut ===");
		dao.delete(num);
	}
	public void editAmount(Scanner sc, int num) {
		System.out.println("=== 입출고 ===");
		System.out.println("1.in 2.out");
		String[] title = {"in","out"};
		int type = sc.nextInt();
		if(type<1 || type>2) {
			System.out.println("error");
			return;
		}
		System.out.println(title[type-1]+"량: ");
		int amount = sc.nextInt();
		if(type == 2) {
			amount -= amount;
		}
		dao.bound(num, amount);
	}
}
