package com.rodney073.kifliproject.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountdownController {
    
    @GetMapping ("/countdown")
    public String indexPage(Model model) throws ParseException {
        model.addAttribute("endDate", new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
    
        return "countdown";
    }
}
