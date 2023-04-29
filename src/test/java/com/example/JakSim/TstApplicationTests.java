package com.example.JakSim;

import com.example.JakSim.login.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TstApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Getter/Setter테스트")
	void GetterSetterTest(){
		Member member = new Member();
		member.setId(1L);
		member.setEmail("wkdgyfla97@naver.com");
		member.setName("장효림");
		member.setPassword("알려주겠냐고 아 ㅋㅋ");
		member.setRegisterDateTime(LocalDateTime.now());

		System.out.println(member.toString());
		System.out.println(member.getEmail() + " :: " + member.getRegisterDateTime());
		// 커밋 테스트
	}

}
