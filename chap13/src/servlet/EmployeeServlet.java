package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeListLogic;


@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GetEmployeeListLogic getEmployeeListLogic = new GetEmployeeListLogic();
		 List<Employee> empList = getEmployeeListLogic.execute();
		 request.setAttribute("empList", empList);
		 
		 RequestDispatcher dispatcher =
				 request.getRequestDispatcher("/WEB-INF/jsp/employee.jsp");
		 dispatcher.forward(request, response);		 		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
//		List<Employee> empList = request.getParameter("");

	}

}
