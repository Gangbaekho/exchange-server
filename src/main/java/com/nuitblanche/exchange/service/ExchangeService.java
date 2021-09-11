package com.nuitblanche.exchange.service;

import com.nuitblanche.exchange.dto.CurrencyRateRequestDto;
import com.nuitblanche.exchange.dto.CurrencyRateResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyRequestDto;

public interface ExchangeService {

    ExchangeMoneyResponseDto exchangeUSDMoneyTo(ExchangeMoneyRequestDto requestDto);

    CurrencyRateResponseDto getCurrencyRate(CurrencyRateRequestDto requestDto);
}
