import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
//	public LoginServlet(){
//		System.out.println("LoginServletbei���캯�� ������");
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
		
//		System.out.println("�������������ʱ������URL������Э��  ������  �˿ڣ�����У�:"+request.getRequestURL());
//		System.out.println("�������������ʱ����Դ�����֣�ȥ��Э��  ������  �˿ڣ�����У�:"+request.getRequestURI());
//		System.out.println("�������еĲ�������:"+request.getQueryString());
//		System.out.println("����������ڵĿͻ�����IP��ַ��"+request.getRemoteAddr());
//		System.out.println("����������ڵĿͻ�������������"+request.getRemoteHost());
//		System.out.println("����������ڵĿͻ���ʹ�õ�����˿ڣ�"+request.getRemotePort());
//		System.out.println("��������IP��ַ��"+request.getLocalAddr());
//		System.out.println("����������������"+request.getLocalName());
//		System.out.println("�ȵ��ͻ���������ʽ��"+request.getMethod());
		
		String html=null;
		
		System.out.println("name:"+name);
		System.out.println("password:"+password);
		
		if("admin".equals(name)&&"123".equals(password))
		{
//			html="<div style='color:green'>��½�ɹ�</div>";
//			request.getRequestDispatcher("success.html").forward(request, response);
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("listHero");
		}
		else
//			html="<div style='color:red'>��½ʧ��</div>";
//			response.sendRedirect("fail.html");
			response.sendRedirect("login.html");
			
		
//		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("charset=UTF-8");
//		PrintWriter pw=response.getWriter();
//		pw.print(html);
	}
}
