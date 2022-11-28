package hello.servelt.web.frontcontroller.v4.controller;

import hello.servelt.damain.member.Member;
import hello.servelt.damain.member.MemberRepository;
import hello.servelt.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

//return view name Stirng
public class MemberListControllerV4 implements ControllerV4 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		model.put("members", members);

		return "members";
	}
}
