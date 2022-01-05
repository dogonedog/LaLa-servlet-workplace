package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindByNameLogic;


@WebServlet("/findByName")
public class FindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//受け取ったデータのエンコードをフィルタでやっているいきなり取得できる

		String name = request.getParameter("name");
		FindByNameLogic logic = new FindByNameLogic();
		List<Employee> empList = logic.execute(name);
		request.setAttribute("empList", empList);
		String url = "/WEB-INF/jsp/employee.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
