package com.nuitblanche.exchange.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class ExchangeRestTemplate extends RestTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRestTemplate.class);

    @Value("${exchange.baseurl}")
    private String exchangeBaseUrl;

    @Value("${exchange.accessKey}")
    private String accessKey;

    public Map<String, Object> getRequest(String requestUri) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(exchangeBaseUrl + requestUri + accessKey);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(null,headers);

        ResponseEntity<Map> responseEntity = exchange(uriComponentsBuilder.build().toUriString(), HttpMethod.GET, requestEntity, Map.class);

        Map<String,Object> body = responseEntity.getBody();

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            LOGGER.error("requestUri : {}", requestUri);
            throw new IllegalArgumentException("잘못된 요청입니다.");
        }
        return body;
    }

}
