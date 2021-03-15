package com.rodney073.kifliproject.service;

import com.rodney073.kifliproject.models.ChangeRate;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Service
public class CurrencyService {

    private ArrayList<ChangeRate> changeRate;

    public CurrencyService() {
        changeRate = new ArrayList<>();
    }

    public void addCurrencies(ChangeRate changeRate) {
        this.changeRate.add(changeRate);
    }

    public ArrayList<ChangeRate> getChangeRates() {
        return changeRate;
    }

    public String formatNumber (Double number) {
        DecimalFormat df2 = new DecimalFormat("#.####");
        return df2.format(number);
    }
    
}
