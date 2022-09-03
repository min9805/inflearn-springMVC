package hello.servelt.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servelt.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringJSON", urlPatterns = "/request-body-json")
public class RequestBodyStringJSON extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

		System.out.println("helloData.getUsername() = " + helloData.getUsername());
		System.out.println("helloData.getAge() = " + helloData.getAge());

		response.getWriter().write("ok");
	}
}
