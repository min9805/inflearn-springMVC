package hello.servelt.web.frontcontroller.v2;

import hello.servelt.web.frontcontroller.MyView;
import hello.servelt.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servelt.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servelt.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServiceV2 extends HttpServlet {
	private Map<String, ControllerV2> controllerMap = new HashMap<>();

	//url mapping
	public FrontControllerServiceV2() {
		controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
		controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
		controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
	}

	//find url, call controller
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FrontControllerServiceV2.service");

		String requestURI = request.getRequestURI();

		System.out.println("requestURI = " + requestURI);

		ControllerV2 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		MyView myView = controller.process(request, response);
		myView.render(request, response);
	}
}
