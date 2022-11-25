package hello.servelt.web.frontcontroller.v3.controller;

import hello.servelt.web.frontcontroller.ModelView;
import hello.servelt.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

//WEB_INF/views/, jsp 는 공통 부분이므로 추출한다
public class MemberFormControllerV3 implements ControllerV3 {
	@Override
	public ModelView process(Map<String, String> paramMap) {
		return new ModelView("new-form");
	}
}
