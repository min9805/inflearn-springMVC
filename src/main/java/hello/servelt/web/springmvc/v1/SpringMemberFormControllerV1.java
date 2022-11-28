package hello.servelt.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//스프링이 자동으로 스프링 빈에 등록한다. 스프링 MCV에서 어노테이션 기반 컨트롤러로 인식한다.
//@Component + @RequestMapping
//main쪽에서 @Bean으로 등록해서 사용할 수도 있다.
@Controller
public class SpringMemberFormControllerV1 {

	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process() {
		return new ModelAndView("new-form");
	}
}




