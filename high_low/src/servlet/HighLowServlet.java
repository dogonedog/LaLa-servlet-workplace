package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.GameLogic;


@WebServlet("/game")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			HttpSession session = request.getSeeeion();

			Game game = new Game();
				game.user = 0;
				game.com = (int) (Math.random() * 100);
				game.Msg ="";

			session.setAttribute("game", game);

			String forwardPath = null;
			String replay = request.getParameter("replay");

			if (replay == null){
				forwardPath = "/WEB-INF/jsp/play.jsp";

			} else if (replay.equals("yes")){
				game.com = (int) (Math.random() * 100);

				forwardPath = "/WEB-INF/jsp/play.jsp";

			} else if (replay.equals("no")){
				session.removeAttribute("game");

				forwardPath = "/WEB-INF/jsp/end.jsp";
			}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");
		
		int user = Integer.parseInt(number);
		
		HttpSession session = request.getSeeeion();
		Game game = (Game) session.getAttribute("game");
		//Game game = new Game(user, com, Msg);
		game.setUser(user);
		GameLogic gamelogic = new GameLogic();
		gamelogic.execute(game);


　　　　<%-- リクエストスコープ--%>
		//Game game = new Game(user, com, Msg);//作ったクラスをデータの運び役　Msgは空
	
		//GameLogic gamelogic = new GameLogic();// GameLogicに渡す　GameLogicは方法なのでスコープにセットしない
		//gamelogic.execute(game);//ここで新しいメッセージが入ったgameインスタンスになっている　ここで答えを出してからスコープにセットする
		//request.setAttribute("game", game);//リクエストスコープにセット
		
		//System.out.println("user:" + user + "com:" + com + Msg + game.getMsg());
　　　　<%-- リクエストスコープ--%>

		
		String url = "/WEB-INF/jsp/play.jsp";
		RequestDispatcher dispatcher =//dispatcherの移動先を設定
				request.getRequestDispatcher(url);//RequestDispatcherというクラス
		dispatcher.forward(request, response);//ここで遷移


	}
}
