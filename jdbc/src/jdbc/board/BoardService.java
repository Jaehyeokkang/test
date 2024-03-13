package jdbc.board;

import java.util.ArrayList;
import java.util.Scanner;

import jdbc.mem.MemService;


public class BoardService {
	private BoardDao dao;
	public BoardService() {
		dao = new BoardDao();
	}
	public void addBoard(Scanner sc) {
		System.out.println("=== 글 작성 ===");
		System.out.println("title");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("content: ");
//		sc.nextLine();
		String content = sc.nextLine();
		dao.insert(new BoardMem(0,MemService.loginId,null,content,title));
	}
	
	public void getByNum(Scanner sc) {
		System.out.println("=== 번호로 검색 ===");
		System.out.println("num:");
		int num =sc.nextInt();
		BoardMem b = dao.select(num);
		if(b==null) {
			System.out.println("not found");
		}else {
			System.out.println(b);
			if(MemService.loginId==b.getWriter());{//로그인 아디와 현재글 작성자가 갇다 = 본인 글이다
				System.out.println("1.edit 2.delete 3.myinfoexit");
				int x = sc.nextInt();
				switch (x) {
				case 1: 
					editBoard(sc, num);
					break;
				case 2:
					delBoard(num);
					break;
				case 3:
					break;
				}
			}
		}
	}
	public void getByTitle(Scanner sc) {
		System.out.println("=== Title로 검색 ===");
		System.out.println("title:");
		String title =sc.next();
		ArrayList<BoardMem> b = dao.selectByTitle(title);
		if(b.isEmpty()) {
			System.out.println("not found");
		}else {
			for (BoardMem boardMem : b) {
				System.out.println(boardMem);
			}
		}
	}
	public void getByWriter(Scanner sc) {
		System.out.println("=== Writer로 검색 ===");
		System.out.println("writer:");
		String writer =sc.next();
		ArrayList<BoardMem> b = dao.selectByWriter(writer);
		if(b.isEmpty()) {
			System.out.println("not found");
		}else {
			for (BoardMem boardMem : b) {
				System.out.println(boardMem);
			}
		}
	}
	public void getAll() {
		System.out.println("=== boardlist ===");
		ArrayList<BoardMem> list = dao.selectAll();
		for (BoardMem boardMem : list) {
			System.out.println(boardMem);
		}
	}
	public void editBoard(Scanner sc, int num) {
		System.out.println("=== update ===");
		System.out.println("new title: ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("new content: ");
//		sc.nextLine();
		String content = sc.next();
		dao.update(new BoardMem(num, "",null,content,title));
	}
	public void delBoard(int num) {
		System.out.println("=== delete Board ===");
		dao.delete(num);
		
	}
}

