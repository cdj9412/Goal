package com.sparta.goal.repository;

import com.sparta.goal.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findAllByOrderById();

}
