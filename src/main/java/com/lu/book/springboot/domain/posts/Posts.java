package com.lu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@Getter
// 기본 생성자 자동 추가
@NoArgsConstructor
// 테이블과 링크될 클래스임을 나타낸다.
// 기본값으로 클래스의 CamelCase 이름을 언더스코어 네이밍으로 테이블 이름을 매칭합니다.
// ex) SalesManager.java -> sales_manager table
@Entity
public class Posts {

    // 해당 테이블의 PK(Primary Key) 필드를 나타낸다.
    @Id
    // PK의 생성 규칙을 나타낸다.
    // 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다!
    // 그렇다면 왜 사용하는가?
    //  기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
