package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;

public class HeroDeleteServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		new HeroDAO().delete(id);
		response.sendRedirect("/listHero");
	}
}
