package com.shop.demoshop.repository;

import com.shop.demoshop.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
