package com.nuitblanche.exchange.controller;

import com.nuitblanche.exchange.dto.ExchangeUSDMoneyRequestDto;
import com.nuitblanche.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/api/v1/exchanges")
    public Double exchnageUSDMoneyTo(@RequestBody ExchangeUSDMoneyRequestDto requestDto){

        return exchangeService.exchangeUSDMoneyTo(requestDto);
    }
}
