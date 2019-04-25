package com.shop.demoshop.model.shop;

import com.shop.demoshop.model.Auditing;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Shop extends Auditing {
    // 글번호, 글쓴이, 내용, 사진, 글 올린 날짜, 수량, 금액

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopNo;

    private String writer;

    private String title;

    private String content;

    private String fileName;

    private int quantity;

    private int price;

}
