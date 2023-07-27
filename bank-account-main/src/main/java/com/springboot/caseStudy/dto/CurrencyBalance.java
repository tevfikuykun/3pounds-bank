package com.springboot.caseStudy.dto;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class CurrencyBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
    private Integer id;

    @Column(length = 20, nullable = false)
    private Integer EURO;

    @Column(length = 20, nullable = false)
    private Integer TRY;

    @Column(length = 20, nullable = false)
    private Integer USD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEURO() {
        return EURO;
    }

    public void setEURO(Integer EURO) {
        this.EURO = EURO;
    }

    public Integer getTRY() {
        return TRY;
    }

    public void setTRY(Integer TRY) {
        this.TRY = TRY;
    }

    public Integer getUSD() {
        return USD;
    }

    public void setUSD(Integer USD) {
        this.USD = USD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyBalance that = (CurrencyBalance) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(EURO, that.EURO)) return false;
        if (!Objects.equals(TRY, that.TRY)) return false;
        return Objects.equals(USD, that.USD);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (EURO != null ? EURO.hashCode() : 0);
        result = 31 * result + (TRY != null ? TRY.hashCode() : 0);
        result = 31 * result + (USD != null ? USD.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyBalance{" +
                "id=" + id +
                ", EURO=" + EURO +
                ", TRY=" + TRY +
                ", USD=" + USD +
                '}';
    }
}