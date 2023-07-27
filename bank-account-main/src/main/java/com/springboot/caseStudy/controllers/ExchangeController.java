package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.CurrencyRate;
import com.springboot.caseStudy.dto.CurrencyBalance;
import com.springboot.caseStudy.dto.CurrencyChange;
import com.springboot.caseStudy.exceptions.NotFoundException;
import com.springboot.caseStudy.service.AccountService;
import com.springboot.caseStudy.service.ExchangeService;
import com.springboot.caseStudy.util.GenericResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @RequestMapping(value = "/account/exchange", method = RequestMethod.POST)
    public GenericResponse moneyChange(@RequestBody CurrencyChange currencyChange) {
        try {
            CurrencyRate currencyRate=new CurrencyRate();
            currencyRate.setId(currencyChange.getId());
            currencyRate.setNewType(currencyChange.getNewType());
            int firstVal = 0,lastVal=0;
            if (currencyChange.getBase().equalsIgnoreCase("EURO")){
                firstVal=30;
            }
            else if (currencyChange.getBase().equalsIgnoreCase("USD")){
                firstVal=20;
            }
            else {
                firstVal=1;
            }
            if (currencyChange.getNewType().equalsIgnoreCase("EURO")){
                lastVal=30;
            }
            else if (currencyChange.getNewType().equalsIgnoreCase("USD")){
                lastVal=20;
            }
            else {
                lastVal=1;
            }
            currencyRate.setNewBalance(changeFunc(currencyChange.getMiktar(),firstVal,lastVal));
            CurrencyRate updateRate = exchangeService.save(currencyRate);
            return new GenericResponse("success",updateRate);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

    public Integer changeFunc(int ilk_miktar,int ilk_birim,int son_birim){
        int i = ilk_birim;
        int j = son_birim;

        int newMiktar=((ilk_miktar)/(j))*(i);


        return newMiktar;
    }
}
