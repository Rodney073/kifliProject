package com.rodney073.kifliproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalendarController {
    
    @GetMapping ("/calendar")
    public String indexPage(Model model) {
    
        return "calendar";
    }
}
