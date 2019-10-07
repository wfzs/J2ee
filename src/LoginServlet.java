import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
//	public LoginServlet(){
//		System.out.println("LoginServletbei构造函数 被调用");
//	}
//	public void init(ServletConfig config){
//		System.out.println("init(ServeletConfig)");
//	}
//	private void destory(){
//		System.out.println("destroy");
//	}
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
//		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		
		// byte[] bytes = name.getBytes("ISO-8859-1");
        // name = new String(bytes, "UTF-8");
		
		String password=request.getParameter("password");
		
//		System.out.println("浏览器发出请求时的完整URL，包括协议  主机名  端口（如果有）:"+request.getRequestURL());
//		System.out.println("浏览器发出请求时的资源名部分，去掉协议  主机名  端口（如果有）:"+request.getRequestURI());
//		System.out.println("请求行中的参数部分:"+request.getQueryString());
//		System.out.println("浏览器所处于的客户机的IP地址："+request.getRemoteAddr());
//		System.out.println("浏览器所处于的客户机的主机名："+request.getRemoteHost());
//		System.out.println("浏览器所处于的客户机使用的网络端口："+request.getRemotePort());
//		System.out.println("服务器的IP地址："+request.getLocalAddr());
//		System.out.println("服务器的主机名："+request.getLocalName());
//		System.out.println("等到客户机的请求方式："+request.getMethod());
		
		String html=null;
		
		System.out.println("name:"+name);
		System.out.println("password:"+password);
		
		if("admin".equals(name)&&"123".equals(password))
		{
//			html="<div style='color:green'>登陆成功</div>";
//			request.getRequestDispatcher("success.html").forward(request, response);
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("listHero");
		}
		else
//			html="<div style='color:red'>登陆失败</div>";
//			response.sendRedirect("fail.html");
			response.sendRedirect("login.html");
			
		
//		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("charset=UTF-8");
//		PrintWriter pw=response.getWriter();
//		pw.print(html);
	}
}
