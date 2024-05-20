package com.sparta.goal.service;

import com.sparta.goal.dto.PostRequestDto;
import com.sparta.goal.dto.PostResponseDto;
import com.sparta.goal.entity.Shop;
import com.sparta.goal.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // 게시글 작성
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Shop shop = new Shop(requestDto);

        //DB 저장
        Shop saveShop = shopRepository.save(shop);

        PostResponseDto postResponseDto = new PostResponseDto(shop);

        return postResponseDto;
    }

    // 전체 게시글 조회
    public List<PostResponseDto> getPost() {
        return shopRepository.findAllByOrderById().stream().map(PostResponseDto::new).toList();
    }

    // 게시글 수정
    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        // 해당 게시글 DB에 존재하는지 확인
        Shop shop = findPostById(id);

        // 게시글 수정
        shop.update(requestDto);

        return shopRepository.findById(id).stream().map(PostResponseDto::new).toList().get(0);
    }

    // 게시글 삭제
    public Long deletePost(Long id) {
        // 해당 게시글 DB에 존재하는지 확인
        Shop shop = findPostById(id);

        // 게시글 삭제
        shopRepository.delete(shop);

        return id;
    }

    private Shop findPostById(Long id) {
        return shopRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물 존재하지 않음.")
        );
    }


}
