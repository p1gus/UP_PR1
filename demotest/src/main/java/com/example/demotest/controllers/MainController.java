package com.example.demotest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("Title", "Главная страница");
        return "home";
    }
    @GetMapping("/home")
    public String get(@RequestParam(value="first", required = false) double first,
                      @RequestParam(value="second", required = false) double second,
                      @RequestParam(value="action", required = false ) String math, Model model) {


        double otvet = switch (math) {
            case "+"-> first + second;
            case "-"-> first - second;
            case "*"-> first * second;
            case "/"-> first / second;
            default -> 0;
        };
        model.addAttribute("result", otvet);

        return "result";
    }

    @PostMapping("/home")
    public String post(@RequestParam(value="first", required = false) double first,
                       @RequestParam(value="second", required = false) double second,
                       @RequestParam(value="action", required = false ) String action, Model model) {


        double otvet = switch (action) {
            case "+"-> first + second;
            case "-"-> first - second;
            case "*"-> first * second;
            case "/"-> first / second;
            default -> 0;
        };
        model.addAttribute("result", otvet);

        return "result";
    }
}
