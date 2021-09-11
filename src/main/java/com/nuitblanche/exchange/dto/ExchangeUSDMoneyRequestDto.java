package com.nuitblanche.exchange.dto;

import com.nuitblanche.exchange.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeUSDMoneyRequestDto {

    private Currency currency;
    private int amountOfUDSMoney;

    @Builder
    public ExchangeUSDMoneyRequestDto(Currency currency, int amountOfUDSMoney) {
        this.currency = currency;
        this.amountOfUDSMoney = amountOfUDSMoney;
    }
}
