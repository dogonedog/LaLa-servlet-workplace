package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {

	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}

	public static void testFindByLogin1() {
		Login login = new Login("minato", "1234");// この情報を持つインスタンスを作っている
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);// AccountはAccountの全ての情報が入っている resultにはみなとの全ての情報がはいってくる

		if (result != null) {// resulがnullでなければ成功
			System.out.println("あった");
			System.out.println(result.getUserId());
			System.out.println(result.getPass());
			System.out.println(result.getMail());
			System.out.println(result.getName());
			System.out.println(result.getAge());
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}

	}

	public static void testFindByLogin2() {
		Login login = new Login("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
