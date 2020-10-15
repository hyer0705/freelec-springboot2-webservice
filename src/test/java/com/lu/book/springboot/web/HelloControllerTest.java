package com.lu.book.springboot.web;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// 테스트를 진행할 때 JUnit에 내장된 실행자와 다른 실행자를 실행시킨다.
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함!
@RunWith(SpringRunner.class)
// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
// -> @Controller, @ControllerAdvice 등을 사용할 수 있음!
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리하는 Bean을 주입 받는다.
    @Autowired
    // 웹 API를 테스트할 때 사용!
    // MockMvc 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        
        // "/hello" 주소로 HTTP GET 요청을 함
        mvc.perform(get("/hello"))
                // mvc.perform() 의 결과를 검증
                // HTTP Header 의 Status(HTTP 상태 코드) 검증 ex. 200, 404 등
                // 여기서는 200인지 아닌지를 검증한다.
                .andExpect(status().isOk())
                // mvc.perform() 의 결과를 검증함
                // 응답 본문의 내용을 검증한다.
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "cherry";
        int amount = 309;

        // param(): API 테스트할 때 사용될 요청 파라미터를 설정
        //  단, 값은 String 만 허용
        //  그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능합니다.

        // jsonPath(): JSON 응답값을 필드별로 검증할 수 있는 메소드
        //  $ 를 기준으로 필드명을 명시
        //  여기서는 name 과 amount 를 검증하나 $.name, $.amount 로 검증합니다.
        mvc.perform(
                get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}
