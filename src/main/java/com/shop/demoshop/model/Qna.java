package com.shop.demoshop.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Qna {
    //질문넘버, 등록날짜, 등록자, 질문내용, 비밀글 여부 (..)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaNo;

    private String writer;

    private String qnaContent;

    private char private_yn;

}
