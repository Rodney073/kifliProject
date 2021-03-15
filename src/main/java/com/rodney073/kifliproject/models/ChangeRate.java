package com.rodney073.kifliproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChangeRate {
    protected CurrencyEnum base;
    protected CurrencyEnum to;
    protected int number;

    public ChangeRate() {
        this.base = CurrencyEnum.GBP;
        this.to = CurrencyEnum.HUF;
        this.number = 1;
    }


}