package com.nuitblanche.exchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APIRequestTest {

    @Value("${exchange.baseurl}")
    private String baseUrl;

    @Value("${exchange.accessKey}")
    private String accessKey;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 환율_API_요청(){

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/live?access_key=" + accessKey);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(null,headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(uriComponentsBuilder.build().toUriString(), HttpMethod.GET, requestEntity, Map.class);

        Map<String,Object> body = responseEntity.getBody();
        Map<String,Object> quotes = (Map<String,Object>) body.get("quotes");

        assertThat(quotes.isEmpty()).isEqualTo(false);

    }



}
