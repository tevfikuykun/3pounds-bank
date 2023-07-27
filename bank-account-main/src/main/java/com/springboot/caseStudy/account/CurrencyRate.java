package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
    private Integer id;
    @Column(length = 20, nullable = false)
    private Integer newBalance;
    @Column(name = "2",length = 20, nullable = false)
    private String newType ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "id=" + id +
                ", newBalance=" + newBalance +
                ", newType='" + newType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyRate that = (CurrencyRate) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(newBalance, that.newBalance)) return false;
        return Objects.equals(newType, that.newType);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (newBalance != null ? newBalance.hashCode() : 0);
        result = 31 * result + (newType != null ? newType.hashCode() : 0);
        return result;
    }
}
