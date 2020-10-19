package com.lu.book.springboot.web.domain.posts;

import com.lu.book.springboot.domain.posts.Posts;
import com.lu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
// H2 데이터베이스를 자동으로 실행해줌!
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        // given
        String title = "테스트 게시글";
        String content = "테스트 본문 내용";

        // 테이블 posts에 insert/update 쿼리를 실행
        //  id 값이 있으면 update, 없으면 insert 실행
        postsRepository.save(Posts.builder()
                                    .title(title)
                                    .content(content)
                                    .author("lu@gmail.com")
                                    .build()
        );

        // when
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
