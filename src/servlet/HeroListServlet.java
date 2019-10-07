package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html; charset=UTF-8");
		
//		String userName=(String)request.getSession().getAttribute("userName");
//		if(null==userName){
//			response.sendRedirect("login.html");
//			return;
//		}
		
		int start=0;
		int count=5;
		try {
			start=Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		int next=start+count;
		int pre=start-count;
		pre=pre<0?0:pre;
		int total=new HeroDAO().getTotal();
		int end;
		if(0==total%count)
			end=total-count;
		else
			end=total-total%count;
		next=next>end?end:next;
		List<Hero> heros=new HeroDAO().list(start,count);
//		StringBuffer sb=new StringBuffer();
//		sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
//		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>±‡º≠</td><td>…æ≥˝</td></tr>\r\n");
//		
//		String format="<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
//		for(Hero hero:heros){
//			String tr=String.format(format, hero.id,hero.name,hero.hp,hero.damage,hero.getId(),hero.getId());
//			sb.append(tr);
//		}
//		sb.append("</table>");
//		response.getWriter().println(sb.toString());
		
		//mvc jspœ‘ æ
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("end", end);
		request.setAttribute("heros", heros);
		request.getRequestDispatcher("listHero.jsp").forward(request, response);
	}
}
