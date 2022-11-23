package hello.servelt.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */

/*
 * param name을 꺼낸 후 request.getParameter를 통해서 value 값을 가져온다
 * param name이 같은 경우 getParameterValues 를 통해 list를 받아올 수 있다
 * */

/*
 * Post from HTML 에서도 같은 형식을 지원한다
 * content type : application/x-www.form-urlencoded
 * message body : username=hello&age=20
 * 둘의 형식이 같기 때문에 request.getParameter로 가져올 수 있다.
 * */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[전체 파라미터 조회] - start");

		request.getParameterNames().asIterator()
				.forEachRemaining(param -> System.out.println(param + " = " + request.getParameter(param)));

		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();

		System.out.println("[단일 파라미터 조회]");
		String username = request.getParameter("username");
		String age = request.getParameter("age");

		System.out.println("username = " + username);
		System.out.println("age = " + age);
		System.out.println();

		System.out.println("[이름 동일 중복 파라미터 조회]");
		String[] usernames = request.getParameterValues("username");
		for (String name : usernames) {
			System.out.println("username = " + name);
		}
		System.out.println();

		response.getWriter().write("OK");
	}
}
