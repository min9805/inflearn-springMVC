package hello.servelt.damain.member;

import lombok.Getter;
import lombok.Setter;

//Member domain
@Getter
@Setter
public class Member {
	private long id;
	private String username;
	private int age;

	public Member() {
	}

	public Member(String username, int age) {
		this.username = username;
		this.age = age;
	}
}
