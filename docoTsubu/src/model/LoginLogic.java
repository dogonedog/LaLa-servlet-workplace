package model;

public class LoginLogic {
	/**
	 * userインスタンスの中のパスが"1234"であるかどうのメソッド
	 * User user name:名前
	 * 　　　　　pass;パスワード「
	 * 
	 * 使い方：LoginLogic Logic = new LoginLogic();
	 *         if (logic.exscute(user){//正しいパスワードの時の処理　(logic.exscute(user)がtrue 
	 *         } else {
	 *         //まちがったパスワードのときの処理
	 *         }
	 * @param user　name
	 * @parame　
	 * @return-true パスワードは1234である
	 *          false 違う
	 * */
	public boolean excute(User user) {
		if(user.getPass().equals("1234")) {
			return true;
		}
			return false;
	}
}
