package com.springboot.caseStudy.repositories;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.CurrencyRate;
import com.springboot.caseStudy.dto.CurrencyChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<CurrencyRate, Integer> {


}
