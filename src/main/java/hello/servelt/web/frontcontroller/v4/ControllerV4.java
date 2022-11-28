package hello.servelt.web.frontcontroller.v4;

import java.util.Map;

/**
 * paramMap 으로 파라미터를 받아와
 * model 로 넘겨준다
 * view의 이름만 sting으로 넘겨주면된다
 */
public interface ControllerV4 {
	String process(Map<String, String> paramMap, Map<String, Object> model);
}
