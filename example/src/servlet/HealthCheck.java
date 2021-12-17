package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;


@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/WEB-INF/jsp/healthCheck.jsp";//最初にサーブレットにアクセスさせるloczlhost/exmple/HealthCheck　→　doGet　→　healthCheck.jsp（これをURLを表示させたくない）
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");//数字の形だけど文字列が送られてくる
		
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();//healthCheckLogicのインスタンスを作成
		healthCheckLogic.Excute(health);
		
		request.setAttribute("health", health);
		
		String url = "/WEB-INF/jsp/healthCheckResult.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
