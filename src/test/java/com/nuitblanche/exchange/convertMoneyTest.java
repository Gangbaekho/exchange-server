package com.nuitblanche.exchange;

import com.nuitblanche.exchange.service.ExchangeService;
import com.nuitblanche.exchange.service.ExchangeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class convertMoneyTest {

    @Autowired
    private ExchangeServiceImpl exchangeService;

    @Test
    public void 기본_변환테스트(){

        Double money = 412.1243;
        String stringedMoney = exchangeService.doubleMoneyToStringMoney(money);

        assertThat(stringedMoney).isEqualTo("412.12");
    }

    @Test
    public void 세자리수_콤마_테스트(){
        Double money = 1412.1243;
        String stringedMoney = exchangeService.doubleMoneyToStringMoney(money);

        assertThat(stringedMoney).isEqualTo("1,412.12");
    }

    @Test
    public void 소수점_하나밖에없는_소수_테스트(){
        Double money = 1412.1;
        String stringedMoney = exchangeService.doubleMoneyToStringMoney(money);

        assertThat(stringedMoney).isEqualTo("1,412.10");
    }

    @Test
    public void 소수점없는_소수_테스트(){
        Double money = 1412.0;
        String stringedMoney = exchangeService.doubleMoneyToStringMoney(money);

        assertThat(stringedMoney).isEqualTo("1,412.00");
    }
}
