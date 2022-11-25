package hello.servelt.web.frontcontroller.v1.controller;

import hello.servelt.damain.member.Member;
import hello.servelt.damain.member.MemberRepository;
import hello.servelt.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	//Servlet MVC 에서 사용한 것과 동일하다, view도 동일하게 사용한다
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		request.setAttribute("members", members);

		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
