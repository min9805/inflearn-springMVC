package hello.servelt.web.frontcontroller.v2.controller;

import hello.servelt.damain.member.Member;
import hello.servelt.damain.member.MemberRepository;
import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	//return MyView with viewPath
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		request.setAttribute("member", member);

		return new MyView("/WEB-INF/views/save-result.jsp");
	}
}
