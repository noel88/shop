package com.shop.demoshop.model.api.request;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class QnaRequest {

    private String writer;

    private String qnaContent;

    private char private_yn;

}
