package com.nuitblanche.exchange.controller;

import com.nuitblanche.exchange.dto.CurrencyRateRequestDto;
import com.nuitblanche.exchange.dto.CurrencyRateResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyRequestDto;
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
    public ExchangeMoneyResponseDto exchnageUSDMoneyTo(@RequestBody ExchangeMoneyRequestDto requestDto){

        return exchangeService.exchangeUSDMoneyTo(requestDto);
    }

    @PostMapping("/api/v1/currency-rates")
    public CurrencyRateResponseDto getCurrencyRate(@RequestBody CurrencyRateRequestDto requestDto){

        return exchangeService.getCurrencyRate(requestDto);
    }
}
