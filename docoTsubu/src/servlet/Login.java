package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user = new User(name, pass);
		
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.excute(user);//boolean型の変数の宣言なのでbooleanをつける
		
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);//loginUserという名前で保存する
		}
		
		String url = "/WEB-INF/jsp/loginResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);//RequestDispatcherのインポートがいらない
	}

}
