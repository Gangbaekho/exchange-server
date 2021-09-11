package com.nuitblanche.exchange.dto;

import com.nuitblanche.exchange.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyRateRequestDto {

    private Currency currency;

    @Builder
    public CurrencyRateRequestDto(Currency currency) {
        this.currency = currency;
    }
}
