package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext application=arg0.getSession().getServletContext();
		Integer online_number=(Integer)application.getAttribute("online_number");
		if(null==online_number)
			online_number=0;
		online_number++;
		application.setAttribute("online_number", online_number);
		
		System.out.println("新增一位在线用户");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext application=arg0.getSession().getServletContext();
		Integer online_number=(Integer)application.getAttribute("online_number");
		if(null==online_number)
			online_number=0;
		else online_number--;
		application.setAttribute("online_number", online_number);
		System.out.println("一位用户离开");
	}

}
