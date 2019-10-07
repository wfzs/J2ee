import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void init(ServletConfig config){
		System.out.println("init(ServeletConfig)");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
//		Enumeration<String> headerNames=request.getHeaderNames();
//		while(headerNames.hasMoreElements()){
//			String header=headerNames.nextElement();
//			String value=request.getHeader(header);
//			System.out.printf("%s\t%s%n",header,value);
//		}
		
		try {
			response.setContentType("text/lol; charset=UTF-8");
//			response.setCharacterEncoding("UTF-8");
			
			response.getWriter().println("<h1>Hello Servlet</h1>");
			response.getWriter().println(new Date().toLocaleString());
			
			PrintWriter pw=response.getWriter();
			pw.println("<h1>hello ×æ¹ú</h1>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
