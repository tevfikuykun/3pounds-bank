package com.springboot.caseStudy.dto;

import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.account.CurrencyRate;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table
public class CurrencyChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
    private Integer id;
    @Column(length = 20, nullable = false)
    private String base;
    @Column(length = 20, nullable = false)
    private String newType;

    @Column(length = 20, nullable = false)
    private Integer miktar;



    @Override
    public String toString() {
        return "CurrencyChange{" +
                "id=" + id +
                ", base='" + base + '\'' +
                ", newType='" + newType + '\'' +
                ", miktar=" + miktar +
                ", currencyRate=" + currencyRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyChange that = (CurrencyChange) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(base, that.base)) return false;
        if (!Objects.equals(newType, that.newType)) return false;
        if (!Objects.equals(miktar, that.miktar)) return false;
        return Objects.equals(currencyRate, that.currencyRate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (newType != null ? newType.hashCode() : 0);
        result = 31 * result + (miktar != null ? miktar.hashCode() : 0);
        result = 31 * result + (currencyRate != null ? currencyRate.hashCode() : 0);
        return result;
    }



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private CurrencyRate currencyRate;

    public CurrencyRate getCurrencyRate() {
        return currencyRate;
    }

    public CurrencyChange(Integer id, String base, String newType, Integer miktar) {
        this.id = id;
        this.base = base;
        this.newType = newType;
        this.miktar = miktar;
    }

    public CurrencyChange(){

    }

    public void setCurrencyRate(CurrencyRate currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

}
