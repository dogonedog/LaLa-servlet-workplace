package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	//こっから教科書コード　運勢をランダムで決定
	String[] luckArray = { "超スッキリ", "スッキリ", "最悪"};//超スッキリ0, スッキリ1, 最悪2
	int index = (int) (Math.random() * 3);//0.999 Math.random() 0～0.999　×　3　でint 
	String luck = luckArray[index];
	
	//実行日を取得
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	String today = sdf.format(date);//日付を文字列のかえる
	
	//HTMLを出力
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset=\"utf-8\"");
	out.println("<title>スッキリ占い</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>" + today + "の運勢は「" + luck + "」です</p>");
	out.println("</body>");
	out.println("</html>");
	}

}
