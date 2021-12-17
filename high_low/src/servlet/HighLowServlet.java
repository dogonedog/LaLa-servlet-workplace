package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;


@WebServlet("/game")//("/judge")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/WEB-INF/jsp/play.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");
		
		int user = Integer.parseInt(number);//Integerがクラス　parseInt(number)がメソッド
		int com = new java.util.Random().nextInt(10);//(int) (Math.random() * 10);double型　static newしなくていい
        //int com = Integer.parseInt(request.getParameter("com"));
		String Msg ="";
		if (user > com) {
			Msg = "大きすぎます";
		} else if (user < com) {
			Msg = "小さすぎます";
		} else {
			Msg = "正解です";
		}
		
		System.out.println("user:" + user + "com:" + com + Msg);
		
		
		Game game = new Game(user, com, Msg);//作ったクラスをデータの運び役
		request.setAttribute("game", game);
		
		
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
