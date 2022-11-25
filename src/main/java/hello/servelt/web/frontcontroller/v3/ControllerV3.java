package hello.servelt.web.frontcontroller.v3;

import hello.servelt.web.frontcontroller.ModelView;

import java.util.Map;

//return ModelView, withdraw HTTPServlet..
public interface ControllerV3 {
	ModelView process(Map<String, String> paramMap);
}
