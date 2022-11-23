package hello.servelt.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//set response header
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[status-line]
		response.setStatus(HttpServletResponse.SC_OK);

		//[response-headers]
		response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-Header", "hello");

		//[Header 편의 메서드]
		content(response);
		cookie(response);
		redirect(response);


		//[Message Body]
		PrintWriter writer = response.getWriter();
		writer.println("ok");

	}

	//response.sendRedirect를 사용해서 redirect
	private void redirect(HttpServletResponse response) throws IOException {
		//Status Code : 302
		//Location : "/basic/hello-form.html"

//		response.setStatus(HttpServletResponse.SC_FOUND);
//		response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}

	//setHeader 로 세팅할 수 있지만 Cookie 라는 객체를 사용한다
	//response.addCookie를 통해서 Cookie 객체를 삽입한다
	private void cookie(HttpServletResponse response) {
		//Set-Cookie : myCookie=good; Max-Age=600;

		//response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600")
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600);
		response.addCookie(cookie);
	}

	//content type을 setHeader에서 직접 설정해주는 것이 아닌 기존 함수를 이용
	//Content-Length는 임의로 정할 수도 있고, 생략 시 자동 계산 후 생성
	private void content(HttpServletResponse response) {
		//Content-Type : text/plain; charset=utf-8
		//Content-Length : 2

		//response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		//response.setContentLength(2); //생략 시 자동 생성
	}
}
