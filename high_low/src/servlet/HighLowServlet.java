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


@WebServlet("/game")//("/judge")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			HttpSession = request.getSeeeion();

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
		
		int user = Integer.parseInt(number);//Integerがクラス　parseInt(number)がメソッド
		//int com = new java.util.Random().nextInt(10);(int) (Math.random() * 10);double型　static newしなくていい
        //int com = Integer.parseInt(request.getParameter("com"));
		

		//String Msg= "";//コンストラクタにMsgがあるのでとりあえず空のメッセージをつくる
		
//		if (user > com) {
//			Msg = "大きすぎます";
//		} else if (user < com) {
//			Msg = "小さすぎます";
//		} else {
//			Msg = "正解です";
//		}

		Game game = (Game) session.getAttribute("game");
		Game game = new Game(user, com, Msg);
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


//		Integer userNum = Integer.valueOf(user);
//		Integer comNum = Integer.valueOf(com);
//		request.setAttribute("userNum", userNum);
//		request.setAttribute("comNum", comNum);
//		request.setAttribute("Msg", Msg);
		
		String url = "/WEB-INF/jsp/play.jsp";
		RequestDispatcher dispatcher =//dispatcherの移動先を設定
				request.getRequestDispatcher(url);//RequestDispatcherというクラス
		dispatcher.forward(request, response);//ここで遷移

		
		
		
		
		
		
		
		
		
		
//	response.setContentType("text/html; charset=UTF-8");
//	PrintWriter out = response.getWriter();
//	out.println("<DOCTYPE html>");
//	out.println("<html>");
//	out.println("<head>");
//	out.println("<meta charset=\"UTF-8\">");
//	out.println("<title></title>");
//	out.println("</head>");
//	out.println("<body>");
//	out.println("<p>" + Msg + "</p>");	
//	out.println("<a href=\"/high_low/play.jsp\">「もう一度する?」</a>");//プロジェクトの名前を指定する
//	out.println("</body>");	
//	out.println("</html>");
	
	}
}
