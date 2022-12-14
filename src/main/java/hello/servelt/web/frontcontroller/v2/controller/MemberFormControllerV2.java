package hello.servelt.web.frontcontroller.v2.controller;

import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
	//return MyView with viewPath
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return new MyView("/WEB-INF/views/new-form.jsp");
	}
}
