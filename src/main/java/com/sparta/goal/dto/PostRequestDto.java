package com.sparta.goal.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}
