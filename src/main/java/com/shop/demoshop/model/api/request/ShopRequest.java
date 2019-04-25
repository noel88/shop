package com.shop.demoshop.model.api.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter @Getter
public class ShopRequest {
    // 내용, 사진, 수량, 금액

    private String title;

    private String content;

  /*  private MultipartFile file;*/

    private String filename;

    private int quantity;

    private int price;

}
