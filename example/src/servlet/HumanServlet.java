package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;


@WebServlet("/human")//human doget servletから動く http;//localhost:8080/example/human
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			Human human = new Human("田村", 20);
		
		request.setAttribute("human", human);//doGet の引数のrequest リクエストスコープにインスタンスを保存
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/human.jsp");//jspに移動
		dispatcher.forward(request, response);
		
	}

}
