package com.nuitblanche.exchange.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeMoneyResponseDto {

    private String exchangedMoney;

    @Builder
    public ExchangeMoneyResponseDto(String exchangedMoney) {
        this.exchangedMoney = exchangedMoney;
    }
}
