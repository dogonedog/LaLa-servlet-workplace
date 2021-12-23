package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ListenerSample implements ServletContextListener {


    public ListenerSample() {//コンストラクター
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent sce)  { //終了する時に動作
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { //開始する時に動作
         ServletContext context = sce.getServletContext();
         Integer count =0;
         context.setAttribute("count", count);
         System.out.println("Count" + count + "をセット");
         
    }
	
}
