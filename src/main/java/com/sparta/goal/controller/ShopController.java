package com.sparta.goal.controller;

import com.sparta.goal.dto.PostRequestDto;
import com.sparta.goal.dto.PostResponseDto;
import com.sparta.goal.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    // 생성자 선언
    private final ShopService shopService;
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // 판매 게시글을 작성하는 API
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return shopService.createPost(requestDto);
    }

    // 판매 게시글을 전체 조회하는 API
    @GetMapping("/post")
    public List<PostResponseDto> getAllPosts() {
        return shopService.getPost();
    }

    // 판매 게시글을 수정하는 API
    @PutMapping("/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return shopService.updatePost(id, requestDto);
    }


    // 판매 게시글을 삭제하는 API
    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Long id) {

        if (id.equals(shopService.deletePost(id)))
            return "삭제 완료";
        else {
            return "삭제 오류";
        }
    }

}
