package com.nuitblanche.exchange.service;

import com.nuitblanche.exchange.component.ExchangeRestTemplate;
import com.nuitblanche.exchange.dto.ExchangeUSDMoneyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public Double exchangeUSDMoneyTo(ExchangeUSDMoneyRequestDto requestDto) {

        String requestUrl = "/live?access_key=";

        Map<String,Object> response = restTemplate.getRequest(requestUrl);
        Map<String,Object> quotes = (Map<String,Object>) response.get("quotes");

        Double currencyRate = (Double) quotes.get(requestDto.getCurrency().getQuote());

        return requestDto.getAmountOfUDSMoney() * currencyRate;
    }
}
