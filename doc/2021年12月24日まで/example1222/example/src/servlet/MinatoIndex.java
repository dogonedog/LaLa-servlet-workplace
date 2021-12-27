package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
		
		if (siteEV == null) {      // 一番最初は siteEV はない。
			siteEV = new SiteEV();
		}
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		
		if (action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
		} 
		else if (action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		
		application.setAttribute("siteEV", siteEV);
		
		String url = "/WEB-INF/jsp/minatoIndex.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
