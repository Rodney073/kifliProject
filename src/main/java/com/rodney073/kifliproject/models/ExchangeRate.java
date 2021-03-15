package com.rodney073.kifliproject.models;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExchangeRate {
    protected Map<String, Double> rates;
    protected String base;
    protected String date;
    
}
