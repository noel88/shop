package com.shop.demoshop.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop/qna")
public class QnaBoardController {

    @GetMapping("/qnaList")
    public String qnaList() {
        return "/qna/list";
    }
}
