package hello.servelt.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//서블릿과 비슷한 모양의 인터페이스를 만들고 각 컨트롤러는 인터페이스를 구현해서 일관성을 유지한다
public interface ControllerV1 {
	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
