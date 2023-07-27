package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
    private Integer id;
    @Column(length = 20, nullable=false)
    private BigDecimal bakiye;

    @Column(length = 20, nullable=false)
    private CurrencyType currencyType;


    public Balance(BigDecimal bakiye) {
        this.bakiye = bakiye;
    }

    public Balance() {

    }


    public Integer getUser_id() {
        return id;
    }

    public Balance setUser_id(Integer id) {
        this.id = id;
        return null;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getBakiye() {
        return bakiye;
    }

    public void setBakiye(BigDecimal bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", bakiye=" + bakiye +
                ", currencyType=" + currencyType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        if (!Objects.equals(id, balance.id)) return false;
        if (!Objects.equals(bakiye, balance.bakiye)) return false;
        return currencyType == balance.currencyType;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bakiye != null ? bakiye.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        return result;
    }
}
