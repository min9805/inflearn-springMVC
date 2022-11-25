package hello.servelt.web.frontcontroller.v3.controller;

import hello.servelt.damain.member.Member;
import hello.servelt.damain.member.MemberRepository;
import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

//WEB_INF/views/, jsp 는 공통 부분이므로 추출한다
public class MemberSaveControllerV3 implements ControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		String username = paramMap.get("username");
		int age = Integer.parseInt(paramMap.get("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		ModelView mv = new ModelView("save-result");
		mv.getModel().put("member", member);
		return mv;

	}
}
