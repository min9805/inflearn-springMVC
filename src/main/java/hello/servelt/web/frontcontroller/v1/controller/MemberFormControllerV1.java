package hello.servelt.web.frontcontroller.v1.controller;

import hello.servelt.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
	//Servlet MVC 에서 사용한 것과 동일하다, view도 동일하게 사용한다
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);

	}
}
