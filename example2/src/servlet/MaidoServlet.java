package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/maido")
public class MaidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; Charset=UTF-8");//p85
		PrintWriter out = response.getWriter();
		out.println("<html><meta charset\"UTF-8\"></head>");
		out.println("<head></head>");
		out.println("<h1>まいど</h1>");
		out.println("</body></html>");
	}

}
