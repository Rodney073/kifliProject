package com.rodney073.kifliproject.controllers;

import com.rodney073.kifliproject.models.ChangeRate;
import com.rodney073.kifliproject.models.CurrencyEnum;
import com.rodney073.kifliproject.models.ExchangeRate;
import com.rodney073.kifliproject.service.CurrencyService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @GetMapping ("/currencies")
    public String indexPage(Model model){

        RestTemplate restTemplate = new RestTemplate();
        
        CurrencyEnum base = null;
        CurrencyEnum to = null;
        int number = 1;

        if (!currencyService.getChangeRates().isEmpty()) {

            int lastListItem = currencyService.getChangeRates().size()-1;

            base = currencyService.getChangeRates().get(lastListItem).getBase();
            to = currencyService.getChangeRates().get(lastListItem).getTo();
            number = currencyService.getChangeRates().get(lastListItem).getNumber();

            model.addAttribute("base", base);
            model.addAttribute("to", to);
            model.addAttribute("number", number);

            if (base == null && to == null ) {
                model.addAttribute("result", "Choose currencies.");
            }
            else if (base == null || to == null ) {
                model.addAttribute("result", "Choose the other currency too.");
            }
            else {

                if (base.equals(to) ){
                    model.addAttribute("result", number);
                }
                 else {
                    ExchangeRate exchangeRate = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base="+base+"&symbols="+to, ExchangeRate.class);
                    String result = currencyService.formatNumber((exchangeRate.getRates().get(to.toString()) ) * number );
                    model.addAttribute("result", result);
                 }

             }

        }

        return "currency"; 
    }

    @PostMapping ("/currencies")
    public String setCurrencies(Model model, @ModelAttribute ChangeRate changeRate){
        
        ChangeRate newCR = new ChangeRate(changeRate.getBase(), changeRate.getTo(), changeRate.getNumber());
        currencyService.addCurrencies(newCR);

        return "redirect:/currencies"; 
    }

}