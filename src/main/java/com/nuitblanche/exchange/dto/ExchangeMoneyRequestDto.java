package com.nuitblanche.exchange.dto;

import com.nuitblanche.exchange.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeMoneyRequestDto {

    private Currency currency;
    private int amountOfMoney;

    @Builder
    public ExchangeMoneyRequestDto(Currency currency, int amountOfMoney) {
        this.currency = currency;
        this.amountOfMoney = amountOfMoney;
    }
}
