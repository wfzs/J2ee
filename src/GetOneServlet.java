
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import net.sf.json.JSONObject;

public class GetOneServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Hero hero=new Hero();
		hero.setName("¸ÇÂ×");
		hero.setHp(323);
		
		JSONObject json=new JSONObject();
		json.put("hero", JSONObject.fromObject(hero));
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
	}
}
