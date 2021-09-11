package com.nuitblanche.exchange.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyRateResponseDto {

    private String currencyRate;

    @Builder
    public CurrencyRateResponseDto(String currencyRate) {
        this.currencyRate = currencyRate;
    }
}
