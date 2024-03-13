package jdbc.board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BoardMenu m = new BoardMenu();

		Scanner sc = new Scanner(System.in);
		m.run(sc);
	}
}
