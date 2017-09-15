package com.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeWeb {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "home";
    }
}
