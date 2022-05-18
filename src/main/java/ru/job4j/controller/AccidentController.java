package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;
import ru.job4j.service.AccidentTypeService;


@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;

    public AccidentController(AccidentService service, AccidentTypeService accidentTypeService) {
        this.accidentService = service;
        this.accidentTypeService = accidentTypeService;
    }


    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }

    @GetMapping("/addAccident")
    public String addAccident(Model model) {
        model.addAttribute("types", accidentTypeService.findAll());
        return "addAccident";
    }

    @PostMapping("/createAccident")
    public String saveAccident(@ModelAttribute Accident accident, @RequestParam("type.id") int id,
                               Model model) {
        accident.setType(accidentTypeService.findById(id));
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
        model.addAttribute("types", accidentTypeService.findAll());
        return "updateAccident";
    }

    @PostMapping("/updateAccident")
    public String updateItem(@ModelAttribute Accident accident, @RequestParam("type.id") int id) {
        accident.setType(accidentTypeService.findById(id));
        accidentService.update(accident);
        return "redirect:/index";
    }

    @GetMapping("/deleteAccident/{accidentId}")
    public String deleteItem(@PathVariable("accidentId") int id) {
        accidentService.delete(id);
        return "redirect:/index";
    }

}
