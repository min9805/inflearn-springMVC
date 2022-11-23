package hello.servelt.web.servlet;

import hello.servelt.damain.member.Member;
import hello.servelt.damain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//show all members
//HTML을 write으로 표현하기는 어렵기에 template engine 을 사용한다.
//Java code에 HTML을 삽입하기보다 HTML에 Java code를 집어넣는다.
@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		writer.write("<html>");
		writer.write("<head>");
		writer.write("    <meta charset=\"UTF-8\">");
		writer.write("    <title>Title</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("<a href=\"/index.html\">메인</a>");
		writer.write("<table>");
		writer.write("    <thead>");
		writer.write("    <th>id</th>");
		writer.write("    <th>username</th>");
		writer.write("    <th>age</th>");
		writer.write("    </thead>");
		writer.write("    <tbody>");
		for (Member member : members) {
			writer.write("    <tr>");
			writer.write("        <td>" + member.getId() + "</td>");
			writer.write("        <td>" + member.getUsername() + "</td>");
			writer.write("        <td>" + member.getAge() + "</td>");
			writer.write("    </tr>");
		}
		writer.write("    </tbody>");
		writer.write("</table>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
