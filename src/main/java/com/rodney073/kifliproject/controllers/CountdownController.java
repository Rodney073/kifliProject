package com.rodney073.kifliproject.controllers;


import java.text.ParseException;
//import java.text.SimpleDateFormat;

import com.rodney073.kifliproject.models.Event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountdownController {

    @GetMapping ("/countdown")
    public String main(Model model) {
        model.addAttribute("event", new Event());
        return "datetime";
    }


    @PostMapping ("/countdown")
    public String indexPage(Event event, Model model) throws ParseException {
        //model.addAttribute("endDate", new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        model.addAttribute("event", event);

        return "countdown";
    }
    /*    @PostMapping
    public String save(Event event, Model model) {
        model.addAttribute("event", event);
        return "saved";
    }*/
}
