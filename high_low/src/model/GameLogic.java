package model;

public class GameLogic {
	public void execute(Game game) {
		
		int user = game.getUser();
		int com = game.getCom();
		String Msg = "";//game.getMsg();
		
		if (user > com) {
			Msg = "大きすぎます";
		} else if (user < com) {
			Msg = "小さすぎます";
		} else {
			Msg = "正解です";
		}
        game.setMsg(Msg);//メッセージを新しく書き換えてセット　新しいgameインスタンスになっている
	}

}
