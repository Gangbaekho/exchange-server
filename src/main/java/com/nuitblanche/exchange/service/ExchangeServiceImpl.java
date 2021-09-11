package com.nuitblanche.exchange.service;

import com.nuitblanche.exchange.component.ExchangeRestTemplate;
import com.nuitblanche.exchange.dto.CurrencyRateRequestDto;
import com.nuitblanche.exchange.dto.CurrencyRateResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyResponseDto;
import com.nuitblanche.exchange.dto.ExchangeMoneyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService{

    @Value("${exchange.baseurl}")
    private String baseUrl;

    @Value("${exchange.accessKey}")
    private String accessKey;

    private final ExchangeRestTemplate restTemplate;

    @Override
    public ExchangeMoneyResponseDto exchangeUSDMoneyTo(ExchangeMoneyRequestDto requestDto) {

        String requestUrl = "/live?access_key=";

        Map<String,Object> response = restTemplate.getRequest(requestUrl);
        Map<String,Object> quotes = (Map<String,Object>) response.get("quotes");

        Double currencyRate = (Double) quotes.get(requestDto.getCurrency().getQuote());
        String formattedCurrencyRate = doubleMoneyToStringMoney(currencyRate);

        Double exchange =  requestDto.getAmountOfMoney() * currencyRate ;
        String formattedExchangedMoney = doubleMoneyToStringMoney(exchange);

        ExchangeMoneyResponseDto responseDto = ExchangeMoneyResponseDto.builder()
                .exchangedMoney(formattedExchangedMoney)
                .build();

        return responseDto;
    }

    @Override
    public CurrencyRateResponseDto getCurrencyRate(CurrencyRateRequestDto requestDto) {

        String requestUrl = "/live?access_key=";

        Map<String,Object> response = restTemplate.getRequest(requestUrl);
        Map<String,Object> quotes = (Map<String,Object>) response.get("quotes");

        Double currencyRate = (Double) quotes.get(requestDto.getCurrency().getQuote());
        String formattedCurrencyRate = doubleMoneyToStringMoney(currencyRate);

        CurrencyRateResponseDto responseDto =  CurrencyRateResponseDto.builder()
                .currencyRate(formattedCurrencyRate)
                .build();

        return responseDto;
    }

    private String doubleMoneyToStringMoney(double money){

        Double flooredMoney =  Math.floor(money* 100) / 100;
        String moneyString = String.format("%.2f", flooredMoney);

        String formattedMoney = NumberFormat.getInstance().format(Double.parseDouble(moneyString));

        int indexOfComma = formattedMoney.indexOf('.');
        if(indexOfComma == -1){
            return formattedMoney + ".00";
        }else if(indexOfComma == formattedMoney.length() - 2){
            return formattedMoney + "0";
        }else{
            return formattedMoney;
        }
    }
}
