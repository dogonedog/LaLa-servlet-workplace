package model;

public class LoginLogic {
	/**
	 * Userインスタンスのなかのpassが"1234"であるかどうかを
	 * 調べるメソッド。
	 *   User user -- name : 名前
	 *                pass : パスワード
	 * 使い方: LoginLogic logic = new LoginLogic();
	 *         if (logic.execute(user)) {
	 *           // 正しいパスワードのときの処理
	 *         } else {
	 *         	 // まちがったパスワードのときの処理
	 *         }
	 * @param user
	 * @return true -- パスワードが1234である
	 *          false -- ちがう
	 */
	public boolean execute(User user) {
		if (user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
