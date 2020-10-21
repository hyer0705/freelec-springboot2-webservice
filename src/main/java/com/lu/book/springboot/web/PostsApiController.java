package com.lu.book.springboot.web;

import com.lu.book.springboot.service.posts.PostsService;
import com.lu.book.springboot.web.dto.PostsResponseDto;
import com.lu.book.springboot.web.dto.PostsSaveRequestDto;
import com.lu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 등록 - Insert
    @PostMapping("/api/vi/posts")
    public Long save(
            @RequestBody PostsSaveRequestDto requestDto
            ) {

        return postsService.save(requestDto);
    }

    // 수정 - Update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(
            @PathVariable Long id
            , @RequestBody PostsUpdateRequestDto requestDto
    ){

        return postsService.update(id, requestDto);
    }

    // 조회 - Select
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(
        @PathVariable Long id
    ){

        return postsService.findById(id);
    }

    // 삭제 - Delete
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(
        @PathVariable Long id
    ){

        postsService.delete(id);
        return id;
    }
}
