package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/judge")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String number = request.getParameter("number");
		
		int user = Integer.parseInt(number);//Integerがクラス　parseInt(number)がメソッド
		//int com = new java.util.Random().nextInt(10);(int) (Math.random() * 10);double型　static newしなくていい
int com = Integer.parseInt(request.getParameter("com"));
		String Msg ="";
		if (user > com) {
			Msg = "大きすぎます";
		} else if (user < com) {
			Msg = "小さすぎます";
		} else {
			Msg = "正解です";
		}

	
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset=\"UTF-8\">");
	out.println("<title></title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>" + Msg + "</p>");	
	out.println("<a href=\"/high_low/play.jsp\">「もう一度する?」</a>");//プロジェクトの名前を指定する
	out.println("</body>");	
	out.println("</html>");
	
	}
}
