package com.lu.book.springboot.web;

import com.lu.book.springboot.service.posts.PostsService;
import com.lu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/vi/posts")
    public Long save(
            @RequestBody PostsSaveRequestDto requestDto
            ) {

        return postsService.save(requestDto);
    }
}
