package com.nuitblanche.exchange.enums;

import lombok.Getter;

@Getter
public enum Currency {

    KRW("한국","USDKRW"), JPY("일본","USDJPY"), PHP("필리핀","USDPHP");

    private String nation;
    private String quote;

    Currency(String nation,String quote) {
        this.nation = nation;
        this.quote = quote;
    }
}
