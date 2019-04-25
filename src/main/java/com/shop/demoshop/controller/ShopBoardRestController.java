package com.shop.demoshop.controller;

import com.shop.demoshop.model.api.request.ShopRequest;
import com.shop.demoshop.model.shop.Shop;
import com.shop.demoshop.repository.ShopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/board")
public class ShopBoardRestController {

    @Autowired
    private ShopRepository shopRepository;


    //TODO 글 목록조회, 글 등록, 글 보기, 글 수정, 글 삭제
    @GetMapping("/shopList")
    public ResponseEntity<?> shopList() {
        List<Shop> shopList = shopRepository.findAll();
        return ResponseEntity.ok(shopList);
    }

    @PostMapping("/shopRegist")
    public ResponseEntity shopRegist(@RequestBody ShopRequest shopRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Shop shop = modelMapper.map(shopRequest, Shop.class);
        shopRepository.save(shop);
        return ResponseEntity.ok("successfully");
    }

    @PostMapping("/shopDetails/{shopNo}")
    public Optional<Shop> shopDetails(@PathVariable Long shopNo) {
         Optional<Shop> shop = shopRepository.findById(shopNo);
        return shop;
    }

    @PutMapping("/shopEdit/{shopNo}")
    public ResponseEntity shopEdit(@PathVariable Long shopNo, @RequestBody ShopRequest shopRequest) {
        Optional<Shop> shop = shopRepository.findById(shopNo);

        /*Shop shopEdit = Shop.builder()
                        .shopNo(shopNo)
                        .content(shopRequest.getContent())
                        .fileName(shopRequest.getFileName())
                        .title(shopRequest.getTitle())
                        .quantity(shopRequest.getQuantity())
                        .price(shopRequest.getPrice())
                        .build();*/

        Shop shopEdit = shop.get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(shopRequest, shopEdit);

        shopRepository.save(shopEdit);
        return ResponseEntity.ok("수정완료");
    }

    @DeleteMapping("/shopDelete/{shopNo}")
    public ResponseEntity shopDelete(@PathVariable Long shopNo) {
        shopRepository.deleteById(shopNo);
        return ResponseEntity.ok("삭제완료");
    }



}
