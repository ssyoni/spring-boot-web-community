package com.web;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommunityWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository,
	 					BoardRepository boardRepository)throws Exception{ 
		/* 
		스프링은 Bean 으로 생성된 메서드에 파라미터로 DI(Dependency Injection) 시키는 매커니즘이 존재. 생성자를 통해 의존성 주입시기는거랑 유사.
		*/
		return (args) -> {
			/*
			User 객체를 빌터패턴(Builder Pattern)을 사용하여 생성한 후, 주입받은 UserReopsitory를 통해 객체를 저장
			*/
			User user = userRepository.save(User.builder()
				.name("havi")
				.password("test")
				.email("havi@gmail.com")
				.createdDate(LocalDateTime.now())
				.build());
			
			/*
			페이징 처리 테스트를 위해 위와 동일하게 빌터 패턴을 사용. IntStream의 rangeClosed를 사용하여 index 순서대로 Board 객체 200개를 생성하여 저장
			*/
			IntStream.rangeClosed(1, 200).forEach(index ->
				boardRepository.save(Board.builder()
					.title("게시글"+index)
					.subTitle("순서"+index)
					.content("콘텐츠")
					.boardType(BoardType.free)
					.createdDate(LocalDateTime.now())
					.updatedDate(LocalDateTime.now())
					.user(user).build()));
		
		};

	}
}
