package com.github.supercodingspringproject.web.controller;

import com.github.supercodingspringproject.web.dto.OrderRequest;
import com.github.supercodingspringproject.web.dto.WishRequest;
import com.github.supercodingspringproject.web.service.UserOrderWishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/user-order-wish")
@Slf4j
public class UserOrderWishController {

    private final UserOrderWishService userOrderWishService;

    @PostMapping("/order")
    public String makeOrderModel(@RequestBody OrderRequest orderRequest){
        Double totalPrice = userOrderWishService.makeOrder(orderRequest);
        return "구매하신 물품 " + totalPrice + "이고 예약 완료되었습니다.";
    }

    @PostMapping("/wish")
    public String makeWishModel(@RequestBody WishRequest wishRequest){
        Boolean isSuccess = userOrderWishService.makeWish(wishRequest);
        return isSuccess ? "물품 찜 되었습니다." : "물품 찜 실패했습니다.";
    }
}
