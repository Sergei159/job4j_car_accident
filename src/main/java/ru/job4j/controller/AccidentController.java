package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;


@Controller
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService service) {
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

    @GetMapping("/updateAccident/{accidentId}")
    public String updateAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("accident", accidentService.findById(id));
        return "updateAccident";
    }

    @PostMapping("/updateAccident")
    public String updateItem(@ModelAttribute Accident accident) {
        Accident tempAccident = accidentService.findById(accident.getId());
        accidentService.update(accident);
        return "redirect:/index";
    }

    @GetMapping("/deleteAccident/{accidentId}")
    public String deleteItem(@PathVariable("accidentId") int id) {
        accidentService.delete(id);
        return "redirect:/index";
    }

}
