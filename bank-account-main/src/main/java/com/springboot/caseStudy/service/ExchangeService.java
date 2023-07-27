package com.springboot.caseStudy.service;


import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.account.CurrencyRate;
import com.springboot.caseStudy.dto.CurrencyChange;
import com.springboot.caseStudy.dto.Withdraw;
import com.springboot.caseStudy.exceptions.InsufficientFundsException;
import com.springboot.caseStudy.exceptions.NotFoundException;
import com.springboot.caseStudy.repositories.ExchangeRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {


    private ExchangeRepository exchangeRepository;

    public ExchangeService(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public List<CurrencyRate> listAll() {
        return (List<CurrencyRate>) exchangeRepository.findAll();
    }

    public CurrencyRate save(CurrencyRate currencyRate) {
        return exchangeRepository.save(currencyRate);
    }



}
