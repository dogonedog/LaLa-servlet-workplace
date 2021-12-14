

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")//http://localhost:8080/example/HelloServlet @WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//同一のs－ブレットｄと照明するもの
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {//response インスタンス　ユーザーのリクエストが入っている

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.println("...");
		out.println("</html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//getContextPath() プロジェクトの名前を取得する
	}//ユーザーがあくせすが　あったら動く　以下を表示　Served atをつけくうぇる　そういうＵｒｌでリクエストしてきたかを文字列で表示　それをゲットライターに表示　送り消している

}
