package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {

    private final AccidentService accidentService;

    public IndexController(AccidentService service) {
        this.accidentService = service;
    }


    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }

    @GetMapping("/addAccident")
    public String addAccident(Model model) {
        return "addAccident";
    }

    @PostMapping("/createAccident")
    public String saveAccident(@ModelAttribute Accident accident,
                               Model model) {
        accidentService.add(accident);
        model.addAttribute("accidents", accidentService.findAll());
        return "redirect:/index";
    }

    @GetMapping("/accidentInfo/{accidentId}")
    public String itemInfo(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("accidents", accidentService.findAll());
        return "accidentInfo";
    }
}
