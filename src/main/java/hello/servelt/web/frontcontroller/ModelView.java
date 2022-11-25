package hello.servelt.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

//controller 에서 HTTPServletRequest 를 사용할 수 없기에, request.setAttribute()도 사용할 수 없어서 별도의 모델이 필요하다
//modelView = MyView + model(저장공간)
public class ModelView {
	private String viewName;
	private Map<String, Object> model = new HashMap<>();

	public ModelView(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
}
