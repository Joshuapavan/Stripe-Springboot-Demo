package com.joshuapavan.stripepaymentexampleapp.controllers;

import com.joshuapavan.stripepaymentexampleapp.model.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${stripe.api.publicKey}")
    private String publicKey;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("request", new Request());
        return "checkout";
    }
}
