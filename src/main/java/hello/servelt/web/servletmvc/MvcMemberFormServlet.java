package hello.servelt.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		//dispatcher : controler -> view 이동 시 사용
		//forward 하면 servlet 에서 jsp를 호출할 수 있다. 서버끼리 내부에서 jsp를 다시 호출한다. 제어권을 넘겨준다
		//내부에서 서버가 호출하는 것이므로 url 등이 바뀌지 않는다. redirect가 아니다.

		//WEB-INF 는 항상 Controller(Servlet)를 거쳤으면 좋겠다하면.. 이 경로는 외부에서 호출되지 않는다

		//redirect가 아니라 서버 내부적으로 동작하기에 url이 바뀌지 않는다. 클라이언트가 알 수 없다.
		//외부에서 불러지지 않고 Controller를 통해서 동작하고 싶으면 WEB-INF에 넣으면 된다.
		//save 시에 상대경로 적용
	}
}
