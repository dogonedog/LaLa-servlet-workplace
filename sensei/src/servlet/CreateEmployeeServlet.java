package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmployeeLogic;
import model.Employee;

@WebServlet("/create")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt( request.getParameter("age"));
	
		Employee emp = new Employee(id, name, age);
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		boolean result = logic.execute(emp);
		String msg = null;
		if (result) {
			msg = "データを追加しました";
		} else {
			msg = "データの追加に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/createResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
