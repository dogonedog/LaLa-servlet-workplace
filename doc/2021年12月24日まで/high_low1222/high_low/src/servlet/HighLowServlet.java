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

/**
 * Servlet implementation class HighLowServlet
 */
@WebServlet("/game")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String replay = request.getParameter("replay");
		Game game = null;
		String url = null;
		if (replay == null) {
			// Gameインスタンスを作成
			int user = 0;
			int com = (int) (Math.random() * 99) + 1;
			String msg = "";
			game = new Game(user, com, msg);
			// session に保存
			session.setAttribute("game", game);
			url = "/WEB-INF/jsp/play.jsp";
		}
		else if (replay.equals("yes")) {
			// セッションからgameインスタンスを取得する
			game = (Game) session.getAttribute("game");
			// gameのcomの値を新しい値にする（ランダム）
			int com = (int) (Math.random() * 99) + 1;
			game.setCom(com);
			url = "/WEB-INF/jsp/play.jsp";
		}
		else if (replay.equals("end")) {
			session.invalidate();
			url = "WEB-INF/jsp/end.jsp";
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int user = Integer.parseInt(request.getParameter("num"));
		// セッションからGameインスタンスを取得する
		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute("game");
		// Gameインスタンスに新しいuserの値をセット
		game.setUser(user);
		
		GameLogic gameLogic = new GameLogic();
		gameLogic.execute(game);
		
		System.out.println
		  ("user:" + user + " com:" + game.getCom() + " " + game.getMsg());
		
		String url = "/WEB-INF/jsp/play.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}

}
