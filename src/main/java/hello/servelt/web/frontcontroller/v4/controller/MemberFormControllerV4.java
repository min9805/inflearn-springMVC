package hello.servelt.web.frontcontroller.v4.controller;

import hello.servelt.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

//return view name Stirng
public class MemberFormControllerV4 implements ControllerV4 {
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "new-form";
	}
}
