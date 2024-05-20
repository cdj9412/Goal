package com.sparta.goal.entity;

import com.sparta.goal.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Item")
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "price")
    private int price;
    @Column(name = "username")
    private String username;

    public Shop(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();
    }
}
