package com.sparta.goal.dto;

import com.sparta.goal.entity.Shop;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private int id;
    private String username;
    private String title;
    private String content;
    private int price;

    public PostResponseDto(Shop shop) {
        this.id = shop.getId();
        this.username = shop.getUsername();
        this.title = shop.getTitle();
        this.content = shop.getContent();
        this.price = shop.getPrice();
    }
}
