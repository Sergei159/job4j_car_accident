package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        List<Integer> integerList = List.of(1, 5, 6, 7, 8);
        model.addAttribute("integerList", integerList);
        return "index";
    }
}
