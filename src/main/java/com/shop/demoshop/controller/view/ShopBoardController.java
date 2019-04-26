package com.shop.demoshop.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop/shop")
public class ShopBoardController {

    @GetMapping("/shopList")
    public String shopList() {
        return "/shop/list";
    }

    @GetMapping("/shopDetails")
    public String shopDetails(@RequestParam Long shopNo) {
        return "/shop/details";
    }
}
