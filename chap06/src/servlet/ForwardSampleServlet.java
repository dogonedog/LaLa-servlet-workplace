package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardSampleServlet")
public class ForwardSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("このサーブレットにきたよ");
		
		String url = "/WEB-INF/jsp/forwardSample.jsp";//URLの表示はhttp://localhost:8080/chap06/ForwardSampleServlet　フォワード先のforwardSample.jspのURL表示でな
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);//request.getRequestDispatcher(url).forward(request, response);
		dispatcher.forward(request, response);
	}



}
