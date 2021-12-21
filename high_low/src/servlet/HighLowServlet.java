	package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Game;
import model.GameLogic;


@WebServlet("/game")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			HttpSession session = request.getSession();	
			String replay = request.getParameter("replay");
			Game game =null;
			String url =null;
			if(replay == null) {//ゲーム始める時はnull
				// Gameインスタンスを作成
				int user = 0;
				int com = (int) (Math.random() * 99) + 1;
				String Msg ="";
				game = new Game(user, com, Msg);
				//sessionに保存
				session.setAttribute("game", game);
				url = "/WEB-INF/jsp/play.jsp";
			}
			
			else if (replay.equals("yes")) {
				//セッションからゲームインスタンスを取得する
				game = (Game) session.getAttribute("game");
				
				//gameのcomの値を新しい値にする（ランダム）
				int com = (int) (Math.random() * 99) + 1;
				game.setCom(com);//sessionに入っている値がここで変わってる　参照をセットしているので大元が変わる
				url = "/WEB-INF/jsp/play.jsp";
			} else if (replay.equals("end")) {
				session.invalidate();
				url = "/WEB-INF/jsp/end.jsp";
			}
						 
			
//			
			RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");
		
			int user = Integer.parseInt(number);//Userの情報をセッションに渡す
		
			HttpSession session = request.getSession();
			Game game = (Game) session.getAttribute("game");
			game.setUser(user);//セッションに保存されている Gameビーンズ を取得し、setUser()メソッドで user の値をセットする。;
				

			GameLogic gamelogic = new GameLogic();// GameLogicに渡す　GameLogicは方法なのでスコープにセットしない
			gamelogic.execute(game);//ここで新しいメッセージが入ったgameインスタンスになっている　ここで答えを出してからスコープにセットする
		
			System.out.println("user:" + user + "com:" + game.getCom() + game.getMsg());

		
			String url = "/WEB-INF/jsp/play.jsp";
			RequestDispatcher dispatcher =//dispatcherの移動先を設定
				request.getRequestDispatcher(url);//RequestDispatcherというクラス
			dispatcher.forward(request, response);//ここで遷移
	
	}
}
