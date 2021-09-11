package com.nuitblanche.exchange.service;

import com.nuitblanche.exchange.dto.ExchangeUSDMoneyRequestDto;

public interface ExchangeService {

    Double exchangeUSDMoneyTo(ExchangeUSDMoneyRequestDto requestDto);
}
